package useCases.UserEnterIndrediantsInteractor;

public class UserEnterIngrediantResponseModel {

    public String enter_ingredant_time;

    public UserEnterIngrediantResponseModel(String enter_ingredant_time) {
        this.enter_ingredant_time = enter_ingredant_time;
    }

    public String getCreationTime() {
        return enter_ingredant_time;
    }

    public void setCreationTime(String creationTime) {
        this.enter_ingredant_time = enter_ingredant_time;
    }

}
