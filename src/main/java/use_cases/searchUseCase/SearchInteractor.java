package use_cases.searchUseCase;

import database.DatabaseGateway;
import entities.fridge.CommonFridge;
import entities.recipe.Recipe;
import gateways.IApiGateway;
import entities.recipe.RecipeFactory;
import presenters.search.SearchPresenter;

import java.util.ArrayList;

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
     * @param model The user's search input
     * @return Recipe results
     */
    public SearchResponseModel search(SearchRequestModel model) {
        CommonFridge fridge = ((CommonFridge) database.get(model.getUsername()).get(0));
        String APIResponse = this.apiCaller.send(
                fridge.printIngredient(),
                model.getMealType(),
                model.getCalories(),
                model.getTime()
        );
        SearchResponseModel searchResponseModel = new SearchResponseModel(recipeFactory);
        ArrayList<Recipe> recipeOutput = searchResponseModel.getRecipe(APIResponse);

        if (recipeOutput == null) {
            return searchPresenter.prepareFailView("API Output was incompatible.");
        }
        // Print Statement to show API response without results page
        System.out.println("API Response: " + APIResponse);
        return searchPresenter.prepareSuccessView(searchResponseModel);
    }
}
