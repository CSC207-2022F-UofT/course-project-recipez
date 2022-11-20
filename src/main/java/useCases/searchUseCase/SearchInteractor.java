package useCases.searchUseCase;

import database.DatabaseGateway;
import gateways.IApiGateway;
import entities.RecipeFactory;
import fridge.Fridge;
import useCases.RecipeBuilderResponseModel;

/**
 * Interactor for Search use case
 */
public class SearchInteractor implements SearchInputBoundary {
    private final IApiGateway apiCaller;
    private final DatabaseGateway database;
    private final RecipeFactory recipeFactory;
    public SearchInteractor(IApiGateway apiCaller, DatabaseGateway database, RecipeFactory recipeFactory) {
        this.apiCaller = apiCaller;
        this.database = database;
        this.recipeFactory = recipeFactory;
    }

    /**
     * Searches for recipes that can be made with inputted ingredients
     * @param model The user's search input
     * @return Recipe results
     */
    public SearchResponseModel search(SearchRequestModel model) {
        Fridge fridge = ((Fridge) database.get(model.getUsername()).get(0));
        String APIResponse = this.apiCaller.send(
                String.join(",", fridge.allIngredientValues()),
                model.getMealType(),
                model.getCalories(),
                model.getTime()
        );
        RecipeBuilderResponseModel response = new RecipeBuilderResponseModel(this.recipeFactory );
        return new SearchResponseModel(response.createRecipe(APIResponse));
    }
}
