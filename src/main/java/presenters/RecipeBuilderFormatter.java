package presenters;

import useCases.RecipeBuilderResponseModel;

public class RecipeBuilderFormatter implements RecipeBuilderPresenter{
    /**
     * Format for RecipeBuilder response for success view and fail view
     */
    private final ResultsPageViewModelInterface viewModelInterface;
    private final String apiOutput;

    public RecipeBuilderFormatter(ResultsPageViewModelInterface viewModelInterface, String apiOutput) {
        this.viewModelInterface = viewModelInterface;
        this.apiOutput = apiOutput;
    }
    @Override
    public RecipeBuilderResponseModel prepareSuccessView(RecipeBuilderResponseModel responseModel) {
        this.viewModelInterface.resultsSuccess(responseModel.createRecipe(apiOutput));
        return responseModel;
    }

    @Override
    public RecipeBuilderResponseModel prepareFailView(String error) {
        this.viewModelInterface.resultsFailure(error);
        return null;
    }
}
