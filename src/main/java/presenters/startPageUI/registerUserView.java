package presenters.startPageUI;

import controllers.createUserController;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;



public class registerUserView extends JPanel {
    private startPageViewModel viewModel;

    private JTextField username;

    public registerUserView(startPageViewModel viewModel) {
        this.viewModel = viewModel;

        this.username = new JTextField(15);

        JLabel create_user_label = new JLabel("Enter Username: ");
        JButton create_user_btn = new JButton("Create User");

        JPanel entry_formatter = new JPanel();
        entry_formatter.add(create_user_label);
        entry_formatter.add(username);

        JPanel button_formatter = new JPanel();
        button_formatter.add(create_user_btn);

        this.add(entry_formatter);
        this.add(button_formatter);
    }
}
