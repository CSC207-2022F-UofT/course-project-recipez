package UI.resultPage;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import java.net.MalformedURLException;
import java.util.Dictionary;

/**
 *  View UI for results page
 */
public class ResultsPageView extends JFrame {

    ResultsPageViewModel viewModel;

    /**
     *
     * @param viewModel Data Structure used for results page
     */
    public ResultsPageView(ResultsPageViewModel viewModel) {
        this.viewModel = viewModel;


        //Creates a result page
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,20, 20));
        this.setVisible(true);

    }

    public void updateView() throws MalformedURLException {

        //Creates results panel
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(1000, 560));
        panel.setLayout(new FlowLayout());
        panel.setBackground(new Color(234, 221, 202));

        //Enable scrolling for results panel
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.getContentPane().add(scrollPane);

        //Shows error message if recipes dictionary is empty
        if (viewModel.recipes.isEmpty()) {
            JLabel errorLabel = new JLabel(viewModel.errorMessage);
            panel.add(errorLabel);
        }

        // Adds each of the recipes as buttons if no error
        else {
            for (Dictionary<String, Object> count : viewModel.recipes) {
                String imgUrl = count.get("Image").toString();
                imgUrl = imgUrl.substring(1, imgUrl.length() - 1);
                JButton button = new ButtonCreator(count.get("Name").toString(), count.get("URL").toString(),
                        imgUrl).makeButton();
                panel.add(button);
            }
        }

        //Creates border of the results with heading "Showing Results"
        Border resultsBorder = BorderFactory.createTitledBorder("Showing Results");
        panel.setBorder(resultsBorder);

        this.add(panel);
    }

}
