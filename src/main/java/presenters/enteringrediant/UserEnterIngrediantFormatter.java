package presenters.enteringrediant;

import entities.Ingrediant.CommonIngrediant;
import useCases.UserEnterIndrediantsInteractor.UserEnterIngrediantResponseModel;

public class UserEnterIngrediantFormatter implements UserEnterIngrediantPresenter {

    @Override
    public CommonIngrediant prepareSuccessView(CommonIngrediant ingrediant) {
        return ingrediant;
    }
}
