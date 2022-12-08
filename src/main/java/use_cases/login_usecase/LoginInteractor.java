package use_cases.login_usecase;

import database.DatabaseGateway;
import entities.fridge.CommonFridge;
import entities.user.CommonUser;
import presenters.login.LoginPresenter;


import java.util.Objects;

/**
 * Login interactor which implements loginInputBoundary
 *
 */
public class LoginInteractor implements LoginInputBoundary {

    final DatabaseGateway database;

    public final LoginPresenter loginPresenter;

    public LoginInteractor(DatabaseGateway database, LoginPresenter loginPresenter) {
        this.database = database;
        this.loginPresenter = loginPresenter;
    }

    /**
     * Overriding the login response model
     *
     * @param requestModel takes in a request Model
     */
    @Override
    public void create(LoginRequestModel requestModel) {
        if (Objects.equals(requestModel.getUserName(), "")) {
            loginPresenter.prepareFailView("Nothing Entered");
        }
        else if (!database.hasKey(requestModel.getUserName())) {
            loginPresenter.prepareFailView("Account does not exist");
        }
        else {
            CommonUser curr_user = (CommonUser) database.get(requestModel.getUserName()).getUser();
            CommonFridge curr_fridge = (CommonFridge) database.get(requestModel.getUserName()).getFridge();
            LoginResponseModel Login_Success = new LoginResponseModel(curr_fridge, curr_user);

            try{
                loginPresenter.prepareSuccessView(Login_Success);
            } catch (Exception e) {
                System.out.println("exception");
                loginPresenter.prepareFailView(e.toString());
            }
        }

    }
}
