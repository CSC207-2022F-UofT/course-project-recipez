package presenters.enter_ingredient;

import use_cases.enter_indredients_usecase.UserEnterIngredientResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserEnterIngredientFormatter implements UserEnterIngredientPresenter {


    @Override
    public UserEnterIngredientResponseModel prepareSuccessView(UserEnterIngredientResponseModel userEnterIngredientResponseModel) {
        LocalDateTime responseTime = LocalDateTime.parse(userEnterIngredientResponseModel.getCreationTime());
        return userEnterIngredientResponseModel;
    }

    @Override
    public UserEnterIngredientResponseModel prepareFailView(String error) {
        return null;
    }
}
