package UI.startPageUI;

import UI.searchPageHelpFrame;
import controllers.CreateUserandFridgeController;
import controllers.SearchController;
import controllers.UserEnterIngredientsController;
import controllers.loginController;
import entities.user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userLoginView extends JPanel implements ActionListener {

    private startPageViewModel viewModel;
    private JTextField username;

    private JPanel screens;
    private CardLayout screenLayout;

    private JButton back;

    private JButton login_user_btn;

    private JTextField login_response;

    private loginController loginController;

    private UserEnterIngredientsController ingredientsController;

    private SearchController searchController;

    public userLoginView(startPageViewModel viewModel, loginController loginController, UserEnterIngredientsController ingredientsController, SearchController searchController, JPanel screens, CardLayout screenLayout) {
        this.viewModel = viewModel;
        this.screens = screens;
        this.screenLayout = screenLayout;
        this.loginController = loginController;
        this.ingredientsController = ingredientsController;
        this.searchController = searchController;

        this.username = new JTextField(15);

        this.login_response = new JTextField(30);
        this.login_response.setEditable(false);
        this.login_response.setOpaque(false);
        this.login_response.setBorder(null);
        this.login_response.setAlignmentX(CENTER_ALIGNMENT);

        this.login_response.setText(viewModel.attempt_login_response);

        setLayout(new BorderLayout());

        JLabel enter_user_label = new JLabel("Enter Username: ");
        login_user_btn = new JButton("Login");
        login_user_btn.addActionListener(this);
        back = new JButton("Back");
        back.addActionListener(this);

        JPanel entry_formatter = new JPanel();
        entry_formatter.add(enter_user_label);
        entry_formatter.add(username);
        entry_formatter.add(login_user_btn);
        entry_formatter.add(back);

        JPanel response_formatter = new JPanel();
        response_formatter.add(this.login_response);

        this.add(response_formatter, BorderLayout.NORTH);
        this.add(entry_formatter, BorderLayout.CENTER);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            viewModel.backToMain();
            this.login_response.setText(viewModel.create_register_response);
            this.username.setText("");
            screenLayout.show(screens, viewModel.pageState);
        }
        if (e.getSource() == login_user_btn) {
            loginController.create(username.getText());
            this.login_response.setText(viewModel.attempt_login_response);
            JOptionPane.showMessageDialog(this, viewModel.attempt_login_response);

            if (viewModel.loggedIn) {
                new searchPageHelpFrame(this.ingredientsController, this.searchController, username.getText());
            }
        }
    }
}
