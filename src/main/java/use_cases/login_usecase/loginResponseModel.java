package use_cases.login_usecase;

import entities.fridge.CommonFridge;
import entities.user.CommonUser;

/**
 * loginResponseModel class
 */
@SuppressWarnings({"ALL", "unused"})
public class loginResponseModel {

    public final CommonFridge commonFridge;
    public final CommonUser commonUser;

    /**
     * Constructor
     *
     * @param commonFridge commonFridge
     * @param commonUser commonUser
     */
    public loginResponseModel(CommonFridge commonFridge, CommonUser commonUser) {
        this.commonFridge = commonFridge;
        this.commonUser = commonUser;
    }

    /**
     * The getter function
     *
     * @return the common user
     */
    public CommonUser getCommonUser() {
        return this.commonUser;
    }
}
