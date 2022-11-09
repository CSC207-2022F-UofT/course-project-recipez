package entities;
import entities.ingredient;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class recipe {
    /**
     * recipe object to be instantiated by recipeBuilder class.
     * Information regarding a recipe is then collected in a dictionary within the instance
     */
     private Dictionary<String, Object> dict = new Hashtable();
    /**
     * Single class constructor requires name of recipe, an ArrayList of required ingredients, time to prepare
     * cost of preparation, and other info such as instructions/description.
     */
     public recipe(String name, ArrayList<ingredient> ing, int time, int price, String info){
        this.dict.put("Name", name);
        this.dict.put("IngredientList",ing);
        this.dict.put("TimeToPrepare",time);
        this.dict.put("Cost",price);
        this.dict.put("Description",info);
    }
    /**
     * Method for retrieving dictionary containing recipe information.
     * Returns a dictionary with keys, "Name", "IngredientList", "TimeToPrepare", "Cost", and "Description".
     */
    public Dictionary<String, Object> getRecipeInfo(){
        return dict;
    }

}
