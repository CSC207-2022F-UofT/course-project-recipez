package entities.user;

import entities.fridge.Fridge;

import java.io.Serializable;

/**
 * Class CommonUser
 */
public class CommonUser implements User, Serializable {
    String name;
    Fridge Fridge;

    /**
     * Constructor for the user class
     * @ param username "Unique name of the user, this is what it is saved with in the database"
     * @ param Fridge "Unique fridge of the user, user stores the ingredients in this fridge" (at the start fridge is
     * just empty)
     * */
    public CommonUser(String name, Fridge fridge) {
        this.name = name;
        this.Fridge = fridge;
    }

    /**
     * Checks if entered ingredient is valid
     * @return A boolean value based on validity of ingredient
     */
    @Override
    //need to somehow implement this method
    public boolean ingredientIsValid() {
        return true;
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
    public Fridge getFridge() {
        return this.Fridge;
    }
}
