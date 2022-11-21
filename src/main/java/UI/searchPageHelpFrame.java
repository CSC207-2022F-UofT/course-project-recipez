package UI;

import controllers.SearchController;
import controllers.UserEnterIngredientsController;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class searchPageHelpFrame extends JFrame implements ActionListener {
    //This class contains the code to build the searchpage interface, and implements ActionListener
    //so that it enables button click and drop down box function.
    JButton button_submit;
    JButton open_fridge;
    JButton search;
    JTextField ingredient_input;

    JComboBox<String> mealType;
    JComboBox<String> time;
    JComboBox<String> calories;

    UserEnterIngredientsController enterIngredientsController;

    SearchController searchController;

    String currentUser;
    String mealTypeFilter;
    String caloriesFilter;
    String cookTimeFilter;

    public searchPageHelpFrame(UserEnterIngredientsController ingredientsController, SearchController searchController, String username) {
        this.enterIngredientsController = ingredientsController;
        this.searchController = searchController;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.currentUser = username;

        //creates the button for submitting the ingredients
        button_submit = new JButton("Submit");
        button_submit.addActionListener(this);
        button_submit.setBounds(560, 100, 280, 50);

        //creates the textfield for user to input
        ingredient_input = new JTextField();
        ingredient_input.setPreferredSize(new Dimension(300, 25));
        ingredient_input.setBounds(60, 100, 500, 50);

        //creates the test"Put your ingredients here:" and set it to appropriate place and font
        JLabel label1 = new JLabel();
        label1.setText("Put your ingredients here: (One at a time)");
        label1.setBounds(60, 50, 800, 50);
        label1.setFont(new Font(null, Font.PLAIN, 25));

        //creates panel1 and add label1, submit button, and textfield to it
        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 0, 840, 240);
        panel1.add(label1);
        panel1.add(button_submit);
        panel1.add(ingredient_input);
        panel1.setLayout(null);

        //create open_fridge button which pops up a messagebox of what ingredients fridge has.
        open_fridge = new JButton("open your fridge");
        open_fridge.setBounds(300, 80, 240, 80);
        open_fridge.addActionListener(this);

        //sets up panel2 and add open_fridge button to it
        JPanel panel2 = new JPanel();
        panel2.setBounds(0, 240, 840, 480);
        panel2.setLayout(null);
        panel2.add(open_fridge);

        //sets up panel3
        JPanel panel3 = new JPanel();
        panel3.setBounds(840, 0, 440, 720);
        panel3.setLayout(null);

        //creates filter comboBoxes and add it to panel3
        String[] mealStr = {"No meal filter", "Breakfast", "Brunch", "Lunch/dinner", "Snack", "Teatime"};
        mealType = new JComboBox<String>(mealStr);
//        mealType.addActionListener(e -> mealTypeFilter = (mealType.getSelectedItem()));
        mealType.setBounds(50, 50, 300, 40);

        String[] cookTime = {"No cookTime filter", "Less than 30 minutes", "30-60 minutes", "More than 1 hour"};
        time = new JComboBox<String>(cookTime);
//        time.addActionListener(e -> System.out.println(time.getSelectedItem()));
        time.setBounds(50, 120, 300, 40);

        String[] dishCalories = {"No calories filter", "Less than 300 cal", "300-800 cal", "More than 800 cal"};
        calories = new JComboBox<String>(dishCalories);
//        calories.addActionListener(e -> System.out.println(calories.getSelectedItem()));
        calories.setBounds(50, 190, 300, 40);

        panel3.add(mealType);
        panel3.add(time);
        panel3.add(calories);

        //create a search button allows user to search for recipes and add it to panel 3
        search = new JButton("Search");
        search.addActionListener(this);
        search.setBounds(100, 500, 240, 100);
        panel3.add(search);

        //let the frame resizable and add all panels to it.
        this.setResizable(false);
        this.setLayout(null);
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*When user clicks the submit button, it adds whatever ingredients they put in
        //to the fridge. If the fridge already has this ingredient, it pops up a message
        //says "It is already in the fridge!"*/
        if (e.getSource() == button_submit) {
            enterIngredientsController.create(ingredient_input.getText(), currentUser);

/*            else {fridgeFood.add(ingredient_input.getText());}
        }*/
            //When user clicks the open_fridge button, they can see what food they have
            //inside the fridge.
            /*if (e.getSource() == open_fridge) {
                JOptionPane.showMessageDialog(
                        null,
                        fridgeFood.toString(),
                        "Fridge",
                        JOptionPane.PLAIN_MESSAGE);
                //
            }*/
        }
        if (e.getSource() == search){
            searchController.search(currentUser,
                    mealType.getSelectedItem().toString(),
                    calories.getSelectedItem().toString(),
                    time.getSelectedItem().toString());
        }
    }
}
