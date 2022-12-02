package use_cases.enter_indredients_usecase;

import entities.ingredient.CommonIngredient;

/**
 * Response Model for Entering ingredient use case
 */
public class UserEnterIngredientResponseModel {

    public CommonIngredient commonIngredient;

    /**
     * Constructor for this response model.
     * @param commonIngredient object
     */
    public UserEnterIngredientResponseModel(CommonIngredient commonIngredient) {
        this.commonIngredient = commonIngredient;
    }

}
