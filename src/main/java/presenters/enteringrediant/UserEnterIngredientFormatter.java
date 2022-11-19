package presenters.enteringrediant;

import useCases.UserEnterIndrediantsInteractor.UserEnterIngredientResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserEnterIngrediantFormatter implements UserEnterIngrediantPresenter {


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
