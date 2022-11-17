package useCases.UserEnterIndrediantsInteractor;

import entities.Ingrediant.CommonIngredient;

public interface UserEnterIngredientsInputBoundry {
    UserEnterIngrediantResponseModel create(UserEnterIngredientRequestModel requestModel);
}
