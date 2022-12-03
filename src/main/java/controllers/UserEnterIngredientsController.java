package controllers;

import use_cases.enter_indredients_usecase.UserEnterIngredientRequestModel;
import use_cases.enter_indredients_usecase.UserEnterIngredientsInputBoundary;

public class UserEnterIngredientsController {

    public final UserEnterIngredientsInputBoundary userIngredientinteractor;

    public UserEnterIngredientsController(UserEnterIngredientsInputBoundary userIngredientinteractor) {
        this.userIngredientinteractor = userIngredientinteractor;
    }


    public void create(String ingredient, String user) {
        UserEnterIngredientRequestModel requestModel = new UserEnterIngredientRequestModel(ingredient, user);
        userIngredientinteractor.create(requestModel);
    }
}
