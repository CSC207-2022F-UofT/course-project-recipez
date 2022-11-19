package presenters.startPageUI;

import controllers.CreateUserandFridgeController;

public class startPageViewModel implements startPageViewModelInterface {

    public String pageState;
    private String create_register_response;
    private String attempt_login_response;

    public startPageViewModel() {
        this.pageState = "main";
    }
    public void registration_success(String response) {
        this.create_register_response = response;
    }

    public void registration_failure(String err_message) {
        this.create_register_response = err_message;
    }

    public void login_success(String response) {
        this.attempt_login_response = response;
    }

    public void login_failure(String err_message) {
        this.attempt_login_response = err_message;
    }
}
