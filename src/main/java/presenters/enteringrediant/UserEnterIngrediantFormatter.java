package presenters.enteringrediant;

import entities.Ingrediant.CommonIngredient;
import useCases.UserEnterIndrediantsInteractor.UserEnterIngrediantResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserEnterIngrediantFormatter implements UserEnterIngrediantPresenter {

//    @Override
//    public CommonIngredient prepareSuccessView(CommonIngredient ingrediant) {
//        return ingrediant;
//    }

    @Override
    public UserEnterIngrediantResponseModel prepareSuccessView(UserEnterIngrediantResponseModel userEnterIngrediantResponseModel) {
        LocalDateTime responseTime = LocalDateTime.parse(userEnterIngrediantResponseModel.getCreationTime());
        userEnterIngrediantResponseModel.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return userEnterIngrediantResponseModel;
    }

    @Override
    public UserEnterIngrediantResponseModel prepareFailView(String error) {
        return null;
    }
}
