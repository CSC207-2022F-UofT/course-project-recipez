package UI.startPageUI;

public interface startPageViewModelInterface {
    public void registration_success(String response);
    public void registration_failure(String err_message);
    public void login_success(String response);
    public void login_failure(String err_message);
}
