package UI.startPageUI;

import controllers.CreateUserandFridgeController;

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

    private CreateUserandFridgeController registerController;

    public userLoginView(startPageViewModel viewModel, CreateUserandFridgeController controller, JPanel screens, CardLayout screenLayout) {
        this.viewModel = viewModel;
        this.screens = screens;
        this.screenLayout = screenLayout;
        this.registerController = controller;

        this.username = new JTextField(15);

        this.login_response = new JTextField(15);
        this.login_response.setEditable(false);
        this.login_response.setOpaque(true);
        this.login_response.setBorder(null);

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

        this.add(entry_formatter, BorderLayout.NORTH);
        this.add(response_formatter, BorderLayout.SOUTH);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            viewModel.pageState = "main";
            screenLayout.show(screens, viewModel.pageState);
        }
        if (e.getSource() == login_user_btn) {
            registerController.create(username.getText());
        }
    }
}
