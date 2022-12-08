package UI.startPageUI;

/**
 * View Model Interface
 */
public interface StartPageViewModelInterface {
    void registration_success(String response);
    void registration_failure(String err_message);
    void login_success(String response);
    void login_failure(String err_message);
}
