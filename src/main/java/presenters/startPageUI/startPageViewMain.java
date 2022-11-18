package presenters.startPageUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;


public class startPageViewMain extends JPanel implements ActionListener{
    private startPageViewModel viewModel;

    private registerUserView userRegistrationPage;
    private userLoginView userLoginPage;

    private JPanel startPageBody = new JPanel();

    private String currentPage;

    private JButton register;
    private JButton login;

    private CardLayout screenLayout;
    private JPanel startScreens;

    public startPageViewMain(startPageViewModel viewModel) {
        this.viewModel = viewModel;
        this.currentPage = viewModel.pageState;

        this.register = new JButton("Register");
        this.login = new JButton("Login");
        register.addActionListener(this);
        login.addActionListener(this);

        setLayout(new BorderLayout());

//        switch (currentPage) {
//            case "main":
//                startPageBody = new JPanel();
//                JLabel title = new JLabel("Welcome to RecipeEZ!");
//                startPageBody.add(title);
//
//                JPanel buttons = new JPanel();
//                buttons.add(register);
//                buttons.add(login);
//
//                startPageBody.add(buttons, BorderLayout.SOUTH);
//                break;
//            case "register":
//                startPageBody = new registerUserView(viewModel);
//                add(startPageBody, BorderLayout.SOUTH);
//                break;
//            case "login":
//                startPageBody = new userLoginView(viewModel);
//                add(startPageBody, BorderLayout.SOUTH);
//                break;
//
//        }

        JLabel title = new JLabel("Welcome to RecipeEZ!");

        JPanel buttons = new JPanel();
        buttons.add(register);
        buttons.add(login);

        startPageBody.add(title);
        startPageBody.add(buttons);

        screenLayout = new CardLayout();

        startScreens = new JPanel();
        startScreens.setLayout(screenLayout);

        this.add(startPageBody, BorderLayout.NORTH);
        this.add(startScreens, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == register) {
            try {
                viewModel.enterUserRegistrationPage();
                userRegistrationPage = new registerUserView(viewModel);
                startScreens.add(userRegistrationPage, "1");
                screenLayout.show(startScreens, "1");
//                screenLayout.show(startScreens,"1");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource() == login) {
            try {
                viewModel.enterLoginPage();
                userLoginPage = new userLoginView(viewModel);
                startScreens.add(userLoginPage, "2");
                screenLayout.show(startScreens, "2");
//                screenLayout.show(startScreens, "2");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    };
}
