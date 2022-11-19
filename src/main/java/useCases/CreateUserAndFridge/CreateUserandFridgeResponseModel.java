package useCases.CreateUserAndFridge;

import entities.Fridge.CommonFridge;
import entities.user.CommonUser;

/**
 * Class Create User and Fridge Response Model
 */
public class CreateUserandFridgeResponseModel {
    public CommonFridge commonFridge;
    public CommonUser commonUser;
    public String userandfridgecreationtime;

    /**
     * @param commonFridge : The user's fridge
     * @param commonUser : The user currently using the program
     * @param userandfridgecreationtime : The creation time for the user
     */
    public CreateUserandFridgeResponseModel(CommonFridge commonFridge, CommonUser commonUser,
            String userandfridgecreationtime) {
        this.commonFridge = commonFridge;
        this.commonUser = commonUser;
        this.userandfridgecreationtime = userandfridgecreationtime;
    }

    /**
     * @return The time when user and fridge is created
     */
    public String getCreationTime() {
        return userandfridgecreationtime;
    }

    /**
     * needed to somehow move it around in the main
     * @return
     */
    public CommonUser getCommonUser() {
        return this.commonUser;
    }

    /**
     * @param creationTime: Set the time where new user is created
     */
    public void setCreationTime(String creationTime) {
        this.userandfridgecreationtime = userandfridgecreationtime;
    }

}
