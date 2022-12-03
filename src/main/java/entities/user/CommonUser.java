package entities.user;

import entities.fridge.CommonFridge;

import java.io.Serializable;

/**
 * Class CommonUser
 */
public class CommonUser implements User, Serializable {
    final String name;
    final CommonFridge commonFridge;

    /**
     * Constructor for the user class
     * @ param username "Unique name of the user, this is what it is saved with in the database"
     * @ param Fridge "Unique fridge of the user, user stores the ingredients in this fridge" (at the start fridge is
     * just empty)
     * */
    public CommonUser(String name, CommonFridge commonFridge) {
        this.name = name;
        this.commonFridge = commonFridge;
    }

    /**
     * @return The name of the user
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * @return the fridge of the user
     */
    @Override
    public CommonFridge getFridge() {
        return this.commonFridge;
    }
}
