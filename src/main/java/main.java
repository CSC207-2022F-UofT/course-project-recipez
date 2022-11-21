import database.Database;
import database.DatabaseGateway;
import controllers.CreateUserandFridgeController;
import controllers.UserEnterIngredientsController;
import entities.fridge.CommonFridgeFactory;
import entities.ingredient.CommonIngredientFactory;
import entities.user.CommonUserFactory;
import presenters.create_user_and_fridge.CreateUserAndFridgeFormatter;
import presenters.create_user_and_fridge.CreateUserAndFridgePresenter;
import presenters.enter_ingredient.UserEnterIngredientFormatter;
import presenters.enter_ingredient.UserEnterIngredientPresenter;
import use_cases.create_user_and_fridge.CreateUserAndFridgeInputBoundary;
import use_cases.create_user_and_fridge.CreateUserandFridgeInteractor;
import use_cases.user_enter_indredients_interactor.UserEnterIngredientsInteractor;
import use_cases.user_enter_indredients_interactor.UserEnterIngredientsInputBoundary;

public class main {
    public static void main(String[] args) {
        /*
         * create username first
         * */
//        Fridge userFridge = new CommonFridge();
//        Fridge fridgeOne = new Fridge();
//        Ingredient t = new Ingredient();
//        t.setName("Tomato");
//
//        Ingredient l = new Ingredient();
//        l.setName("Lettuce");
//
//        fridgeOne.addIngredient(l);
//        fridgeOne.addIngredient(t);
//
//        DatabaseGateway database = new Database("Test");
//
//        ArrayList<Object> list = new ArrayList<>();
//
//        list.add(fridgeOne);
//        String username = "Test";
//        database.store(username, list);
//
//        ArrayList<Object> test = database.get(username);
        /*
         * Create user factories first
         * */
        CommonFridgeFactory fridgeFactory = new CommonFridgeFactory();
        CommonUserFactory userFactory = new CommonUserFactory();
        CreateUserAndFridgePresenter presenter = new CreateUserAndFridgeFormatter();

        DatabaseGateway databaseGateway = new Database("Storage");
        CreateUserAndFridgeInputBoundary interactor = new CreateUserandFridgeInteractor(userFactory, fridgeFactory,
                presenter, databaseGateway);
        CreateUserandFridgeController createUserandFridgeController = new CreateUserandFridgeController(interactor);


//        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("Enter Username");
//        String userName = myObj.nextLine();

//        CommonUser shaffaan = createUserandFridgeController.create(userName);
//        System.out.println("the user is " +
//                presenter.prepareSuccessView(shaffaan).getName() + " the current" +
//                        " fridge is ");
//        System.out.println((presenter.prepareSuccessView(shaffaan).getFridge().printIngrediant()));

//        Scanner myObj5 = new Scanner(System.in);
//        System.out.println("Enter Ingrediant");
//        String ingrediant_at_index1 = myObj5.nextLine();

        CommonIngredientFactory ingredientFactory = new CommonIngredientFactory();
        UserEnterIngredientPresenter presenter1 = new UserEnterIngredientFormatter();
/**
 * Don't know how to pass current user and current fridge
 */
        UserEnterIngredientsInputBoundary interactorforenteringingredients =
                new UserEnterIngredientsInteractor(ingredientFactory, presenter1, databaseGateway);

        UserEnterIngredientsController userEnterIngredientsController =
                new UserEnterIngredientsController(interactorforenteringingredients);


//        User_Enter_Ingrediants_Input_Boundry interactor2 = new
//                UserEnterIngredientsInteractor(shaffaan, shaffaan.getFridge(),ingredientFactory,presenter1);
//        User_Enter_Ingrediants_Controller userEnterIngrediantsController = new User_Enter_Ingrediants_Controller(interactor2);

//        CommonIngredient ing = userEnterIngrediantsController.create(ingrediant_at_index1);
//        System.out.println(" You have added" + presenter1.prepareSuccessView(ing).getName() + "new fridge is " +
//                (presenter.prepareSuccessView(shaffaan).getFridge().printIngrediant()));
    }}