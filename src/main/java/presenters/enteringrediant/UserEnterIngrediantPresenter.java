package presenters.enteringrediant;

import entities.Ingrediant.CommonIngrediant;
import useCases.UserEnterIndrediantsInteractor.UserEnterIngrediantResponseModel;

public interface UserEnterIngrediantPresenter {

    CommonIngrediant prepareSuccessView(CommonIngrediant ingrediant);
}
