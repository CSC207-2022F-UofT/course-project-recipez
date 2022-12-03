package use_cases.searchusecase;

import entities.recipe.RecipeFactory;

/**
 * Output model for search use case
 */
@SuppressWarnings({"ALL", "unused"})
public class SearchResponseModel {
    final RecipeFactory recipeFactory;
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
