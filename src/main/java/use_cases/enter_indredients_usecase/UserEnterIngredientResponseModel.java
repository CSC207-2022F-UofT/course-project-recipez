package use_cases.user_enter_indredients_interactor;

import entities.ingredient.CommonIngredient;

/**
 * Response Model for Entering ingredient use case
 */
public class UserEnterIngredientResponseModel {

    public CommonIngredient commonIngredient;
    public String enterIngredientTime;

    /**
     * Constructor for this response model.
     * @param commonIngredient object
     * @param enterIngredientTime object
     */
    public UserEnterIngredientResponseModel(CommonIngredient commonIngredient, String enterIngredientTime) {
        this.commonIngredient = commonIngredient;
        this.enterIngredientTime = enterIngredientTime;
    }

    /**
     * @return creation time, of when ingredient is entered
     */
    public String getCreationTime() {
        return enterIngredientTime;
    }
}
