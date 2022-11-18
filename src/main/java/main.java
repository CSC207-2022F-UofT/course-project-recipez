import controllers.createUserController;
import presenters.startPageUI.startPageViewMain;
import presenters.startPageUI.startPageViewModel;
import presenters.startPageUI.startPageViewModelInterface;

import javax.swing.*;
import java.awt.*;

public class main {
    public static void main(String[] args) {
        JFrame application = new JFrame("RecipEZ");
        application.setSize(550,200 );
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        createUserController mockRegisterController = new createUserController();

        startPageViewModel startViewModel = new startPageViewModel(mockRegisterController);
        startPageViewMain startScreen = new startPageViewMain(startViewModel);
        screens.add(startScreen, "welcome");
        cardLayout.show(screens, "register");
        application.setVisible(true);
    }
}
