package presenters;

import useCases.RecipeBuilderResponseModel;

public class RecipeBuilderFormatter implements RecipeBuilderPresenter{
    @Override
    public RecipeBuilderResponseModel prepareSuccessView(RecipeBuilderResponseModel responseModel) {
        return responseModel;
    }

    @Override
    public RecipeBuilderResponseModel prepareFailView(String error) {
        return null;
    }
}
