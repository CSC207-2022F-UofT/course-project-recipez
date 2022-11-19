package useCases;

import entities.Recipe;
import entities.RecipeFactory;

import java.util.ArrayList;

public class RecipeBuilderResponseModel {

    RecipeFactory recipeFactory;

    public RecipeBuilderResponseModel(RecipeFactory recipeFactory) {
        this.recipeFactory = recipeFactory;
    }
    public Recipe createRecipe(String[] apiOutput){
        String[] name1 = apiOutput[0].split ("\"label\":\"");
        String[] nameFinal = name1[1].split ("\",\"url");

        String[] time1 = apiOutput[4].split ("\"totalTime\":");
        String[] timeFinal = time1[1].split ("}.\"_links");

        String[] cals1 = apiOutput[4].split (",\"calories\":");
        String[] calsFinal = cals1[1].split (",\"totalWeight\"");

        String[] ingr1 = apiOutput[4].split ("\"]");
        String[] ingrFinal = ingr1[0].split ("[\",]");
        ArrayList < String > newCollection = new ArrayList < String > ();
        ArrayList < String > finalIngredients = new ArrayList < String > ();
        for (String s : ingrFinal) {
            if (!s.strip().equals("")) {
                newCollection.add(s);
            }
        }

        for (int i = 4; i < newCollection.size (); i++)
        {
            finalIngredients.add(newCollection.get(i));
        }
        return this.recipeFactory.create(nameFinal[0], finalIngredients, timeFinal[0], calsFinal[0]);
    }
}
