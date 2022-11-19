package presenters;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


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

        for (int count: RECIPEARRAYLIST){
            Recipe recipe = RECIPEARRAYLIST.get(count);
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
