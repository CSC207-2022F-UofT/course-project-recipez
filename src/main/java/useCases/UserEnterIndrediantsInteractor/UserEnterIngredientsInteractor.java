package useCases.UserEnterIndrediantsInteractor;

import entities.Fridge.Fridge;
import entities.Ingrediant.CommonIngredient;
import entities.Ingrediant.Ingrediant;
import entities.Ingrediant.IngredientFactory;
import entities.user.User;
import presenters.enteringrediant.UserEnterIngrediantPresenter;

import java.util.Objects;

/**
 * Class UserEnterIngredientsInteractor (Implements the ser_Enter_Ingrediants_Input_Boundry)
 */
public class UserEnterIngredientsInteractor implements User_Enter_Ingrediants_Input_Boundry {
    User user;
    Fridge fridge;
    UserEnterIngrediantPresenter userEnterIngrediantPresenter;
    IngredientFactory ingredientFactory;

    /**
     *
     * @param user : The user who is currently using the program
     * @param fridge : The user's current fridge
     * @param ingredientFactory : An ingredient factory to create an ingredient object based on the string
     * @param userEnterIngrediantPresenter Presenter that will call view model based on if ingredient is added or not
     *                                     Need to add database inside this
     */
    public UserEnterIngredientsInteractor(User user,
                                          Fridge fridge,
                                          IngredientFactory ingredientFactory,
                                          UserEnterIngrediantPresenter userEnterIngrediantPresenter
                                          ) {
        this.user = user;
        this.fridge = fridge;
        this.ingredientFactory = ingredientFactory;
        this.userEnterIngrediantPresenter = userEnterIngrediantPresenter;
    }

    /**
     * @param requestModel
     * @return CommonIngredient
     * not correct need to return a response model
     */
 // method will be called by the controller once it has recieved string
    @Override
    public CommonIngredient create(UserEnterIngredientRequestModel requestModel) {
        if (Objects.equals(requestModel.getIngredient_in_String_Format(), "")) {
            return null;
        }
        else {
            Ingrediant ingrediant = ingredientFactory.create(requestModel.getIngredient_in_String_Format());
            user.getFridge().addIngredient((CommonIngredient) ingrediant);

//            UserEnterIngrediantResponseModel Ingrediant_entered_successfully =
//                    new UserEnterIngrediantResponseModel(user.getFridge().printIngrediant());
            return userEnterIngrediantPresenter.prepareSuccessView
                    ((CommonIngredient) user.getFridge().getIngrediantx());
        }
    }
}
