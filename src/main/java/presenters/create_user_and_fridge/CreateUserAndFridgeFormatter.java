package presenters.create_user_and_fridge;

import presenters.startPageUI.startPageViewModelInterface;
import use_cases.create_user_and_fridge.CreateUserandFridgeResponseModel;

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
    public CreateUserandFridgeResponseModel prepareSuccessView(CreateUserandFridgeResponseModel responseModel) {
        LocalDateTime responseTime = LocalDateTime.parse(responseModel.getCreationTime());
        responseModel.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        this.viewModel.registration_success(responseModel.getCommonUser().getName());
        return responseModel;
    }

    @Override
    public CreateUserandFridgeResponseModel prepareFailView(String error) {
        this.viewModel.registration_success(error);
        return null;
    }
}
