package presenters.startPageUI;

import controllers.createUserController;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;



public class registerUserView extends JPanel implements ActionListener {
    private startPageViewModel viewModel;
    private JTextField username;

    private JButton back;
    private JButton create_user_btn;

    private JPanel screens;
    private CardLayout screenLayout;

    public registerUserView(startPageViewModel viewModel, JPanel screens, CardLayout screenLayout) {
        this.viewModel = viewModel;
        this.screens = screens;
        this.screenLayout = screenLayout;

        this.username = new JTextField(15);

        JLabel create_user_label = new JLabel("Enter Username: ");
        create_user_btn = new JButton("Create User");
        create_user_btn.addActionListener(this);
        back = new JButton("Back");
        back.addActionListener(this);

        JPanel entry_formatter = new JPanel();
        entry_formatter.add(create_user_label);
        entry_formatter.add(username);
        entry_formatter.add(create_user_btn);

        JPanel button_formatter = new JPanel();
        button_formatter.add(back);

        this.add(entry_formatter);
        this.add(button_formatter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            viewModel.enterMainPage();
            screenLayout.show(screens, viewModel.pageState);
        }
        if (e.getSource() == create_user_btn) {
            System.out.println(viewModel.registerUser(username.getText()));
        }
    }
}
