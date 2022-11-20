package presenters;


import javax.swing.*;
import java.net.MalformedURLException;

public class ResultsPageMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ResultsPageFrame() ;
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
