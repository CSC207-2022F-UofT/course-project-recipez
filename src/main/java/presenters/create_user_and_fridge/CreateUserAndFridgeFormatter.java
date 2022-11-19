package presenters.create_user_and_fridge;

import use_cases.create_user_and_fridge.CreateUserandFridgeResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreateUserAndFridgeFormatter implements CreateUserAndFridgePresenter {
//    @Override
//    public CommonUser prepareSuccessView(CommonUser user) {
//        return user;
//    }

    @Override
    public CreateUserandFridgeResponseModel prepareSuccessView(CreateUserandFridgeResponseModel responseModel) {
        LocalDateTime responseTime = LocalDateTime.parse(responseModel.getCreationTime());
        responseModel.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return responseModel;
    }

    @Override
    public CreateUserandFridgeResponseModel prepareFailView(String error) {
        return null;
    }
}
