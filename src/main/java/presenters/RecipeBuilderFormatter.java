package presenters;

import useCases.RecipeBuilderResponseModel;

public class RecipeBuilderFormatter implements RecipeBuilderPresenter{
    /**
     * Format for RecipeBuilder response for success view and fail view
     */
    @Override
    public RecipeBuilderResponseModel prepareSuccessView(RecipeBuilderResponseModel responseModel) {
        return responseModel;
    }

    @Override
    public RecipeBuilderResponseModel prepareFailView(String error) {
        return null;
    }
}
