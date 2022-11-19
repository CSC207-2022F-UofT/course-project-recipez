package presenters;

import presenters.startPageUI.startPageViewModelInterface;

public class mockUserRegisterPresenter {
    private final String username;
    public mockUserRegisterPresenter(String username) {
        this.username = username;
    }

    public void prepare_login_success(startPageViewModelInterface viewModel) {
        viewModel.login_success(username);
    }

    public void prepare_registration_success(startPageViewModelInterface viewModel) {
        viewModel.registration_success(username);
    }
}
