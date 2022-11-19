package presenters.startPageUI;

import controllers.createUserController;

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

    public userLoginView(startPageViewModel viewModel, JPanel screens, CardLayout screenLayout) {
        this.viewModel = viewModel;
        this.screens = screens;
        this.screenLayout = screenLayout;

        this.username = new JTextField(15);

        this.login_response = new JTextField(30);
        this.login_response.setEditable(false);
        this.login_response.setOpaque(true);
        this.login_response.setBorder(null);

        JLabel enter_user_label = new JLabel("Enter Username: ");
        login_user_btn = new JButton("Login");
        back = new JButton("Back");
        back.addActionListener(this);

        JPanel entry_formatter = new JPanel();
        entry_formatter.add(enter_user_label);
        entry_formatter.add(username);
        entry_formatter.add(login_user_btn);

        JPanel button_formatter = new JPanel();
        button_formatter.add(back);

        JPanel response_formatter = new JPanel();
        response_formatter.add(this.login_response);

        this.add(entry_formatter);
        this.add(button_formatter);
        this.add(response_formatter);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            viewModel.enterMainPage();
            screenLayout.show(screens, viewModel.pageState);
        }
        if (e.getSource() == login_user_btn) {
            viewModel.attemptLogin(username.getText());
        }
    }
}
