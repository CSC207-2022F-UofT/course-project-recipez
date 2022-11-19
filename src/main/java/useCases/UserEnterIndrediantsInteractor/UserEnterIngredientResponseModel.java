package useCases.UserEnterIndrediantsInteractor;

import entities.Ingredient.CommonIngredient;

/**
 * Response Model for Entering ingredient use case
 */
public class UserEnterIngredientResponseModel {

    public CommonIngredient commonIngredient;
    public String enterIngredientTime;

    /**
     * Constructor for this response model.
     * @param commonIngredient
     * @param enterIngredientTime
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

    public void setCreationTime(String creationTime) {
        this.enterIngredientTime = enterIngredientTime;
    }
}
