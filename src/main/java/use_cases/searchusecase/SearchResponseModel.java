package use_cases.searchusecase;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.recipe.CommonRecipeFactory;
import entities.recipe.Recipe;
import entities.recipe.RecipeFactory;

import java.util.ArrayList;

/**
 * Output model for search use case
 */
public class SearchResponseModel {
    RecipeFactory recipeFactory;
    private final String apiOutput;

    public SearchResponseModel(RecipeFactory recipeFactory, String apiOutput) {
        this.recipeFactory = recipeFactory;
        this.apiOutput = apiOutput;
    }

    public String getApiOutput() {
        return apiOutput;
    }
}
