package useCases;

public interface RecipeBuilderPresenter {
    RecipeBuilderResponseModel prepareSuccessView(RecipeBuilderResponseModel recipeResponse);

    RecipeBuilderResponseModel prepareFailView(String error);
}
