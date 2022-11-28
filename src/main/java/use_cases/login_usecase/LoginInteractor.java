package use_cases.login_usecase;

import database.DatabaseGateway;
import entities.fridge.CommonFridge;
import entities.user.CommonUser;
import presenters.login.loginPresenter;

import javax.xml.crypto.Data;

public class LoginInteractor implements loginInputBoundary{


    final DatabaseGateway database;

    public loginPresenter loginPresenter;

    public LoginInteractor(DatabaseGateway database, loginPresenter loginPresenter) {
        this.database = database;
        this.loginPresenter = loginPresenter;
    }


    @Override
    public loginResponseModel create(loginRequestModel requestModel) {
        if (!database.hasKey(requestModel.getUserName())) {
            return loginPresenter.prepareFailView("Account does not exist");
        }
        else if (requestModel.getUserName().isEmpty()) {
            return loginPresenter.prepareFailView("Nothing");
        }
        else {
            CommonUser curr_user = (CommonUser) database.get(requestModel.getUserName()).getUser();
            CommonFridge curr_fridge = (CommonFridge) database.get(requestModel.getUserName()).getFridge();
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
