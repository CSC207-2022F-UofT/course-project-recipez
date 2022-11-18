package presenters.startPageUI;

import controllers.createUserController;

import javax.swing.*;

public class userLoginView extends JPanel{

    private startPageViewModel viewModel;
    private JTextField username;

    public userLoginView(startPageViewModel viewModel) {
        this.viewModel = viewModel;

        this.username = new JTextField(15);

        JLabel enter_user_label = new JLabel("Enter Username: ");
        JButton login_user_btn = new JButton("Login");

        JPanel entry_formatter = new JPanel();
        entry_formatter.add(enter_user_label);
        entry_formatter.add(username);

        JPanel button_formatter = new JPanel();
        button_formatter.add(login_user_btn);

        this.add(entry_formatter);
        this.add(button_formatter);
    }
}
