package useCases.searchUseCase;

import entities.Recipe;
import gateways.IApiGateway;

/**
 * Interactor for Search use case
 */
public class SearchInteractor implements SearchInputBoundary {
    private final IApiGateway apiCaller;
    public SearchInteractor(IApiGateway apiCaller) {
        this.apiCaller = apiCaller;
    }

    /**
     * Searches for recipes that can be made with inputted ingredients
     * @param model The user's search input
     * @return Recipe results
     */
    public SearchResponseModel search(SearchRequestModel model) {
        String APIResponse = this.apiCaller.send(model.getIngredientsList());
        // TODO: Convert Response to Recipe Objects
        Recipe[] recipesOutputted = new Recipe[]{new Recipe()};
        return new SearchResponseModel(recipesOutputted);
    }
}
