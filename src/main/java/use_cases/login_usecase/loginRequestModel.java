package use_cases.login_usecase;

public class loginRequestModel {

    public String user;


    public loginRequestModel(String user) {
        this.user = user;
    }

    String getUserName() {
        return user;
    }
}
