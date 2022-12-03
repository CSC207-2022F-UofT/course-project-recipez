package use_cases.searchUseCase;

import database.DatabaseGateway;
import entities.fridge.CommonFridge;
import gateways.IApiGateway;
import entities.recipe.RecipeFactory;
import presenters.search.SearchPresenter;

/**
 * Interactor for Search use case
 */
public class SearchInteractor implements SearchInputBoundary {
    private final IApiGateway apiCaller;
    private final DatabaseGateway database;
    private final RecipeFactory recipeFactory;
    private final SearchPresenter searchPresenter;

    public SearchInteractor(IApiGateway apiCaller, DatabaseGateway database, RecipeFactory recipeFactory, SearchPresenter searchPresenter) {
        this.apiCaller = apiCaller;
        this.database = database;
        this.recipeFactory = recipeFactory;
        this.searchPresenter = searchPresenter;
    }

    /**
     * Searches for recipes that can be made with inputted ingredients
     *
     * @param model The user's search input
     */
    public SearchResponseModel search(SearchRequestModel model) {
        CommonFridge fridge = ((CommonFridge) database.get(model.getUsername()).getFridge());
        String APIResponse = this.apiCaller.send(
                fridge.printIngredient(),
                model.getMealType(),
                model.getCalories(),
                model.getTime()
        );
        SearchResponseModel searchResponseModel = new SearchResponseModel(recipeFactory, APIResponse);

        if (APIResponse == null) {
            searchPresenter.prepareFailView("API Output was incompatible.");
            return searchResponseModel;
        }
        // Print Statement to show API response without results page
        System.out.println("API Response: " + APIResponse);
        searchPresenter.prepareSuccessView(searchResponseModel);
        return searchResponseModel;
    }
}
