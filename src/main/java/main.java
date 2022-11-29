import UI.resultPage.ResultsPageViewModel;
import UI.resultPage.ResultsPageViewModelInterface;
import UI.startPageUI.startPageViewMain;
import UI.startPageUI.startPageViewModel;
import controllers.SearchController;
import controllers.loginController;
import database.Database;
import database.DatabaseGateway;
import controllers.CreateUserandFridgeController;
import controllers.UserEnterIngredientsController;
import entities.fridge.CommonFridgeFactory;
import entities.ingredient.CommonIngredientFactory;
import entities.recipe.CommonRecipeFactory;
import entities.recipe.RecipeFactory;
import entities.user.CommonUserFactory;
import gateways.IApiGateway;
import gateways.JavaHttpGateway;
import presenters.create_user_and_fridge.CreateUserAndFridgeFormatter;
import presenters.create_user_and_fridge.CreateUserAndFridgePresenter;
import presenters.enter_ingredient.UserEnterIngredientFormatter;
import presenters.enter_ingredient.UserEnterIngredientPresenter;
import UI.startPageUI.startPageViewModelInterface;
import presenters.login.loginFormatter;
import presenters.login.loginPresenter;
import presenters.search.*;
import use_cases.create_user_and_fridge.CreateUserAndFridgeInputBoundary;
import use_cases.create_user_and_fridge.CreateUserandFridgeInteractor;
import use_cases.login_usecase.LoginInteractor;
import use_cases.login_usecase.loginInputBoundary;
import use_cases.searchUseCase.SearchInputBoundary;
import use_cases.searchUseCase.SearchInteractor;
import use_cases.searchUseCase.SearchResponseModel;
import use_cases.user_enter_indredients_interactor.UserEnterIngredientsInteractor;
import use_cases.user_enter_indredients_interactor.UserEnterIngredientsInputBoundary;
import javax.swing.*;
import java.awt.*;

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
        CommonRecipeFactory recipeFactory = new CommonRecipeFactory();

        JFrame application = new JFrame("RecipEZ");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        application.setSize(550,200 );
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        DatabaseGateway databaseGateway = new Database("Storage");


        startPageViewModel startViewModel = new startPageViewModel();
        CreateUserAndFridgePresenter presenter = new CreateUserAndFridgeFormatter(startViewModel);
        loginPresenter loginPresenter = new loginFormatter(startViewModel);

        CreateUserAndFridgeInputBoundary interactor = new CreateUserandFridgeInteractor(userFactory, fridgeFactory,
                presenter, databaseGateway);
        CreateUserandFridgeController createUserandFridgeController = new CreateUserandFridgeController(interactor);

        CommonIngredientFactory ingredientFactory = new CommonIngredientFactory();
        UserEnterIngredientPresenter presenter1 = new UserEnterIngredientFormatter();
/**
 * Don't know how to pass current user and current fridge
 */
        UserEnterIngredientsInputBoundary interactorforenteringingredients =
                new UserEnterIngredientsInteractor(ingredientFactory, presenter1, databaseGateway);

        UserEnterIngredientsController userEnterIngredientsController =
                new UserEnterIngredientsController(interactorforenteringingredients);

        loginInputBoundary loginInputinteractor= new LoginInteractor(databaseGateway,loginPresenter);
        loginController loginController = new loginController(loginInputinteractor);

        IApiGateway apiGateway = new JavaHttpGateway();
        ResultsPageViewModelInterface resultViewModel = new ResultsPageViewModel();
        SearchPresenter searchPresenter = new SearchFormatter(resultViewModel);
        SearchInputBoundary searchInteractor = new SearchInteractor(apiGateway, databaseGateway, recipeFactory, searchPresenter);
        SearchController searchController = new SearchController(searchInteractor);

        startPageViewMain startScreen = new startPageViewMain(startViewModel, createUserandFridgeController, loginController, userEnterIngredientsController, searchController, (ResultsPageViewModel) resultViewModel);
        screens.add(startScreen, "welcome");
        cardLayout.show(screens, "register");
        application.setVisible(true);



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


//        User_Enter_Ingrediants_Input_Boundry interactor2 = new
//                UserEnterIngredientsInteractor(shaffaan, shaffaan.getFridge(),ingredientFactory,presenter1);
//        User_Enter_Ingrediants_Controller userEnterIngrediantsController = new User_Enter_Ingrediants_Controller(interactor2);

//        CommonIngredient ing = userEnterIngrediantsController.create(ingrediant_at_index1);
//        System.out.println(" You have added" + presenter1.prepareSuccessView(ing).getName() + "new fridge is " +
//                (presenter.prepareSuccessView(shaffaan).getFridge().printIngrediant()));

    }
}

