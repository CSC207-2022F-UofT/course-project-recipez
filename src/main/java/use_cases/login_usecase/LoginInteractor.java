package use_cases.login_usecase;

import database.DatabaseGateway;
import entities.fridge.CommonFridge;
import entities.user.CommonUser;
import presenters.login.loginPresenter;


import java.util.Objects;

/**
 * Login interactor which implements loginInputBoundary
 *
 */
public class LoginInteractor implements loginInputBoundary{

    final DatabaseGateway database;

    public final loginPresenter loginPresenter;

    public LoginInteractor(DatabaseGateway database, loginPresenter loginPresenter) {
        this.database = database;
        this.loginPresenter = loginPresenter;
    }

    /**
     * Overriding the login response model
     *
     * @param requestModel takes in a request Model
     */
    @Override
    public void create(loginRequestModel requestModel) {
        if (Objects.equals(requestModel.getUserName(), "")) {
            loginPresenter.prepareFailView("Nothing Entered");
        }
        else if (!database.hasKey(requestModel.getUserName())) {
            loginPresenter.prepareFailView("Account does not exist");
        }
        else {
            CommonUser curr_user = (CommonUser) database.get(requestModel.getUserName()).getUser();
            CommonFridge curr_fridge = (CommonFridge) database.get(requestModel.getUserName()).getFridge();
            loginResponseModel Login_Success = new loginResponseModel(curr_fridge, curr_user);

            try{
                loginPresenter.prepareSuccessView(Login_Success);
            } catch (Exception e) {
                System.out.println("exception");
                loginPresenter.prepareFailView(e.toString());
            }
        }

    }
}
