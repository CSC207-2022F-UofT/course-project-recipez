package entities.recipe;

import java.util.Dictionary;

public interface Recipe {
    Dictionary<String, Object> getRecipeInfo();
    void setDictionary(Dictionary<String, Object> setDict);
}
