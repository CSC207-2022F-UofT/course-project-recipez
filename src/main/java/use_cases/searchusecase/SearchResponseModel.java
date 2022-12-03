package use_cases.searchusecase;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.recipe.CommonRecipeFactory;
import entities.recipe.Recipe;
import entities.recipe.RecipeFactory;

import java.util.ArrayList;
import java.util.Dictionary;

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

    public RecipeFactory getRecipeFactory() {
        return this.recipeFactory;
    }

    public ArrayList<Dictionary<String, Object>> formatJson() {
        ArrayList<Dictionary<String, Object>> formattedRecipes = new ArrayList<>();

        JsonObject jsonObject = JsonParser.parseString(this.getApiOutput()).getAsJsonObject();
        JsonArray recipes = jsonObject.get("hits").getAsJsonArray();
        int count = jsonObject.get("to").getAsInt();

        for(int j = 0; j < count; j++) {
            JsonObject n = recipes.get(j).getAsJsonObject();
            JsonObject p = n.get("recipe").getAsJsonObject();
            formattedRecipes.add(this.getRecipeFactory().create(p.get("label").getAsString(),p.get("url").getAsString(),p.get("image")).getRecipeInfo());

        }
        return formattedRecipes;
    }
}
