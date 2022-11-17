package useCases.UserEnterIndrediantsInteractor;

import entities.Ingrediant.CommonIngrediant;
import entities.Ingrediant.Ingrediant;

public interface User_Enter_Ingrediants_Input_Boundry {
    CommonIngrediant create(UserEnterIngrediantRequestModel requestModel);
}
