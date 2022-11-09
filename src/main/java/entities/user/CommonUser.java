package entities.user;

import entities.Fridge;

public class user implements UserInterface {
    String name;
    Fridge fridge;

    /**
     * Constructor for the user class
     * @ param username "Unique name of the user, this is what it is saved with in the database"
     * @ param Fridge "Unique fridge of the user, user stores the ingrediants in this fridge" (at the start fridge is
     * just empty)
     * */
    public user(String name, Fridge fridge) {
        this.name = name;
        this.fridge = fridge;
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
    public Fridge getFridge() {
        return this.fridge;
    }
}
