package presenters.startPageUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Facade for UI start page. Manages if start page is in welcome, register, or login state.
 */

public class startPageViewMain extends JPanel{
    private startPageViewModel viewModel;
    private JPanel startScreens;
    private CardLayout screenLayout;

    /**
     * Constructor for startPageViewMain class
     *
     * @param viewModel the view model for the start page
     */
    public startPageViewMain(startPageViewModel viewModel) {
        this.viewModel = viewModel;

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Welcome to RecipeEZ!");
        JPanel welcomePanel = new JPanel();
        welcomePanel.add(title);

        CardLayout screenLayout = new CardLayout();

        JPanel startScreens = new JPanel();
        startScreens.setLayout(screenLayout);

        startPageViewWelcome welcome = new startPageViewWelcome(viewModel, startScreens, screenLayout);
        registerUserView register = new registerUserView(viewModel, startScreens, screenLayout);
        userLoginView login = new userLoginView(viewModel, startScreens, screenLayout);

        startScreens.add(welcome , "main");
        startScreens.add(register, "register");
        startScreens.add(login, "login");

        screenLayout.show(startScreens, viewModel.pageState);

        add(welcomePanel, BorderLayout.NORTH);
        add(startScreens, BorderLayout.SOUTH);

    }
}
