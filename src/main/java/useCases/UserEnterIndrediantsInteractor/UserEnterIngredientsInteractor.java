package useCases.UserEnterIndrediantsInteractor;

import entities.Fridge.Fridge;
import entities.Fridge.FridgeFactory;
import entities.Ingrediant.CommonIngredient;
import entities.Ingrediant.Ingrediant;
import entities.Ingrediant.IngredientFactory;
import entities.user.User;
import presenters.enteringrediant.UserEnterIngrediantPresenter;

import java.util.Objects;

/**
 * Class UserEnterIngrediantsInteractor
 */
public class UserEnterIngrediantsInteractor implements User_Enter_Ingrediants_Input_Boundry {
    User user;

    Fridge fridge;
    UserEnterIngrediantPresenter userEnterIngrediantPresenter;
    IngredientFactory ingredientFactory;
    FridgeFactory fridgeFactory;

    // we need presenter here aswell
    // we need some sort of method for database aswelll

    public UserEnterIngrediantsInteractor(User user,
                                          Fridge fridge,
                                          IngredientFactory ingredientFactory,
                                          UserEnterIngrediantPresenter userEnterIngrediantPresenter
                                          ) {
        this.user = user;
        this.fridge = fridge;
        this.ingredientFactory = ingredientFactory;
        this.userEnterIngrediantPresenter = userEnterIngrediantPresenter;
    }

 // method will be called by the controller once it has recieved string
    @Override
    public CommonIngredient create(UserEnterIngrediantRequestModel requestModel) {
        if (Objects.equals(requestModel.getIngrediant_in_String_Format(), "")) {
            return null;
        }
        else {
            Ingrediant ingrediant = ingredientFactory.create(requestModel.getIngrediant_in_String_Format());
            user.getFridge().addIngredient((CommonIngredient) ingrediant);

//            UserEnterIngrediantResponseModel Ingrediant_entered_successfully =
//                    new UserEnterIngrediantResponseModel(user.getFridge().printIngrediant());
            return userEnterIngrediantPresenter.prepareSuccessView
                    ((CommonIngredient) user.getFridge().getIngrediantx());
        }
    }
}
