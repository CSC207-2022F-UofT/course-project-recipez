package use_cases.login_usecase;

import database.DatabaseGateway;

import javax.xml.crypto.Data;

public class LoginInteractor implements loginInputBoundary{


    final DatabaseGateway database;

    public LoginInteractor(DatabaseGateway database) {
        this.database = database;
    }


    @Override
    public loginResponseModel create(loginRequestModel requestModel) {
        return null;
    }
}
