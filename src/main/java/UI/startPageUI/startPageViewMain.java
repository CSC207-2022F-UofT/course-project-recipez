package UI.startPageUI;

import UI.resultPage.ResultsPageViewModel;
import controllers.CreateUserAndFridgeController;
import controllers.SearchController;
import controllers.UserEnterIngredientsController;
import controllers.loginController;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Facade for UI start page. Manages if start page is in welcome, register, or login state.
 */

public class startPageViewMain extends JPanel{
    private startPageViewModel viewModel;
    private CreateUserAndFridgeController registerController;
    private loginController loginController;
    private UserEnterIngredientsController ingredientsController;
    private SearchController searchController;
    private JPanel startScreens;
    private CardLayout screenLayout;

    private ResultsPageViewModel resultsPageViewModel;

    /**
     * Constructor for the startPageViewMain class
     * @param viewModel viewModel containing data for view to present
     * @param controller createUserAndFridge Controller to begin use case for registering/logging in users
     */
    public startPageViewMain(startPageViewModel viewModel, CreateUserAndFridgeController controller, loginController loginController, UserEnterIngredientsController ingredientsController, SearchController searchController, ResultsPageViewModel resultsPageViewModel) {
        this.viewModel = viewModel;
        this.registerController = controller;
        this.loginController = loginController;
        this.ingredientsController = ingredientsController;
        this.searchController = searchController;
        this.resultsPageViewModel = resultsPageViewModel;

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Welcome to RecipeEZ!");
        JPanel welcomePanel = new JPanel();
        welcomePanel.add(title);

        CardLayout screenLayout = new CardLayout();

        JPanel startScreens = new JPanel();
        startScreens.setLayout(screenLayout);

        startPageViewWelcome welcome = new startPageViewWelcome(viewModel, controller, startScreens, screenLayout);
        registerUserView register = new registerUserView(viewModel, controller, startScreens, screenLayout);
        userLoginView login = new userLoginView(viewModel, loginController, ingredientsController, searchController, startScreens, screenLayout, resultsPageViewModel);

        startScreens.add(welcome , "main");
        startScreens.add(register, "register");
        startScreens.add(login, "login");

        screenLayout.show(startScreens, viewModel.pageState);

        add(welcomePanel, BorderLayout.NORTH);
        add(startScreens, BorderLayout.SOUTH);

    }
}
