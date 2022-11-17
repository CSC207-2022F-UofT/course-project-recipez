package controllers;

import entities.Ingrediant.CommonIngredient;
import useCases.UserEnterIndrediantsInteractor.UserEnterIngredientRequestModel;
import useCases.UserEnterIndrediantsInteractor.User_Enter_Ingrediants_Input_Boundry;

public class User_Enter_Ingrediants_Controller {

    // needs to take in an interactor

    public User_Enter_Ingrediants_Input_Boundry userIngrediantinteractor;

    public User_Enter_Ingrediants_Controller(User_Enter_Ingrediants_Input_Boundry userIngrediantinteractor) {
        this.userIngrediantinteractor = userIngrediantinteractor;
    }


    public CommonIngredient create(String ingrediant) {
        UserEnterIngredientRequestModel requestModel = new UserEnterIngredientRequestModel(ingrediant);
        return userIngrediantinteractor.create(requestModel);
    }


//    UserEnterIngrediantResponseModel create(String Ingrediant) {
//        UserEnterIngrediantRequestModel requestModel = new UserEnterIngrediantRequestModel(
//                Ingrediant);
//    UserEnterIngrediantResponseModel x = new UserEnterIngrediantResponseModel("2");
//        return x;
        // have this right now to fix the return statement error
        // interactor will return a response model
    }
