package use_cases.login_usecase;

import entities.fridge.CommonFridge;
import entities.user.CommonUser;

public class loginResponseModel {

    public CommonFridge commonFridge;
    public CommonUser commonUser;

    public loginResponseModel(CommonFridge commonFridge, CommonUser commonUser) {
        this.commonFridge = commonFridge;
        this.commonUser = commonUser;
    }

    public CommonUser getCommonUser() {
        return this.commonUser;
    }

}
