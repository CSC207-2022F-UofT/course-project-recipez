package use_cases.searchUseCase;

import database.DatabaseGateway;
import entities.fridge.CommonFridge;
import gateways.IApiGateway;
import entities.recipe.RecipeFactory;
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
        CommonFridge fridge = ((CommonFridge) database.get(model.getUsername()).get(0));
        String APIResponse = this.apiCaller.send(
                fridge.printIngredient().substring(0, fridge.printIngredient().length() - 1),
                model.getMealType(),
                model.getCalories(),
                model.getTime()
        );
        // Print Statement to show API response without results page
        System.out.println("API Response: " + APIResponse);
        RecipeBuilderResponseModel response = new RecipeBuilderResponseModel(this.recipeFactory );
        return new SearchResponseModel(response.createRecipe(APIResponse));
    }
}
