package entities;

public class CommonIngredient implements Ingredient{
    /**
     * Class ingredient:
     * String name: name of the ingredient
     */
    private String name;
    /**
     * Constructor for the Ingredient class
     * @ param name: name of the ingredient
     * */
    public CommonIngredient(String ingredientName){
        this.name = ingredientName;
    }
    public String getName() {
        return name;
    }
}
