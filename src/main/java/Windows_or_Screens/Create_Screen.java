//package Windows_or_Screens;
//
//import controllers.CreateUserandFridgeController;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Create_Screen extends JPanel implements ActionListener {
//    /**
//     * The username chosen by the user
//     */
//    JTextField username = new JTextField(15);
//
//    /**
//     * The controller
//     */
//    CreateUserandFridgeController createUserandFridgeController;
//
//    /**
//     * A window with a title and a JButton.
//     */
//    public Create_Screen(CreateUserandFridgeController controller) {
//
//        this.createUserandFridgeController = controller;
//
//        JLabel title = new JLabel("Register Screen");
//        title.setAlignmentX(Component.CENTER_ALIGNMENT);
//
//        LabelTextPanel usernameInfo = new LabelTextPanel(
//                new JLabel("Choose username"), username);
//        JButton signUp = new JButton("Sign up");
//
//        JPanel buttons = new JPanel();
//        buttons.add(signUp);
//
//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//
//        this.add(title);
//        this.add(usernameInfo);
//        this.add(buttons);
//
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("button pressed");
//        System.out.println(
//                createUserandFridgeController.create(username.getText())
//        );
//
//    }
//}
