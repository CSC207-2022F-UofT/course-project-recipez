package presenters.startPageUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;


public class startPageViewWelcome extends JPanel implements ActionListener{
    private final startPageViewModel viewModel;
    private final JButton register;
    private final JButton login;

    private JPanel screens;

    private CardLayout screenLayout;

    public startPageViewWelcome(startPageViewModel viewModel, JPanel screens, CardLayout screenLayout) {
        this.viewModel = viewModel;
        this.screens = screens;
        this.screenLayout = screenLayout;


        this.register = new JButton("Register");
        this.login = new JButton("Login");
        register.addActionListener(this);
        login.addActionListener(this);

        setLayout(new BorderLayout());

        JPanel buttons = new JPanel();
        buttons.add(register);
        buttons.add(login);

        add(buttons, BorderLayout.CENTER);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == register) {
            try {
                viewModel.enterUserRegistrationPage();
                screenLayout.show(screens, viewModel.pageState);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource() == login) {
            try {
                viewModel.enterLoginPage();
                screenLayout.show(screens, viewModel.pageState);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    };
}
