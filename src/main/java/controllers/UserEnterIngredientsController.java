package controllers;

import use_cases.user_enter_indredients_interactor.UserEnterIngredientResponseModel;
import use_cases.user_enter_indredients_interactor.UserEnterIngredientRequestModel;
import use_cases.user_enter_indredients_interactor.UserEnterIngredientsInputBoundary;

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
