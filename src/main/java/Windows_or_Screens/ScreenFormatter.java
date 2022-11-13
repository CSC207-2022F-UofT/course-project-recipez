//package Windows_or_Screens;
//
//import presenters.UserEnterIngrediant.CreateUserAndFridgePresenter;
//import useCases.CreateUserAndFridge.CreateUserandFridgeResponseModel;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//public class ScreenFormatter implements CreateUserAndFridgePresenter {
//    public CreateUserandFridgeResponseModel prepareSuccessView(CreateUserandFridgeResponseModel response) {
//        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
//        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
//        return response;
//    }
//
//    @Override
//    public CreateUserandFridgeResponseModel prepareFailView(String error) {
//        return null;
//    }
//
//}
