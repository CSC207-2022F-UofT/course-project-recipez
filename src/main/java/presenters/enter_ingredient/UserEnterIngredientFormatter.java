package presenters.enter_ingredient;

import use_cases.user_enter_indredients_interactor.UserEnterIngredientResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserEnterIngredientFormatter implements UserEnterIngredientPresenter {


    @Override
    public UserEnterIngredientResponseModel prepareSuccessView(UserEnterIngredientResponseModel userEnterIngredientResponseModel) {
        LocalDateTime responseTime = LocalDateTime.parse(userEnterIngredientResponseModel.getCreationTime());
        userEnterIngredientResponseModel.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return userEnterIngredientResponseModel;
    }

    @Override
    public UserEnterIngredientResponseModel prepareFailView(String error) {
        return null;
    }
}