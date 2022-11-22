package useCases;

import entities.recipe.Recipe;
import entities.recipe.RecipeFactory;
import presenters.recipeBuilder.RecipeBuilderPresenter;

import java.util.ArrayList;

/**
 * Class RecipeBuilderInteractor (Implements RecipeBuilderInputBoundary interface)
 */
public class RecipeBuilderInteractor implements RecipeBuilderInputBoundary{
    /**
     * recipeFactory: recipe
     * recipePresenter: presenter of Recipe Builder
     * recipeResponse: response model of Recipe Builder
     */
    final RecipeFactory recipeFactory;
    final RecipeBuilderPresenter recipePresenter;
    final RecipeBuilderResponseModel recipeResponse;

    public RecipeBuilderInteractor(RecipeFactory recipeFactory, RecipeBuilderPresenter recipePresenter, RecipeBuilderResponseModel recipeResponse) {
        this.recipeFactory = recipeFactory;
        this.recipePresenter = recipePresenter;
        this.recipeResponse = recipeResponse;
    }
    @Override
    public RecipeBuilderResponseModel createRecipe(RecipeBuilder requestModel) {
        String APIOutput = requestModel.getAPIOutput();
        RecipeBuilderResponseModel recipeResponseModel = new RecipeBuilderResponseModel(recipeFactory);
        ArrayList<Recipe> recipeOutput = recipeResponseModel.createRecipe(APIOutput);
        if (recipeOutput == null) {
            return recipePresenter.prepareFailView("API Output was incompatible.");
        }
        return recipePresenter.prepareSuccessView(recipeResponse);
    }
}
