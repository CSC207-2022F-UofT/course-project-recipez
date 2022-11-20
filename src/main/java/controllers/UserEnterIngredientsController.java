package controllers;

import use_cases.user_enter_indredients_interactor.UserEnterIngredientResponseModel;
import use_cases.user_enter_indredients_interactor.UserEnterIngredientRequestModel;
import use_cases.user_enter_indredients_interactor.UserEnterIngredientsInputBoundary;

public class UserEnterIngredientsController {

    public UserEnterIngredientsInputBoundary userIngrediantinteractor;

    public UserEnterIngredientsController(UserEnterIngredientsInputBoundary userIngrediantinteractor) {
        this.userIngrediantinteractor = userIngrediantinteractor;
    }


    public UserEnterIngredientResponseModel create(String ingrediant, String user) {
        UserEnterIngredientRequestModel requestModel = new UserEnterIngredientRequestModel(ingrediant, user);
        return userIngrediantinteractor.create(requestModel);
    }
    }
