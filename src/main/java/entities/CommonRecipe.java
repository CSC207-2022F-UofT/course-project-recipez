package entities;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

public class CommonRecipe implements Recipe {
    /**
     * Single class constructor requires name of recipe, an ArrayList of required ingredients, time to prepare
     * cost of preparation, and other info such as instructions/description.
     */
    private Dictionary<String, Object> dictionary = new Hashtable<>();
    CommonRecipe(Object name, Object ingredients, Object time, Object price, Object info){
        this.dictionary.put("Name", name);
        this.dictionary.put("IngredientList",ingredients);
        this.dictionary.put("TimeToPrepare",time);
        this.dictionary.put("Cost",price);
        this.dictionary.put("Description",info);
    }

    /**
     * Method for retrieving dictionary containing recipe information.
     * Returns a dictionary with keys, "Name", "IngredientList", "TimeToPrepare", "Cost", and "Description".
     */
    public void setDictionary(Dictionary<String, Object> setDict) {
        this.dictionary = setDict;
    }

    public Dictionary<String, Object> getRecipeInfo(){
        return dictionary;
    }

    public void printDictionary () {
        System.out.println(dictionary);
    }
}
