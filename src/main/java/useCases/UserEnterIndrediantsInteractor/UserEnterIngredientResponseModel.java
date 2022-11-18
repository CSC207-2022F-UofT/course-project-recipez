package useCases.UserEnterIndrediantsInteractor;

import entities.Ingrediant.CommonIngredient;

public class UserEnterIngrediantResponseModel {

    public CommonIngredient commonIngredientingredient;
    public String enterIngredantTime;

    public UserEnterIngrediantResponseModel(CommonIngredient commonIngredient,String enterIngredantTime) {
        this.commonIngredientingredient = commonIngredient;
        this.enterIngredantTime = enterIngredantTime;
    }

    public String getCreationTime() {
        return enterIngredantTime;
    }

    public void setCreationTime(String creationTime) {
        this.enterIngredantTime = enterIngredantTime;
    }
}
