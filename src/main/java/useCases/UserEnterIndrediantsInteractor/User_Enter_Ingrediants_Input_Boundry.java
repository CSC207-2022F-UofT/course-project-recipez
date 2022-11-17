package useCases.UserEnterIndrediantsInteractor;

import entities.Ingrediant.CommonIngredient;

public interface User_Enter_Ingrediants_Input_Boundry {
    CommonIngredient create(UserEnterIngredientRequestModel requestModel);
}
