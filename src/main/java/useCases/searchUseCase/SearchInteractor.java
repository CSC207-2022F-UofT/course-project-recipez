package useCases.searchUseCase;

import entities.Recipe;
import entities.RequestURL;
import gateways.IApiGateway;
import entities.RequestURLFactory;

import java.io.IOException;

/**
 * Interactor for Search use case
 */
public class SearchInteractor implements SearchInputBoundary {
    private final IApiGateway apiCaller;
    private final RequestURLFactory requestURLFactory;
    public SearchInteractor(IApiGateway apiCaller, RequestURLFactory requestURLFactory) {
        this.apiCaller = apiCaller;
        this.requestURLFactory = requestURLFactory;
    }

    /**
     * Searches for recipes that can be made with inputted ingredients
     * @param model The user's search input
     * @return Recipe results
     * @throws IOException if an I/O error occurs when sending or receiving
     * @throws InterruptedException if the operation is interrupted
     */
    public SearchResponseModel search(SearchRequestModel model) throws IOException, InterruptedException {
        RequestURL url = this.requestURLFactory.createRequestURL(model.getIngredientsList());
        String APIResponse = this.apiCaller.send(url.getUrl());
        // TODO: Convert Response to Recipe Objects
        Recipe[] recipesOutputted = new Recipe[]{new Recipe()};
        return new SearchResponseModel(recipesOutputted);
    }
}
