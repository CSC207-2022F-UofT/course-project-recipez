package entities;

import java.util.Dictionary;
import java.util.Hashtable;

public interface Recipe {
    Dictionary<String, Object> getRecipeInfo();
    void setDictionary(Dictionary<String, Object> setDict);
}
