package controllers;

import use_cases.enter_indredients_usecase.UserEnterIngredientResponseModel;
import use_cases.enter_indredients_usecase.UserEnterIngredientRequestModel;
import use_cases.enter_indredients_usecase.UserEnterIngredientsInputBoundary;

public class UserEnterIngredientsController {

    public UserEnterIngredientsInputBoundary userIngredientinteractor;

    public UserEnterIngredientsController(UserEnterIngredientsInputBoundary userIngredientinteractor) {
        this.userIngredientinteractor = userIngredientinteractor;
    }


    public UserEnterIngredientResponseModel create(String ingredient, String user) {
        UserEnterIngredientRequestModel requestModel = new UserEnterIngredientRequestModel(ingredient, user);
        return userIngredientinteractor.create(requestModel);
    }
}
