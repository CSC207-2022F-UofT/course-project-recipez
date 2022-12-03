package entities.recipe;

import java.util.Dictionary;
import java.util.Hashtable;

public class CommonRecipe implements Recipe {
    /**
     * Single class constructor requires name of recipe, an ArrayList of required ingredients, time to prepare
     * cost of preparation, and other info such as instructions/description.
     */
    private final Dictionary<String, Object> dictionary;

    public CommonRecipe(Object name, Object url, Object image) {
        this.dictionary = new Hashtable<>();
        this.dictionary.put("Name", name);
        this.dictionary.put("URL", url);
        this.dictionary.put("Image", image);
    }

    public Dictionary<String, Object> getRecipeInfo() {
        return this.dictionary;
    }
}
