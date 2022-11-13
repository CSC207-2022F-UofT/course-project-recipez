package controllers;

import useCases.UserEnterIndrediantsInteractor.UserEnterIngrediantRequestModel;
import useCases.UserEnterIndrediantsInteractor.UserEnterIngrediantResponseModel;

public class User_Enter_Ingrediants_Controller {

    // needs to take in an interactor

    UserEnterIngrediantResponseModel create(String Ingrediant) {
        UserEnterIngrediantRequestModel requestModel = new UserEnterIngrediantRequestModel(
                Ingrediant);
    UserEnterIngrediantResponseModel x = new UserEnterIngrediantResponseModel("2");
        return x;
        // have this right now to fix the return statement error
        // interactor will return a response model
    }

}
