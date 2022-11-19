package controllers;

import use_cases.user_enter_indredients_interactor.UserEnterIngredientResponseModel;
import use_cases.user_enter_indredients_interactor.UserEnterIngredientRequestModel;
import use_cases.user_enter_indredients_interactor.UserEnterIngredientsInputBoundary;

public class UserEnterIngredientsController {

    public UserEnterIngredientsInputBoundary userIngrediantinteractor;

    public UserEnterIngredientsController(UserEnterIngredientsInputBoundary userIngrediantinteractor) {
        this.userIngrediantinteractor = userIngrediantinteractor;
    }


    public UserEnterIngredientResponseModel create(String ingrediant) {
        UserEnterIngredientRequestModel requestModel = new UserEnterIngredientRequestModel(ingrediant);
        return userIngrediantinteractor.create(requestModel);
    }
    }
