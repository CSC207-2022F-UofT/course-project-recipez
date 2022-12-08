package UI.startPageUI;

import UI.resultPage.ResultsPageViewModel;
import UI.SearchPageHelpFrame;
import controllers.SearchController;
import controllers.UserEnterIngredientsController;
import controllers.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLoginView extends JPanel implements ActionListener {

    private final StartPageViewModel viewModel;
    private final JTextField username;

    private final JPanel screens;
    private final CardLayout screenLayout;

    private final JButton back;

    private final JButton login_user_btn;

    private final JTextField login_response;

    private final LoginController loginController;

    private final UserEnterIngredientsController ingredientsController;

    private final SearchController searchController;

    private final ResultsPageViewModel resultsPageViewModel;

    public UserLoginView(StartPageViewModel viewModel, LoginController loginController, UserEnterIngredientsController ingredientsController, SearchController searchController, JPanel screens, CardLayout screenLayout, ResultsPageViewModel resultsPageViewModel) {
        this.viewModel = viewModel;
        this.screens = screens;
        this.screenLayout = screenLayout;
        this.loginController = loginController;
        this.ingredientsController = ingredientsController;
        this.searchController = searchController;
        this.resultsPageViewModel = resultsPageViewModel;

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
            this.login_response.setText(viewModel.attempt_login_response);
            this.username.setText("");
            screenLayout.show(screens, viewModel.pageState);
        }
        if (e.getSource() == login_user_btn) {
            loginController.create(username.getText());
            this.login_response.setText(viewModel.attempt_login_response);
            JOptionPane.showMessageDialog(this, viewModel.attempt_login_response);

            if (viewModel.loggedIn) {
                new SearchPageHelpFrame(this.ingredientsController, this.searchController, username.getText(), resultsPageViewModel);
            }
        }
    }
}
