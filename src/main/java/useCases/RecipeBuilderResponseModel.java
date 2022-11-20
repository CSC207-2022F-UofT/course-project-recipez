package useCases;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.recipe.CommonRecipeFactory;
import entities.recipe.Recipe;
import entities.recipe.RecipeFactory;

import java.util.ArrayList;

public class RecipeBuilderResponseModel {

    RecipeFactory recipeFactory;

    public RecipeBuilderResponseModel(RecipeFactory recipeFactory) {
        this.recipeFactory = recipeFactory;
    }
    public ArrayList<Recipe> createRecipe(String apiOutput){
        RecipeFactory factory = new CommonRecipeFactory();
        ArrayList<Recipe> formattedRecipes = new ArrayList<Recipe>();
        String testOutput = "{\"from\":1,\"to\":2,\"count\":2,\"_links\":{},\"hits\":[{\"recipe\":{\"label\":\"Eggplant & Lentil Fritters\",\"image\":\"https://edamam-product-images.s3.amazonaws.com/web-img/e59/e592b71f2af6b1e5cb0b784ae9919e3a.jpg?X-Amz-Security-Token=IQoJb3JpZ2luX2VjEEcaCXVzLWVhc3QtMSJGMEQCIAlSU%2FHlTUmcGquOC8ShXaTwZywtPoxLHCFxs62oatdzAiAVpkn0M8J0vn0lMVghnY1D3NuEvk3GGI82%2BMhuu5IbsCrMBAhQEAAaDDE4NzAxNzE1MDk4NiIMfHXSwB392BxZzp9yKqkEnns0AMUUYIF4LnkSaiXo%2BFK78rOCw%2F8Ze48EWfCGejYR%2FHZz2sNtov5zBhw8kwrm1Kypkn0srkrgtSwFP5eNHCnw7o76ul6IRlI%2FckAhA4fp7BdzEkzIOEgKfJuSRN3vwZZzIR9%2BNjjXc8TXNHy%2B8evgZxWMyBlabQowWbsvkpfISX9JeJq5B0p9z9eBhBp8tHwjM9QS2l2icRsaed2bT4EmQ1wQv3ifgH4nnB79HiCdmH5R6GahnmHeYeRQM86g9GdOQXRtU7TcAKV0pPuinShdIACfUmy7Z7mkR6A8EILr8xeWghQ%2BORe3jf%2F%2BB3RehNwtpE7IlMUF8acraz1qg5WphUH2t3OJN9YLlpO2WTBD7VBc1mn1ORIIRp7STuQA5F0pls8D2Jmu8UvfxwVZCoHpu7p%2BdkVxHvC%2Bzr1MUVFY7IZkgtPrXKPKpxqskKkQq1vMjHokSJ0Y35lqD%2FSmjiKXc01Ktbi%2Bx1HPzgJmbX28ZjeddKGo7%2FUVsDu1TRRnx%2ByfQ3vpXKIFKuRN9WAxj9E8VzlwtJQvczvxlTFcz1gOkrlDjoSUmsAnfsC5h%2FkdYP51L17jP1X8qcOFjCZsFzWr5OYJkvDL416XKc23QJOPxhtjjYS8TWsqoGamURdN9FKAKV0XRw2r5jv2GhWosdlBUI2U9Zf38fYs4i%2BRhYifY2vd%2BA%2B3g0gn36cU7RsVLUAd6xnuxcK21K5kA1doJfQkh031qBrYwzCynuCbBjqqAeD05cEpqu9mOaZJNf1%2Bc15tHH0SnDXJRu611uT3mpgMVSVnZhbsjlNgIFhlQ%2BfDaVCYTwt2JhPz095Gm3YtjrsJVeMn0%2FsOwj2gPWG5Y%2F3yTnlXTDHWswFfWTOfNsQ0xNnaAPYmdTHrDRGDNVp1cDk%2BANsPQN6zItDycHsRvraZJKIUSVbW%2BBpmbleFhiavhSQKhnFyE0FJcVMb6FifadSiqP18cthmhWvj&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20221118T235342Z&X-Amz-SignedHeaders=host&X-Amz-Expires=3600&X-Amz-Credential=ASIASXCYXIIFOGNPX7HD%2F20221118%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=29e8a6ffd26b40a52644d16fc9350c0098add3e3c41e12c55ba3a868824aacd7\",\"url\":\"http://honestcooking.com/eggplant-lentil-fritters-recipe/\",\"yield\":4.0,\"ingredientLines\":[\"1 medium eggplant\",\"1 cup green lentils, boiled (with liquid removed)\",\"\u00BD cup red pepper, finely chopped\",\"\u00BD onion, finely chopped\",\"2 cloves of garlic, crushed\",\"1 teaspoon cumin powder\",\"1 tablespoon coriander powder\",\"\u00BD teaspoon curry powder\",\"4 tablespoons rolled oats\",\"2 tablespoons olive oil\",\"Salt & chili to taste\"],\"calories\":1208.7799999987456,\"totalWeight\":943.6359275191397,\"totalTime\":30.0},\"_links\":{\"self\":{\"href\":\"https://api.edamam.com/api/recipes/v2/52c6d915f3486d9b091d0a1f883751a1?type=public&app_id=c863d4be&app_key=9c705fc2c472f935f32ea2e2c1494311\",\"title\":\"Self\"}}},{\"recipe\":{\"label\":\"Yummy Moroccan Lentil Soup Recipe\",\"image\":\"https://edamam-product-images.s3.amazonaws.com/web-img/cb6/cb6687b4785e5a1da2e65e6b7a010bb5.jpg?X-Amz-Security-Token=IQoJb3JpZ2luX2VjEEcaCXVzLWVhc3QtMSJGMEQCIAlSU%2FHlTUmcGquOC8ShXaTwZywtPoxLHCFxs62oatdzAiAVpkn0M8J0vn0lMVghnY1D3NuEvk3GGI82%2BMhuu5IbsCrMBAhQEAAaDDE4NzAxNzE1MDk4NiIMfHXSwB392BxZzp9yKqkEnns0AMUUYIF4LnkSaiXo%2BFK78rOCw%2F8Ze48EWfCGejYR%2FHZz2sNtov5zBhw8kwrm1Kypkn0srkrgtSwFP5eNHCnw7o76ul6IRlI%2FckAhA4fp7BdzEkzIOEgKfJuSRN3vwZZzIR9%2BNjjXc8TXNHy%2B8evgZxWMyBlabQowWbsvkpfISX9JeJq5B0p9z9eBhBp8tHwjM9QS2l2icRsaed2bT4EmQ1wQv3ifgH4nnB79HiCdmH5R6GahnmHeYeRQM86g9GdOQXRtU7TcAKV0pPuinShdIACfUmy7Z7mkR6A8EILr8xeWghQ%2BORe3jf%2F%2BB3RehNwtpE7IlMUF8acraz1qg5WphUH2t3OJN9YLlpO2WTBD7VBc1mn1ORIIRp7STuQA5F0pls8D2Jmu8UvfxwVZCoHpu7p%2BdkVxHvC%2Bzr1MUVFY7IZkgtPrXKPKpxqskKkQq1vMjHokSJ0Y35lqD%2FSmjiKXc01Ktbi%2Bx1HPzgJmbX28ZjeddKGo7%2FUVsDu1TRRnx%2ByfQ3vpXKIFKuRN9WAxj9E8VzlwtJQvczvxlTFcz1gOkrlDjoSUmsAnfsC5h%2FkdYP51L17jP1X8qcOFjCZsFzWr5OYJkvDL416XKc23QJOPxhtjjYS8TWsqoGamURdN9FKAKV0XRw2r5jv2GhWosdlBUI2U9Zf38fYs4i%2BRhYifY2vd%2BA%2B3g0gn36cU7RsVLUAd6xnuxcK21K5kA1doJfQkh031qBrYwzCynuCbBjqqAeD05cEpqu9mOaZJNf1%2Bc15tHH0SnDXJRu611uT3mpgMVSVnZhbsjlNgIFhlQ%2BfDaVCYTwt2JhPz095Gm3YtjrsJVeMn0%2FsOwj2gPWG5Y%2F3yTnlXTDHWswFfWTOfNsQ0xNnaAPYmdTHrDRGDNVp1cDk%2BANsPQN6zItDycHsRvraZJKIUSVbW%2BBpmbleFhiavhSQKhnFyE0FJcVMb6FifadSiqP18cthmhWvj&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20221118T235342Z&X-Amz-SignedHeaders=host&X-Amz-Expires=3600&X-Amz-Credential=ASIASXCYXIIFOGNPX7HD%2F20221118%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=f00ee3e6f751f53b1a37b64219057a90c02558badf1c7b5a3877b22ac2380ee7\",\"url\":\"http://recipeofhealth.com/recipe/yummy-moroccan-lentil-soup-622013rb\",\"yield\":8.0,\"ingredientLines\":[\"2 tbsp butter\",\"2 tbsp olive oil\",\"1 large onion, finely chopped\",\"1 small green pepper, finely chopped\",\"2 medium carrots, shredded\",\"1 1/2 cups peeled and finely chopped eggplant\",\"4 cloves garlic, minced\",\"2 full tsp cumin\",\"1 tsp curry powder\",\"1 tsp allspice\",\"1 1/2 tsp cinnamon\",\"1 tsp red pepper flakes\",\"300 ml water\",\"1 tbsp vinegar\",\"1 liter chicken broth\",\"1 can diced tomatoes, drained\",\"1 16- oz bag dried lentils , any variety\",\"1/2 tsp salt\",\"plain yogurt or sour cream, for garnish\",\"chopped fresh cilantro, for garnish\"],\"calories\":2655.8617805141257,\"totalWeight\":2550.3347232325486,\"totalTime\":70.0},\"_links\":{\"self\":{\"href\":\"https://api.edamam.com/api/recipes/v2/d508505f4cacada3d5c07aeebe35627f?type=public&app_id=c863d4be&app_key=9c705fc2c472f935f32ea2e2c1494311\",\"title\":\"Self\"}}}]}";
        JsonObject jsonObject = JsonParser.parseString(testOutput).getAsJsonObject();
        JsonArray recipes = jsonObject.get("hits").getAsJsonArray();
        int count = jsonObject.get("count").getAsInt();

        for(int i = 0; i < count; i++) {
            JsonObject n = recipes.get(i).getAsJsonObject();
            JsonObject p = n.get("recipe").getAsJsonObject();
            formattedRecipes.add(factory.create(p.get("label").getAsString(),p.get("url").getAsString(),p.get("image")));

        }
        return formattedRecipes;
    }
}