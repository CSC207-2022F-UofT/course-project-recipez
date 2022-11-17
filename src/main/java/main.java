import controllers.CreateUserandFridgeController;
import controllers.User_Enter_Ingrediants_Controller;
import entities.Fridge.CommonFridgeFactory;
import entities.Ingrediant.CommonIngredient;
import entities.Ingrediant.CommonIngredientFactory;
import entities.user.CommonUser;
import entities.user.CommonUserFactory;
import presenters.CreateUserandFridge.CreateUserAndFridgeFormatter;
import presenters.CreateUserandFridge.CreateUserAndFridgePresenter;
import presenters.enteringrediant.UserEnterIngrediantFormatter;
import presenters.enteringrediant.UserEnterIngrediantPresenter;
import useCases.CreateUserAndFridge.CreateUserAndFridgeInputBoundry;
import useCases.CreateUserAndFridge.CreateUserandFridgeInteractor;
import useCases.UserEnterIndrediantsInteractor.UserEnterIngredientsInteractor;
import useCases.UserEnterIndrediantsInteractor.User_Enter_Ingrediants_Input_Boundry;

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

        CommonUser shaffaan = createUserandFridgeController.create(userName);

//        System.out.println("the user is " +
//                presenter.prepareSuccessView(shaffaan).getName() + " the current" +
//                        " fridge is ");
//        System.out.println((presenter.prepareSuccessView(shaffaan).getFridge().printIngrediant()));

        Scanner myObj5 = new Scanner(System.in);
        System.out.println("Enter Ingrediant");
        String ingrediant_at_index1 = myObj5.nextLine();


        CommonIngredientFactory ingrediantFactory = new CommonIngredientFactory();
        UserEnterIngrediantPresenter presenter1 = new UserEnterIngrediantFormatter();
        User_Enter_Ingrediants_Input_Boundry interactor2 = new
                UserEnterIngredientsInteractor(shaffaan, shaffaan.getFridge(),ingrediantFactory,presenter1);
        User_Enter_Ingrediants_Controller userEnterIngrediantsController = new User_Enter_Ingrediants_Controller(interactor2);

        CommonIngredient ing = userEnterIngrediantsController.create(ingrediant_at_index1);
//        System.out.println(" You have added" + presenter1.prepareSuccessView(ing).getName() + "new fridge is " +
//                (presenter.prepareSuccessView(shaffaan).getFridge().printIngrediant()));

    }
}