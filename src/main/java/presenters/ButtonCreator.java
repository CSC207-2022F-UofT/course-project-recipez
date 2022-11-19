package presenters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ButtonCreator {

    private final String imageUrl;

    private final String recipeName;

    private final String recipeUrl;

    public ButtonCreator(String recipeName, String recipeUrl, String imageUrl) {
        this.recipeName = recipeName;
        this.recipeUrl = recipeUrl;
        this.imageUrl = imageUrl;
    }

    public JButton makeButton() throws MalformedURLException {
        JButton button = new JButton(this.recipeName);

        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setHorizontalTextPosition(JButton.CENTER);

        URL url = new URL(this.imageUrl); //Converting imageUrl from String to URL
        ImageIcon tempIcon = new ImageIcon(url);
        Image tempImg = tempIcon.getImage(); //Getting Image from tempIcon
        Image newImg = tempImg.getScaledInstance(100,100, Image.SCALE_SMOOTH); //Resizing image
        ImageIcon resizedIcon = new ImageIcon(newImg);

        button.setIcon(resizedIcon); //Adding ImageIcon to the button

        String urlString = this.recipeUrl;
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(java.net.URI.create(urlString));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
        return button;
        }
    }
