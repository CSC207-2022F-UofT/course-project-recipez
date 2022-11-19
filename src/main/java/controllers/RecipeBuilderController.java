package controllers;

import useCases.RecipeBuilder;
import useCases.RecipeBuilderInputBoundary;
import useCases.RecipeBuilderResponseModel;
/**
 * Class RecipeBuilderController
 */
public class RecipeBuilderController {
    final RecipeBuilderInputBoundary recipeBuilderInput;
    /**
     * Constructor
     * @param recipeBuilderInput : input for Recipe Builder
     */
    public RecipeBuilderController(RecipeBuilderInputBoundary recipeBuilderInput) {
        this.recipeBuilderInput = recipeBuilderInput;
    }

    RecipeBuilderResponseModel create(String APIOutput) {
        RecipeBuilder requestModel = new RecipeBuilder(APIOutput);

        return recipeBuilderInput.createRecipe(requestModel);
    }
}
