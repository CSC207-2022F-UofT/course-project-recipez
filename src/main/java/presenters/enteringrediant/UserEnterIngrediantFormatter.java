package presenters.enteringrediant;

import entities.Ingrediant.CommonIngredient;

public class UserEnterIngrediantFormatter implements UserEnterIngrediantPresenter {

    @Override
    public CommonIngredient prepareSuccessView(CommonIngredient ingrediant) {
        return ingrediant;
    }
}
