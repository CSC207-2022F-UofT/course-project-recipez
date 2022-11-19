package controllers;

import useCases.UserEnterIndrediantsInteractor.UserEnterIngredientResponseModel;
import useCases.UserEnterIndrediantsInteractor.UserEnterIngredientRequestModel;
import useCases.UserEnterIndrediantsInteractor.UserEnterIngredientsInputBoundary;

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
