package UI.startPageUI;

/**
 * View Model for start Page UI. Interface Adapters Layer.
 */
public class startPageViewModel implements startPageViewModelInterface {

    public String pageState;
    public String create_register_response;
    public String attempt_login_response;

    public boolean loggedIn;

    /**
     * Constructor for ViewModel. Sets pageState to the Main start page.
     */
    public startPageViewModel() {
        this.pageState = "Main";
        this.loggedIn = false;
    }

    /**
     * Updates view for successful user registration
     * @param username successful user registration response
     */
    @Override
    public void registration_success(String username) {
        this.create_register_response = "User " + username + " successfully created!";
        System.out.println(create_register_response);
    }

    /**
     * Updates view to display failed registration message
     * @param err_message error message from attempted user registration
     */
    @Override
    public void registration_failure(String err_message) {
        this.create_register_response = err_message;
        System.out.println(err_message);
    }


    /**
     * Updates view for successful user login
     * @param username successful user login response
     */
    @Override
    public void login_success(String username) {
        this.attempt_login_response = "Welcome back " + username + "!!";
        this.loggedIn = true;
        System.out.println(attempt_login_response);
    }

    /**
     * Updates view for failed user login
     * @param err_message error message from failed user login
     */
    @Override
    public void login_failure(String err_message) {
        this.attempt_login_response = err_message;
        System.out.println(attempt_login_response);
    }

    public void backToMain() {
        if (pageState.equals("register")) {
            create_register_response = "";
        } else if (pageState.equals("login")) {
            attempt_login_response = "";
        }
        pageState = "Main";
    }
}
