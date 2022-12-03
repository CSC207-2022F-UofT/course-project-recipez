package presenters.login;

import UI.startPageUI.startPageViewModelInterface;
import use_cases.login_usecase.loginResponseModel;

public class loginFormatter implements loginPresenter{

    private final startPageViewModelInterface viewModel;
    public loginFormatter(startPageViewModelInterface viewModel) {
        this.viewModel = viewModel;
    }
    @Override
    public void prepareSuccessView(loginResponseModel responseModel) {
        viewModel.login_success(responseModel.getCommonUser().getName());
    }

    @Override
    public void prepareFailView(String error) {
        viewModel.login_failure(error);
    }
}
