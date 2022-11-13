package useCases.UserEnterIndrediantsInteractor;

import entities.Fridge.CommonFridge;
import entities.Fridge.Fridge;
import entities.Fridge.FridgeFactory;
import entities.Ingrediant.CommonIngrediant;
import entities.Ingrediant.CommonIngrediantFactory;
import entities.Ingrediant.Ingrediant;
import entities.Ingrediant.IngrediantFactory;
import entities.user.User;
import entities.user.UserFactory;
import presenters.UserEnterIngrediant.UserEnterIngrediantPresenter;

import java.util.ArrayList;
import java.util.Objects;

// whenever user enters ingrediants into the input this usecase will be called
// it will store the ingrediants in the fridge
// later will figure out how to store fridge in database
public class UserEnterIngrediantsInteractor implements User_Enter_Ingrediants_Input_Boundry {

    UserFactory userFactory;
    UserEnterIngrediantPresenter userEnterIngrediantPresenter;
    IngrediantFactory ingrediantFactory;
    FridgeFactory fridgeFactory;

    // we need presenter here aswell
    // we need some sort of method for database aswelll

    public UserEnterIngrediantsInteractor(UserFactory userFactory, IngrediantFactory ingrediantFactory,
                                          FridgeFactory fridgeFactory,
                                          UserEnterIngrediantPresenter userEnterIngrediantPresenter) {
        this.userFactory = userFactory;
        this.ingrediantFactory = ingrediantFactory;
        this.fridgeFactory = fridgeFactory;
        this.userEnterIngrediantPresenter = userEnterIngrediantPresenter;
    }

 // method will be called by the controller once it has recieved string
    @Override
    public UserEnterIngrediantResponseModel create(UserEnterIngrediantRequestModel requestModel) {
        if (Objects.equals(requestModel.getIngrediant_in_String_Format(), "")) {
            return userEnterIngrediantPresenter.prepareFailView("Nothing entered");
        }
        else {
            Ingrediant ingrediant = ingrediantFactory.create(requestModel.getIngrediant_in_String_Format());
            ArrayList<CommonIngrediant> temporary = new ArrayList<>();
            Fridge fridge = fridgeFactory.create(temporary);
            User user = userFactory.create("SHaffaan", (CommonFridge) fridge);
            user.getFridge().addIngredient((CommonIngrediant) ingrediant);

            UserEnterIngrediantResponseModel Ingrediant_entered_successfully =
                    new UserEnterIngrediantResponseModel(user.getName());
            return userEnterIngrediantPresenter.prepareSuccessView(Ingrediant_entered_successfully);
        }
    }
    // the useCase will have a factory
    // useCase will have some sort of mechanism to store in database
    // useCase will have some sort of presenter
}
