package entities.user;

import entities.Fridge.CommonFridge;

public class CommonUser implements User {
    String name;
    CommonFridge commonFridge;

    /**
     * Constructor for the user class
     * @ param username "Unique name of the user, this is what it is saved with in the database"
     * @ param Fridge "Unique fridge of the user, user stores the ingrediants in this fridge" (at the start fridge is
     * just empty)
     * */
    public CommonUser(String name, CommonFridge commonFridge) {
        this.name = name;
        this.commonFridge = commonFridge;
    }

    @Override
    //need to somehow implement this method
    public boolean ingrediantIsValid() {
        return true;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public CommonFridge getFridge() {
        return this.commonFridge;
    }
}
