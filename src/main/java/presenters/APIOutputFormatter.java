package presenters;

import java.util.ArrayList;

public class APIOutputFormatter implements RecipePresenter{

    public String[] format(String output){
        String x = "{\"from\":1,\"to\":1,\"count\":1,\"_links\":{},\"hits\":[{\"recipe\":{\"label\":\"Eggplant & Lentil Fritters\",\"url\":\"http://honestcooking.com/eggplant-lentil-fritters-recipe/\",\"yield\":4.0,\"ingredientLines\":[\"1 medium eggplant\",\"1 cup green lentils, boiled (with liquid removed)\",\"\u00BD cup red pepper, finely chopped\",\"\u00BD onion, finely chopped\",\"2 cloves of garlic, crushed\",\"1 teaspoon cumin powder\",\"1 tablespoon coriander powder\",\"\u00BD teaspoon curry powder\",\"4 tablespoons rolled oats\",\"2 tablespoons olive oil\",\"Salt & chili to taste\"],\"calories\":1208.7799999987456,\"totalWeight\":943.6359275191397,\"totalTime\":30.0},\"_links\":{\"self\":{\"title\":\"Self\",\"href\":\"https://api.edamam.com/api/recipes/v2/52c6d915f3486d9b091d0a1f883751a1?type=public&app_id=c863d4be&app_key=9c705fc2c472f935f32ea2e2c1494311\"}}}]}";
        String[] y = x.split ("[/[/]]");

        return y;
    }
}
