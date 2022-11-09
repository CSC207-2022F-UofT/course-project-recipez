package entities.user;

import entities.Fridge;

public interface UserInterface {
    boolean ingrediantIsValid();
    String getName();

    Fridge getFridge();
}
