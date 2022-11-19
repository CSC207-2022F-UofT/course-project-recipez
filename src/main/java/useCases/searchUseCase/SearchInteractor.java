package useCases.searchUseCase;

import database.DatabaseGateway;
import entities.Recipe;
import fridge.Fridge;
import gateways.IApiGateway;

/**
 * Interactor for Search use case
 */
public class SearchInteractor implements SearchInputBoundary {
    private final IApiGateway apiCaller;
    private final DatabaseGateway database;
    public SearchInteractor(IApiGateway apiCaller, DatabaseGateway database) {
        this.apiCaller = apiCaller;
        this.database = database;
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
        // TODO: Convert Response to Recipe Objects
        Recipe[] recipesOutputted = new Recipe[]{new Recipe()};
        return new SearchResponseModel(recipesOutputted);
    }
}
