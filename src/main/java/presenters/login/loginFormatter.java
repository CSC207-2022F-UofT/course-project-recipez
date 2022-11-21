package presenters.login;

import UI.startPageUI.startPageViewModelInterface;
import use_cases.login_usecase.loginResponseModel;

public class loginFormatter implements loginPresenter{

    private startPageViewModelInterface viewModel;
    public loginFormatter(startPageViewModelInterface viewModel) {
        this.viewModel = viewModel;
    }
    @Override
    public loginResponseModel prepareSuccessView(loginResponseModel responseModel) {
        viewModel.login_success(responseModel.getCommonUser().getName());
        return responseModel;
    }

    @Override
    public loginResponseModel prepareFailView(String error) {
        viewModel.login_failure(error);
        return null;
    }
}
