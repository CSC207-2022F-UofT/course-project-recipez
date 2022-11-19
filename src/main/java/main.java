import controllers.createUserController;
import presenters.mockUserRegisterPresenter;
import presenters.startPageUI.startPageViewMain;
import presenters.startPageUI.startPageViewWelcome;
import presenters.startPageUI.startPageViewModel;

import javax.swing.*;
import java.awt.*;

public class main {
    public static void main(String[] args) {
        JFrame application = new JFrame("RecipEZ");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
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
