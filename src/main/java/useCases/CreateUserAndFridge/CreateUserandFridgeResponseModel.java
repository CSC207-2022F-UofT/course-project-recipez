package useCases.CreateUserAndFridge;

import entities.Fridge.CommonFridge;
import entities.user.CommonUser;

public class CreateUserandFridgeResponseModel {
    public CommonFridge commonFridge;
    public CommonUser commonUser;
    public String userandfridgecreationtime;

    public CreateUserandFridgeResponseModel(CommonFridge commonFridge, CommonUser commonUser,
            String userandfridgecreationtime) {
        this.commonFridge = commonFridge;
        this.commonUser = commonUser;
        this.userandfridgecreationtime = userandfridgecreationtime;
    }

    public String getCreationTime() {
        return userandfridgecreationtime;
    }

    public void setCreationTime(String creationTime) {
        this.userandfridgecreationtime = userandfridgecreationtime;
    }

}
