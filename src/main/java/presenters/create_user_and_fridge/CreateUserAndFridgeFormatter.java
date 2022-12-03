package presenters.create_user_and_fridge;

import UI.startPageUI.startPageViewModelInterface;
import use_cases.create_user_and_fridge.CreateUserAndFridgeResponseModel;

/**
 * Implements the Presenter (using dependency injection), More it has methods that are used by viewModel
 */
public class CreateUserAndFridgeFormatter implements CreateUserAndFridgePresenter {
    private startPageViewModelInterface viewModel;

    /**
     * @param viewModel Constructor for this class
     */
    public CreateUserAndFridgeFormatter(startPageViewModelInterface viewModel) {
        this.viewModel = viewModel;
    }

    /**
     * Returns a response model
     */
    @Override
    public CreateUserAndFridgeResponseModel prepareSuccessView(CreateUserAndFridgeResponseModel responseModel) {
        this.viewModel.registration_success(responseModel.getCommonUser().getName());
        return responseModel;
    }

    /**
     * @param error : The error message that needs to be displayed
     */
    @Override
    public CreateUserAndFridgeResponseModel prepareFailView(String error) {
        this.viewModel.registration_failure(error);
        return null;
    }
}
