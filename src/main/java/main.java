import controllers.CreateUserandFridgeController;
import entities.Fridge.CommonFridge;
import entities.Fridge.CommonFridgeFactory;
import entities.Ingrediant.CommonIngrediant;
import entities.Ingrediant.CommonIngrediantFactory;
import entities.Ingrediant.IngrediantFactory;
import entities.user.CommonUser;
import entities.user.CommonUserFactory;
import entities.user.UserFactory;
import presenters.UserEnterIngrediant.CreateUserAndFridgeFormatter;
import presenters.UserEnterIngrediant.CreateUserAndFridgePresenter;
import useCases.CreateUserAndFridge.CreateUserAndFridgeInputBoundry;
import useCases.CreateUserAndFridge.CreateUserandFridgeInteractor;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        /*
        * create username first
        * */

        /*
        * Create user factories first
        * */
        CommonFridgeFactory fridgeFactory = new CommonFridgeFactory();
        CommonUserFactory userFactory = new CommonUserFactory();
        CreateUserAndFridgePresenter presenter = new CreateUserAndFridgeFormatter();
        CreateUserAndFridgeInputBoundry interactor = new CreateUserandFridgeInteractor(userFactory, fridgeFactory,
                presenter);
        CreateUserandFridgeController createUserandFridgeController = new CreateUserandFridgeController(interactor);

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter Username");
        String userName = myObj.nextLine();
        System.out.println("the user is " +
                presenter.prepareSuccessView(createUserandFridgeController.create(userName)).getName() + " the current" +
                        " fridge is ");
        presenter.prepareSuccessView(createUserandFridgeController.create(userName)).getFridge().printIngrediant();
        /*
        * create ingrediant next
        * */
//        Scanner myObj2 = new Scanner(System.in);
//        System.out.println("Enter Ingrediant");
//        String ingrediant = myObj2.nextLine();
//        IngrediantFactory ingrediantFactory = new CommonIngrediantFactory();
//        CommonIngrediant te = (CommonIngrediant) ingrediantFactory.create(ingrediant);
//        x.addIngredient(te);
//        System.out.println("Current fridge = " + x.toString());
    }
}
