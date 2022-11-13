package useCases.CreateUserAndFridge;

public class CreateUserandFridgeResponseModel {
    public String user_and_fridge_creation_time;

    public CreateUserandFridgeResponseModel(String user_and_fridge_creation_time) {
        this.user_and_fridge_creation_time = user_and_fridge_creation_time;
    }

    public String getCreationTime() {
        return user_and_fridge_creation_time;
    }

    public void setCreationTime(String creationTime) {
        this.user_and_fridge_creation_time = user_and_fridge_creation_time;
    }

}
