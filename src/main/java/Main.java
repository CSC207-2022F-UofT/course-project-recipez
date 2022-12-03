import UI.resultPage.ResultsPageViewModel;
import UI.startPageUI.startPageViewMain;
import UI.startPageUI.startPageViewModel;
import controllers.SearchController;
import controllers.loginController;
import database.Database;
import database.DatabaseGateway;
import controllers.CreateUserAndFridgeController;
import controllers.UserEnterIngredientsController;
import entities.fridge.CommonFridgeFactory;
import entities.ingredient.CommonIngredientFactory;
import entities.recipe.CommonRecipeFactory;
import entities.user.CommonUserFactory;
import gateways.IApiGateway;
import gateways.JavaHttpGateway;
import presenters.create_user_and_fridge.CreateUserAndFridgeFormatter;
import presenters.create_user_and_fridge.CreateUserAndFridgePresenter;
import presenters.enter_ingredient.UserEnterIngredientFormatter;
import presenters.enter_ingredient.UserEnterIngredientPresenter;
import presenters.login.loginFormatter;
import presenters.login.loginPresenter;
import presenters.search.*;
import use_cases.create_user_and_fridge.CreateUserAndFridgeInputBoundary;
import use_cases.create_user_and_fridge.CreateUserAndFridgeInteractor;
import use_cases.enter_indredients_usecase.UserEnterIngredientsInputBoundary;
import use_cases.enter_indredients_usecase.UserEnterIngredientsInteractor;
import use_cases.login_usecase.LoginInteractor;
import use_cases.login_usecase.loginInputBoundary;
import use_cases.searchUseCase.SearchInputBoundary;
import use_cases.searchUseCase.SearchInteractor;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        final int screenHeight = 200;
        final int screenWidth = 550;

        CommonFridgeFactory fridgeFactory = new CommonFridgeFactory();
        CommonUserFactory userFactory = new CommonUserFactory();
        CommonRecipeFactory recipeFactory = new CommonRecipeFactory();

        JFrame application = new JFrame("RecipEZ");
        application.setSize(screenWidth,screenHeight);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        DatabaseGateway databaseGateway = new Database("Storage");

        startPageViewModel startViewModel = new startPageViewModel();
        CreateUserAndFridgePresenter presenter = new CreateUserAndFridgeFormatter(startViewModel);
        loginPresenter loginPresenter = new loginFormatter(startViewModel);

        CreateUserAndFridgeInputBoundary interactor = new CreateUserAndFridgeInteractor(userFactory, fridgeFactory,
                presenter, databaseGateway);
        CreateUserAndFridgeController createUserandFridgeController = new CreateUserAndFridgeController(interactor);

        CommonIngredientFactory ingredientFactory = new CommonIngredientFactory();
        UserEnterIngredientPresenter presenter1 = new UserEnterIngredientFormatter();

        UserEnterIngredientsInputBoundary interactorforenteringingredients =
                new UserEnterIngredientsInteractor(ingredientFactory, presenter1, databaseGateway);

        UserEnterIngredientsController userEnterIngredientsController =
                new UserEnterIngredientsController(interactorforenteringingredients);

        loginInputBoundary loginInputinteractor= new LoginInteractor(databaseGateway,loginPresenter);
        loginController loginController = new loginController(loginInputinteractor);

        IApiGateway apiGateway = new JavaHttpGateway();
        ResultsPageViewModel resultViewModel = new ResultsPageViewModel();
        SearchPresenter searchPresenter = new SearchFormatter(resultViewModel);
        SearchInputBoundary searchInteractor = new SearchInteractor(apiGateway, databaseGateway, recipeFactory, searchPresenter);
        SearchController searchController = new SearchController(searchInteractor);

        startPageViewMain startScreen = new startPageViewMain(startViewModel, createUserandFridgeController, loginController, userEnterIngredientsController, searchController, resultViewModel);
        screens.add(startScreen, "welcome");
        cardLayout.show(screens, "register");
        application.setVisible(true);
    }
}
