package use_cases.user_enter_indredients_interactor;

/**
 * Request Model for entering ingredient UseCase
 */
public class UserEnterIngredientRequestModel {

    public String Ingredient;
    public String UserName;

    /**
     * Constructor for request model
     * @param Ingredient the ingredient user wants to add
     * @param userName the username of the user
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



}
