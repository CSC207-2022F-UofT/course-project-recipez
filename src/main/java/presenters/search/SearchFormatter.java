package presenters.search;

import UI.resultPage.ResultsPageViewModelInterface;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import use_cases.searchusecase.SearchResponseModel;

import java.util.ArrayList;
import java.util.Dictionary;

public class SearchFormatter implements SearchPresenter {
    /**
     * Format for RecipeBuilder response for success view and fail view
     */
    private final ResultsPageViewModelInterface viewModelInterface;

    public SearchFormatter(ResultsPageViewModelInterface viewModelInterface) {
        this.viewModelInterface = viewModelInterface;
    }

    @Override
    public SearchResponseModel prepareSuccessView(SearchResponseModel searchResponse) {
        ArrayList<Dictionary<String, Object>> formattedRecipes;
        formattedRecipes = searchResponse.formatJson();
        this.viewModelInterface.resultsSuccess(formattedRecipes);
        System.out.println(formattedRecipes);
        return searchResponse;
    }

    @Override
    public SearchResponseModel prepareFailView(String error) {
        this.viewModelInterface.resultsFailure(error);
        System.out.println(error);
        return null;
    }
}
