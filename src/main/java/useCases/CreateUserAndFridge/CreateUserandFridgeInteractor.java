package useCases.CreateUserAndFridge;

import entities.Fridge.CommonFridge;
import entities.Fridge.Fridge;
import entities.Fridge.FridgeFactory;
import entities.Ingrediant.CommonIngrediant;
import entities.user.CommonUser;
import entities.user.User;
import entities.user.UserFactory;
import presenters.UserEnterIngrediant.CreateUserAndFridgePresenter;

import java.util.ArrayList;
import java.util.Objects;

public class CreateUserandFridgeInteractor implements CreateUserAndFridgeInputBoundry {
    UserFactory userFactory;
    FridgeFactory fridgeFactory;

    CreateUserAndFridgePresenter createUserAndFridgePresenter;

    public CreateUserandFridgeInteractor(UserFactory userFactory, FridgeFactory fridgeFactory, CreateUserAndFridgePresenter
                                         createUserAndFridgePresenter) {
        this.userFactory = userFactory;
        this.fridgeFactory = fridgeFactory;
        this.createUserAndFridgePresenter = createUserAndFridgePresenter;

    }

    @Override
    public CommonUser create(CreateUserandFridgeRequestModel requestModel) {
        if (Objects.equals(requestModel.getUserName(), "")) {
            return null;
        }
        else {
            ArrayList<CommonIngrediant> tesst = new ArrayList<>();
            CommonFridge x = (CommonFridge) fridgeFactory.create(tesst);
            CommonUser user = (CommonUser) userFactory.create(requestModel.getUserName(), x);
            return createUserAndFridgePresenter.prepareSuccessView(user);
        }
    }

//    @Override
//    public String create(CreateUserandFridgeRequestModel requestModel) {
//        if (Objects.equals(requestModel.getUserName(), "")) {
//            return createUserAndFridgePresenter.prepareFailView("Nothing entered");
//        }
//        else {
//            ArrayList<CommonIngrediant> temporary = new ArrayList<>();
//            Fridge fridge = fridgeFactory.create(temporary);
//            User user = userFactory.create("Shaffaan", (CommonFridge) fridge);
//
//            CreateUserandFridgeResponseModel user_created_successfully =
//                    new CreateUserandFridgeResponseModel(user.getName());
//            return createUserAndFridgePresenter.prepareSuccessView(user_created_successfully);
//        }
//    }
}
