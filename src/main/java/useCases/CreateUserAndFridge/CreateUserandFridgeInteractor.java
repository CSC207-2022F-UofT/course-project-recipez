package useCases.CreateUserAndFridge;

import entities.Fridge.CommonFridge;
import entities.Fridge.FridgeFactory;
import entities.Ingrediant.CommonIngredient;
import entities.user.CommonUser;
import entities.user.UserFactory;
import presenters.CreateUserandFridge.CreateUserAndFridgePresenter;

import java.time.LocalDateTime;
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
    public CreateUserandFridgeResponseModel create(CreateUserandFridgeRequestModel requestModel) {
        if (Objects.equals(requestModel.getUserName(), "")) {
            return createUserAndFridgePresenter.prepareFailView("Nothin entered");
        }
        else {
            ArrayList<CommonIngredient> tesst = new ArrayList<>();
            CommonFridge x = (CommonFridge) fridgeFactory.create(tesst);
            CommonUser user = (CommonUser) userFactory.create(requestModel.getUserName(), x);

            LocalDateTime now = LocalDateTime.now();

            CreateUserandFridgeResponseModel successResponseModel = new
                    CreateUserandFridgeResponseModel(x, user, now.toString());
            return createUserAndFridgePresenter.prepareSuccessView(successResponseModel);
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
