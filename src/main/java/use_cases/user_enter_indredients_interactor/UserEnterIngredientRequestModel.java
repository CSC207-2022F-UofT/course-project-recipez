package use_cases.user_enter_indredients_interactor;

/**
 * Request Model for entering ingredient UseCase
 */
public class UserEnterIngredientRequestModel {

    public String Ingredient;
    public String UserName;

    /**
     * Constructor for request model
     * @param Ingredient
     * @param userName
     */
    public UserEnterIngredientRequestModel(String Ingredient, String userName) {
        this.Ingredient = Ingredient;
        this.UserName = userName;
    }

    /**
     * @return the ingredient in a string format
     */
    String getIngredient_in_String_Format() {
        return Ingredient;
    }
    String getUserName() {
        return this.UserName;
    }

    void setIngredient(String Ingredient) {
        this.Ingredient = Ingredient;
    }


}
