package presenters.create_user_and_fridge;

import UI.startPageUI.StartPageViewModelInterface;
import use_cases.create_user_and_fridge.CreateUserAndFridgeResponseModel;

@SuppressWarnings("ALL")
 /**
 * Implements the Presenter (using dependency injection), More it has methods that are used by viewModel
 */
public class CreateUserAndFridgeFormatter implements CreateUserAndFridgePresenter {

    private final StartPageViewModelInterface viewModel;


    /**
     * @param viewModel Constructor for this class
     */
    public CreateUserAndFridgeFormatter(StartPageViewModelInterface viewModel) {
        this.viewModel = viewModel;
    }

    /**
     * Returns a response model
     */
    @Override
    public CreateUserAndFridgeResponseModel prepareSuccessView(CreateUserAndFridgeResponseModel responseModel) {
        this.viewModel.registration_success(responseModel.getCommonUserName());
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
