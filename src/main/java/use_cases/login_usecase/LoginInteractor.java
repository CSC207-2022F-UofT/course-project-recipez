package use_cases.login_usecase;

import database.DatabaseGateway;
import entities.fridge.CommonFridge;
import entities.user.CommonUser;
import presenters.login.loginPresenter;

import javax.xml.crypto.Data;

public class LoginInteractor implements loginInputBoundary{


    final DatabaseGateway database;

    public LoginInteractor(DatabaseGateway database) {
        this.database = database;
    }


    @Override
    public loginResponseModel create(loginRequestModel requestModel) {
        if (!database.hasKey(requestModel.getUserName())) {
            return loginPresenter.prepareFailView("");
        }
        else if (requestModel.getUserName().isEmpty()) {
            return loginPresenter.prepareFailView("Nothing");
        }
        else {
            CommonUser curr_user = (CommonUser) database.get(requestModel.getUserName()).get(0);
            CommonFridge curr_fridge = (CommonFridge) database.get(requestModel.getUserName()).get(1);
            loginResponseModel loginsuccess = new loginResponseModel(curr_fridge, curr_user);

            try{
                return loginPresenter.prepareSuccessView(loginsuccess);
            } catch (Exception e) {
                System.out.println("exception");
                return loginPresenter.prepareFailView(e.toString());
            }
        }

    }
}
