package presenters.startPageUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;


public class startPageViewMain extends JPanel{
    private startPageViewModel viewModel;

    private JPanel startScreens;
    private CardLayout screenLayout;

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
        registerUserView register = new registerUserView(viewModel);
        userLoginView login = new userLoginView(viewModel);

        startScreens.add(welcome , "main");
        startScreens.add(register, "register");
        startScreens.add(login, "login");

        screenLayout.show(startScreens, viewModel.pageState);

        add(welcomePanel, BorderLayout.NORTH);
        add(startScreens, BorderLayout.SOUTH);

    }

}
