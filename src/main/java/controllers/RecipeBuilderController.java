package controllers;

import use_cases.recipeBuilder.RecipeBuilder;
import use_cases.recipeBuilder.RecipeBuilderInputBoundary;
import use_cases.recipeBuilder.RecipeBuilderResponseModel;
/**
 * Class RecipeBuilderController
 */
public class RecipeBuilderController {
    private final RecipeBuilderInputBoundary recipeBuilderInput;
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
