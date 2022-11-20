package UI.startPageUI;

/**
 * View Model for start Page UI. Interface Adapters Layer.
 */
public class startPageViewModel implements startPageViewModelInterface {

    public String pageState;
    public String create_register_response;
    public String attempt_login_response;

    /**
     * Constructor for ViewModel. Sets pageState to the main start page.
     */
    public startPageViewModel() {
        this.pageState = "main";
    }

    /**
     * Updates view for successful user registration
     * @param response successful user registration response
     */
    public void registration_success(String response) {
        this.create_register_response = response;
        System.out.println(create_register_response);
    }

    /**
     * Updates view to display failed registration message
     * @param err_message error message from attempted user registration
     */
    public void registration_failure(String err_message) {
        this.create_register_response = err_message;
        System.out.println(err_message);
    }


    /**
     * Updates view for successful user login
     * @param response successful user login response
     */
    public void login_success(String response) {
        this.attempt_login_response = response;
    }

    /**
     * Updates view for failed user login
     * @param err_message error message from failed user login
     */
    public void login_failure(String err_message) {
        this.attempt_login_response = err_message;
    }
}
