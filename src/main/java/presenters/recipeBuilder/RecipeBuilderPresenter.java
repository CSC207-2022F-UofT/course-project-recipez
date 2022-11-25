package presenters.recipeBuilder;

import use_cases.recipeBuilder.RecipeBuilderResponseModel;

public interface RecipeBuilderPresenter {
    RecipeBuilderResponseModel prepareSuccessView(RecipeBuilderResponseModel recipeResponse);

    RecipeBuilderResponseModel prepareFailView(String error);
}
