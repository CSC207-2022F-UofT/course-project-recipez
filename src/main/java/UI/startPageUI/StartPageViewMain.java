package UI.startPageUI;

import UI.resultPage.ResultsPageViewModel;
import controllers.CreateUserAndFridgeController;
import controllers.SearchController;
import controllers.UserEnterIngredientsController;
import controllers.LoginController;

import javax.swing.*;
import java.awt.*;

/**
 * Facade for UI start page. Manages if start page is in welcome, register, or login state.
 */

public class StartPageViewMain extends JPanel{

    /**
     * Constructor for the startPageViewMain class
     * @param viewModel viewModel containing data for view to present
     * @param controller createUserAndFridge Controller to begin use case for registering/logging in users
     */
    public StartPageViewMain(StartPageViewModel viewModel, CreateUserAndFridgeController controller, LoginController loginController, UserEnterIngredientsController ingredientsController, SearchController searchController, ResultsPageViewModel resultsPageViewModel) {

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Welcome to RecipeEZ!");
        JPanel welcomePanel = new JPanel();
        welcomePanel.add(title);

        CardLayout screenLayout = new CardLayout();

        JPanel startScreens = new JPanel();
        startScreens.setLayout(screenLayout);

        StartPageViewWelcome welcome = new StartPageViewWelcome(viewModel, controller, startScreens, screenLayout);
        RegisterUserView register = new RegisterUserView(viewModel, controller, startScreens, screenLayout);
        UserLoginView login = new UserLoginView(viewModel, loginController, ingredientsController, searchController, startScreens, screenLayout, resultsPageViewModel);

        startScreens.add(welcome , "Main");
        startScreens.add(register, "register");
        startScreens.add(login, "login");

        screenLayout.show(startScreens, viewModel.pageState);

        add(welcomePanel, BorderLayout.NORTH);
        add(startScreens, BorderLayout.SOUTH);

    }
}
