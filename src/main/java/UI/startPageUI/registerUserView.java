package UI.startPageUI;

import UI.searchPageHelpFrame;
import controllers.CreateUserandFridgeController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * View UI for user registration page
 */

public class registerUserView extends JPanel implements ActionListener {
    private startPageViewModel viewModel;
    private JTextField username;
    private JButton back;
    private JButton create_user_btn;
    private JPanel screens;
    private CardLayout screenLayout;

    private CreateUserandFridgeController registerController;

    private JTextField register_response;

    public registerUserView(startPageViewModel viewModel, CreateUserandFridgeController controller,
                            JPanel screens, CardLayout screenLayout) {
        this.viewModel = viewModel;
        this.screens = screens;
        this.screenLayout = screenLayout;
        this.registerController = controller;

        this.username = new JTextField(15);

        this.register_response = new JTextField(30);
        this.register_response.setEditable(false);
        this.register_response.setOpaque(false);
        this.register_response.setBorder(null);
        this.register_response.setAlignmentX(CENTER_ALIGNMENT);

        this.register_response.setText(viewModel.create_register_response);

        setLayout(new BorderLayout());
        JLabel create_user_label = new JLabel("Enter Username: ");
        create_user_btn = new JButton("Create User");
        create_user_btn.addActionListener(this);
        back = new JButton("Back");
        back.addActionListener(this);

        JPanel entry_formatter = new JPanel();
        entry_formatter.add(create_user_label);
        entry_formatter.add(username);
        entry_formatter.add(create_user_btn);
        entry_formatter.add(back);
        JPanel response_formatter = new JPanel();
        response_formatter.add(this.register_response);

        this.add(response_formatter, BorderLayout.NORTH);
        this.add(entry_formatter, BorderLayout.SOUTH);
    }

    /**
     * Called when user performs action on register page (either create User or go back)
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            viewModel.backToMain();
            this.register_response.setText(viewModel.create_register_response);
            this.username.setText("");
            screenLayout.show(screens, viewModel.pageState);
        }
        if (e.getSource() == create_user_btn) {
            registerController.create(username.getText());
            this.register_response.setText(viewModel.create_register_response);
            JOptionPane.showMessageDialog(this, viewModel.create_register_response);
            viewModel.pageState = "login";
            screenLayout.show(screens, viewModel.pageState);
        }
    }
}
