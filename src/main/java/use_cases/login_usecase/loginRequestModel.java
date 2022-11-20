package use_cases.login_usecase;

import entities.user.CommonUser;

public class loginRequestModel {

    public String user;


    public loginRequestModel(String user) {
        this.user = user;
    }

    String getUserName() {
        return user;
    }
}
