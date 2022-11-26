package presenters.search;

import UI.resultPage.ResultsPageViewModelInterface;
import use_cases.searchUseCase.SearchResponseModel;

public class SearchFormatter implements SearchPresenter {
    /**
     * Format for RecipeBuilder response for success view and fail view
     */
    private final ResultsPageViewModelInterface viewModelInterface;
    private final String apiOutput;

    public SearchFormatter(ResultsPageViewModelInterface viewModelInterface, String apiOutput) {
        this.viewModelInterface = viewModelInterface;
        this.apiOutput = apiOutput;
    }

    @Override
    public SearchResponseModel prepareSuccessView(SearchResponseModel searchResponse) {
        this.viewModelInterface.resultsSuccess(searchResponse.getRecipe(apiOutput));
        return searchResponse;
    }

    @Override
    public SearchResponseModel prepareFailView(String error) {
        this.viewModelInterface.resultsFailure(error);
        return null;
    }
}
