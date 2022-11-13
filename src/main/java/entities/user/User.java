package entities.user;

import entities.Fridge.CommonFridge;

public interface User {
    boolean ingrediantIsValid();
    String getName();

    CommonFridge getFridge();
}
