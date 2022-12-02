package use_cases.recipeBuilder;

/**
 *recipeBuilder class.
 *Handles the creation of recipes using API output.
 */
public class RecipeBuilder{
    /**
     * Class constructor
     * Requires a recipe factory to be passed and then initializes factory.
     */
    private final String apiOutput;
    public RecipeBuilder(String apiOutput){
        this.apiOutput = apiOutput;
    }

    /**
     * createRecipe takes input from collected API information...
     * In the form of a String Array and uses it to create a new recipe instance.
     */
    public String getAPIOutput() {
        return apiOutput;
    }
}
