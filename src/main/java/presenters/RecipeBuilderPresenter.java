package presenters;

import useCases.RecipeBuilderResponseModel;

public interface RecipeBuilderPresenter {
    RecipeBuilderResponseModel prepareSuccessView(RecipeBuilderResponseModel recipeResponse);

    RecipeBuilderResponseModel prepareFailView(String error);
}
