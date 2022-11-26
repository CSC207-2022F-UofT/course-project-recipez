package use_cases.recipeBuilder;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.recipe.CommonRecipeFactory;
import entities.recipe.Recipe;
import entities.recipe.RecipeFactory;

import java.util.ArrayList;

public class RecipeBuilderResponseModel {

    RecipeFactory recipeFactory;

//    public RecipeBuilderResponseModel(RecipeFactory recipeFactory) {
//        this.recipeFactory = recipeFactory;
//    }
//    public ArrayList<Recipe> createRecipe(String apiOutput){
//        RecipeFactory factory = new CommonRecipeFactory();
//        ArrayList<Recipe> formattedRecipes = new ArrayList<>();
//        try {
//            JsonObject jsonObject = JsonParser.parseString(apiOutput).getAsJsonObject();
//            JsonArray recipes = jsonObject.get("hits").getAsJsonArray();
//            int count = jsonObject.get("count").getAsInt();
//
//            for(int i = 0; i < count; i++) {
//                JsonObject n = recipes.get(i).getAsJsonObject();
//                JsonObject p = n.get("recipe").getAsJsonObject();
//                formattedRecipes.add(factory.create(p.get("label").getAsString(),p.get("url").getAsString(),p.get("image")));
//
//            }
//            return formattedRecipes;
//        } catch(Exception e) {
//            return new ArrayList<>();
//        }
//    }
}
