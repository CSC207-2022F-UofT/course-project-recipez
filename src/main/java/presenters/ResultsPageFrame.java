package presenters;

import entities.recipe.Recipe;
import useCases.RecipeBuilderPresenter;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import java.net.MalformedURLException;



public class ResultsPageFrame extends JFrame implements RecipeBuilderPresenter {

    ResultsPageFrame() throws MalformedURLException {
        //Creates a result page
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,20, 20));

        //Creates results panel
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(1000, 600));
        panel.setLayout(new FlowLayout());

        for (int count: recipeResponse) {
            Recipe recipe = recipeResponse.get(count);
            panel.add(ButtonCreator(recipe.getName,
                    recipe.getRecipe, recipe.getImg));

        }

        //Creates border of the results with heading "Showing Results"
        Border resultsBorder = BorderFactory.createTitledBorder("Showing Results");
        panel.setBorder(resultsBorder);

        this.setVisible(true);
        this.add(panel);



    }
}
