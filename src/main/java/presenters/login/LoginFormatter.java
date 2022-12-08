package presenters.login;

import UI.startPageUI.StartPageViewModelInterface;
import use_cases.login_usecase.LoginResponseModel;

public class LoginFormatter implements LoginPresenter {

     /**
     * Format the login interactor response for success view and fail view
     */
    private final StartPageViewModelInterface viewModel;
    
    public LoginFormatter(StartPageViewModelInterface viewModel) {
        this.viewModel = viewModel;
    }
    @Override
    public void prepareSuccessView(LoginResponseModel responseModel) {
        viewModel.login_success(responseModel.getCommonUser().getName());
    }

    @Override
    public void prepareFailView(String error) {
        viewModel.login_failure(error);
    }
}
