package controllers;

import useCases.RecipeBuilder;
import useCases.RecipeBuilderInputBoundary;
import useCases.RecipeBuilderResponseModel;

public class RecipeBuilderController {
    final RecipeBuilderInputBoundary recipeBuilderInput;

    public RecipeBuilderController(RecipeBuilderInputBoundary recipeBuilderInput) {
        this.recipeBuilderInput = recipeBuilderInput;
    }

    RecipeBuilderResponseModel create(String[] APIOutput) {
        RecipeBuilder requestModel = new RecipeBuilder(APIOutput);

        return recipeBuilderInput.createRecipe(requestModel);
    }
}
