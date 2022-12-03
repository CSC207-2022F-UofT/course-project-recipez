package UI.startPageUI;

import controllers.CreateUserAndFridgeController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * startPageViewWelcome UI for first page user interacts with.
 */
public class startPageViewWelcome extends JPanel implements ActionListener{
    private final startPageViewModel viewModel;

    private final JButton register;
    private final JButton login;
    private final JPanel screens;
    private final CardLayout screenLayout;

    /**
     * Constructor for UI welcome page
     * @param viewModel viewModel containing data for UI
     * @param controller createUser controller
     * @param screens stores the multiple screens in the UI
     * @param screenLayout defines the ordering of the screens so UI can switch
     */
    public startPageViewWelcome(startPageViewModel viewModel, CreateUserAndFridgeController controller, JPanel screens, CardLayout screenLayout) {
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

    /**
     * Switches UI to register or login view depending on UI
     * @param e the event to be processed
     */

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == register) {
            try {
                viewModel.pageState = "register";
                screenLayout.show(screens, viewModel.pageState);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource() == login) {
            try {
                viewModel.pageState = "login";
                screenLayout.show(screens, viewModel.pageState);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
