package entities;

import entities.recipe.CommonRecipeFactory;
import entities.recipe.Recipe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * The unit test class to test the CommonRecipe.
 */

public class CommonRecipeTest {
    Dictionary<String, Object> dictionary = new Hashtable<>();

    /**
     * Test if dictionary is set to the recipe's info
     * Test if getRecipeInfo() returns the dictionary
     */
    @Test
    public void testDictionaryWithKeys() {
        CommonRecipeFactory factory = new CommonRecipeFactory();
        Recipe recipe = factory.create("Fried Egg", "url", "image");
        dictionary.put("Name", "Fried Egg");
        dictionary.put("URL", "url");
        dictionary.put("Image", "image");
        recipe.setDictionary(dictionary);
        Assertions.assertEquals(recipe.getRecipeInfo(), dictionary);
    }

    /**
     * Test if dictionary is set to the recipe's info when the values of keys are empty string
     * Test if getRecipeInfo() returns the dictionary
     */
    @Test
    public void testEmptyDictionary() {
        CommonRecipeFactory factory = new CommonRecipeFactory();
        Recipe recipe = factory.create("", "", "");
        dictionary.put("Name", "");
        dictionary.put("URL", "");
        dictionary.put("Image", "");
        recipe.setDictionary(dictionary);
        Assertions.assertEquals(recipe.getRecipeInfo(), dictionary);
    }
}

