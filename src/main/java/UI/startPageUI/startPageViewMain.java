package UI.startPageUI;

import controllers.CreateUserandFridgeController;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Facade for UI start page. Manages if start page is in welcome, register, or login state.
 */

public class startPageViewMain extends JPanel{
    private startPageViewModel viewModel;
    private CreateUserandFridgeController registerController;
    private JPanel startScreens;
    private CardLayout screenLayout;

    /**
     * Constructor for the startPageViewMain class
     * @param viewModel viewModel containing data for view to present
     * @param controller createUserAndFridge Controller to begin use case for registering/logging in users
     */
    public startPageViewMain(startPageViewModel viewModel, CreateUserandFridgeController controller) {
        this.viewModel = viewModel;
        this.registerController = controller;

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Welcome to RecipeEZ!");
        JPanel welcomePanel = new JPanel();
        welcomePanel.add(title);

        CardLayout screenLayout = new CardLayout();

        JPanel startScreens = new JPanel();
        startScreens.setLayout(screenLayout);

        startPageViewWelcome welcome = new startPageViewWelcome(viewModel, registerController, startScreens, screenLayout);
        registerUserView register = new registerUserView(viewModel, registerController, startScreens, screenLayout);
        userLoginView login = new userLoginView(viewModel, registerController, startScreens, screenLayout);

        startScreens.add(welcome , "main");
        startScreens.add(register, "register");
        startScreens.add(login, "login");

        screenLayout.show(startScreens, viewModel.pageState);

        add(welcomePanel, BorderLayout.NORTH);
        add(startScreens, BorderLayout.SOUTH);

    }
}
