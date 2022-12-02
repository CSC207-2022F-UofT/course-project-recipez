package use_cases.create_user_and_fridge;

import entities.fridge.CommonFridge;
import entities.user.CommonUser;

/**
 * Class Create User and Fridge Response Model
 */
public class CreateUserAndFridgeResponseModel {
    public CommonFridge commonFridge;
    public CommonUser commonUser;

    /**
     * @param commonFridge : The user's fridge
     * @param commonUser : The user currently using the program
     */
    public CreateUserAndFridgeResponseModel(CommonFridge commonFridge, CommonUser commonUser) {
        this.commonFridge = commonFridge;
        this.commonUser = commonUser;
    }

    /**
     * @return the Common User
     */
    public CommonUser getCommonUser() {
        return this.commonUser;
    }

}