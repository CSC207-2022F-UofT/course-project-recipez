package use_cases.create_user_and_fridge;

import entities.fridge.CommonFridge;
import entities.user.CommonUser;

/**
 * Class Create User and Fridge Response Model
 */
public class CreateUserAndFridgeResponseModel {
    public CommonFridge commonFridge;
    public CommonUser commonUser;
    public String UserAndFridgeCreationTime;

    /**
     * @param commonFridge : The user's fridge
     * @param commonUser : The user currently using the program
     * @param UserAndFridgeCreationTime : The creation time for the user
     */
    public CreateUserAndFridgeResponseModel(CommonFridge commonFridge, CommonUser commonUser,
                                            String UserAndFridgeCreationTime) {
        this.commonFridge = commonFridge;
        this.commonUser = commonUser;
        this.UserAndFridgeCreationTime = UserAndFridgeCreationTime;
    }

    /**
     * @return The time when user and fridge is created
     */
    public String getCreationTime() {
        return UserAndFridgeCreationTime;
    }

    /**
     * @return the Common User
     */
    public CommonUser getCommonUser() {
        return this.commonUser;
    }

}
