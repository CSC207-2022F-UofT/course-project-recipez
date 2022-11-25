package presenters.create_user_and_fridge;

import UI.startPageUI.startPageViewModelInterface;
import use_cases.create_user_and_fridge.CreateUserAndFridgeResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreateUserAndFridgeFormatter implements CreateUserAndFridgePresenter {
//    @Override
//    public CommonUser prepareSuccessView(CommonUser user) {
//        return user;
//    }
    private startPageViewModelInterface viewModel;

    public CreateUserAndFridgeFormatter(startPageViewModelInterface viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public CreateUserAndFridgeResponseModel prepareSuccessView(CreateUserAndFridgeResponseModel responseModel) {
        LocalDateTime responseTime = LocalDateTime.parse(responseModel.getCreationTime());
        responseModel.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        this.viewModel.registration_success(responseModel.getCommonUser().getName());
        return responseModel;
    }

    @Override
    public CreateUserAndFridgeResponseModel prepareFailView(String error) {
        this.viewModel.registration_failure(error);
        return null;
    }
}
