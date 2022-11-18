package useCases;

import entities.Ingredient;
import entities.Recipe;
import entities.RecipeFactory;


import java.util.ArrayList;
/**
 *recipeBuilder class.
 *Handles the creation of recipes using API output.
 */
public class RecipeBuilder implements RecipeBuilderInputBoundary{
    /**
     * Class constructor
     * Requires a recipe factory to be passed and then initializes factory.
     */
    private RecipeFactory factory;
    public RecipeBuilder(RecipeFactory recipeFact){
        this.factory = recipeFact;
    }

    /**
     *createRecipe takes input from collected API information...
     *In the form of a String Array and uses it to create a new recipe instance.
     */
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
        for (int i = 0; i < ingrFinal.length; i++)
        {
            if (!ingrFinal[i].strip ().equals (""))
            {
                newCollection.add(ingrFinal[i]);
            }
        }

        for (int i = 4; i < newCollection.size (); i++)
        {
            finalIngredients.add(newCollection.get(i));
        }
        return this.factory.create(nameFinal[0], finalIngredients, timeFinal[0], calsFinal[0]);
    }
}
