package presenters;

import UI.searchPageHelpFrame;
import controllers.RecipeBuilderController;
import controllers.UserEnterIngredientsController;
import entities.recipe.Recipe;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.Dictionary;

/**
 *  View UI for results page
 */
public class ResultsPageView extends JFrame {

    RecipeBuilderController recipeController;

    ResultsPageViewModel viewModel;

    UserEnterIngredientsController ingredientsController;

    JTextField username;

    /**
     *
     * @param recipeController controller for results page, i.e recipebuilder
     * @param viewModel Data Structure used for results page
     * @param ingredientsController controller for search page (for going back to search page button)
     * @param username name of the user.
     */
    ResultsPageView(RecipeBuilderController recipeController, ResultsPageViewModel viewModel,
                    UserEnterIngredientsController ingredientsController, JTextField username)
            throws MalformedURLException {
        this.recipeController = recipeController;
        this.viewModel = viewModel;
        this.ingredientsController = ingredientsController;
        this.username = username;

        //Creates a result page
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,20, 20));

        //Creates results panel
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(1000, 600));
        panel.setLayout(new FlowLayout());

        //Shows error message if recipes dictionary is empty
        if (viewModel.recipes.isEmpty()) {
            JLabel errorLabel = new JLabel(viewModel.errorMessage);
            panel.add(errorLabel);
        }
        // Adds each of the recipes as buttons if no error
        else {
            for (Recipe count : viewModel.recipes) {
                Dictionary<String, Object> recipeDict = count.getRecipeInfo();
                JButton button = new ButtonCreator(recipeDict.get("Name").toString(),
                        recipeDict.get("URL").toString(),
                        recipeDict.get("Image").toString()).makeButton();
                panel.add(button);
            }
        }

        //Creates border of the results with heading "Showing Results"
        Border resultsBorder = BorderFactory.createTitledBorder("Showing Results");
        panel.setBorder(resultsBorder);

        //Back button to direct user back to search page
        JButton backBtn = new JButton("Search Again");
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new searchPageHelpFrame(ingredientsController, username.getText());
            }
        });
        panel.add(backBtn, FlowLayout.LEFT);

        this.setVisible(true);
        this.add(panel);
    }
}
