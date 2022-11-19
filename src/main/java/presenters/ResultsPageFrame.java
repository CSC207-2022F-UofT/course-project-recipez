package presenters;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ResultsPageFrame extends JFrame {

    ResultsPageFrame() throws MalformedURLException {
        //Creates a result page
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,20, 20));

        //Creates results panel
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(1000, 600));
        panel.setLayout(new FlowLayout());

        //Example of a button (recipe)
        URL url2 = new URL("https://edamam-product-images.s3.amazonaws.com/web-img/e42/e42f9119813e890af34c259785ae1cfb.jpg?X-Amz-Security-Token=IQoJb3JpZ2luX2VjEEcaCXVzLWVhc3QtMSJGMEQCIAlSU%2FHlTUmcGquOC8ShXaTwZywtPoxLHCFxs62oatdzAiAVpkn0M8J0vn0lMVghnY1D3NuEvk3GGI82%2BMhuu5IbsCrMBAhQEAAaDDE4NzAxNzE1MDk4NiIMfHXSwB392BxZzp9yKqkEnns0AMUUYIF4LnkSaiXo%2BFK78rOCw%2F8Ze48EWfCGejYR%2FHZz2sNtov5zBhw8kwrm1Kypkn0srkrgtSwFP5eNHCnw7o76ul6IRlI%2FckAhA4fp7BdzEkzIOEgKfJuSRN3vwZZzIR9%2BNjjXc8TXNHy%2B8evgZxWMyBlabQowWbsvkpfISX9JeJq5B0p9z9eBhBp8tHwjM9QS2l2icRsaed2bT4EmQ1wQv3ifgH4nnB79HiCdmH5R6GahnmHeYeRQM86g9GdOQXRtU7TcAKV0pPuinShdIACfUmy7Z7mkR6A8EILr8xeWghQ%2BORe3jf%2F%2BB3RehNwtpE7IlMUF8acraz1qg5WphUH2t3OJN9YLlpO2WTBD7VBc1mn1ORIIRp7STuQA5F0pls8D2Jmu8UvfxwVZCoHpu7p%2BdkVxHvC%2Bzr1MUVFY7IZkgtPrXKPKpxqskKkQq1vMjHokSJ0Y35lqD%2FSmjiKXc01Ktbi%2Bx1HPzgJmbX28ZjeddKGo7%2FUVsDu1TRRnx%2ByfQ3vpXKIFKuRN9WAxj9E8VzlwtJQvczvxlTFcz1gOkrlDjoSUmsAnfsC5h%2FkdYP51L17jP1X8qcOFjCZsFzWr5OYJkvDL416XKc23QJOPxhtjjYS8TWsqoGamURdN9FKAKV0XRw2r5jv2GhWosdlBUI2U9Zf38fYs4i%2BRhYifY2vd%2BA%2B3g0gn36cU7RsVLUAd6xnuxcK21K5kA1doJfQkh031qBrYwzCynuCbBjqqAeD05cEpqu9mOaZJNf1%2Bc15tHH0SnDXJRu611uT3mpgMVSVnZhbsjlNgIFhlQ%2BfDaVCYTwt2JhPz095Gm3YtjrsJVeMn0%2FsOwj2gPWG5Y%2F3yTnlXTDHWswFfWTOfNsQ0xNnaAPYmdTHrDRGDNVp1cDk%2BANsPQN6zItDycHsRvraZJKIUSVbW%2BBpmbleFhiavhSQKhnFyE0FJcVMb6FifadSiqP18cthmhWvj&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20221119T002935Z&X-Amz-SignedHeaders=host&X-Amz-Expires=3600&X-Amz-Credential=ASIASXCYXIIFOGNPX7HD%2F20221119%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=bb837068180c40787ecc6c375956bfed200ecdc2b4fa8de4bac35255a7122fd5");
        ImageIcon icon2 = new ImageIcon(url2);
        Image img2 = icon2.getImage();
        Image newimg2 = img2.getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon icon2resized = new ImageIcon(newimg2);
        JButton button2 = new JButton("Chicken Vesuvio");
        button2.setVerticalTextPosition(JButton.BOTTOM);
        button2.setHorizontalTextPosition(JButton.CENTER);
        button2.setIcon(icon2resized);
        button2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(java.net.URI.create("http://www.seriouseats.com/recipes/2011/12/chicken-vesuvio-recipe.html"));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        panel.add(button2);

        URL url1 = new URL("https://edamam-product-images.s3.amazonaws.com/web-img/e42/e42f9119813e890af34c259785ae1cfb.jpg?X-Amz-Security-Token=IQoJb3JpZ2luX2VjEEcaCXVzLWVhc3QtMSJGMEQCIAlSU%2FHlTUmcGquOC8ShXaTwZywtPoxLHCFxs62oatdzAiAVpkn0M8J0vn0lMVghnY1D3NuEvk3GGI82%2BMhuu5IbsCrMBAhQEAAaDDE4NzAxNzE1MDk4NiIMfHXSwB392BxZzp9yKqkEnns0AMUUYIF4LnkSaiXo%2BFK78rOCw%2F8Ze48EWfCGejYR%2FHZz2sNtov5zBhw8kwrm1Kypkn0srkrgtSwFP5eNHCnw7o76ul6IRlI%2FckAhA4fp7BdzEkzIOEgKfJuSRN3vwZZzIR9%2BNjjXc8TXNHy%2B8evgZxWMyBlabQowWbsvkpfISX9JeJq5B0p9z9eBhBp8tHwjM9QS2l2icRsaed2bT4EmQ1wQv3ifgH4nnB79HiCdmH5R6GahnmHeYeRQM86g9GdOQXRtU7TcAKV0pPuinShdIACfUmy7Z7mkR6A8EILr8xeWghQ%2BORe3jf%2F%2BB3RehNwtpE7IlMUF8acraz1qg5WphUH2t3OJN9YLlpO2WTBD7VBc1mn1ORIIRp7STuQA5F0pls8D2Jmu8UvfxwVZCoHpu7p%2BdkVxHvC%2Bzr1MUVFY7IZkgtPrXKPKpxqskKkQq1vMjHokSJ0Y35lqD%2FSmjiKXc01Ktbi%2Bx1HPzgJmbX28ZjeddKGo7%2FUVsDu1TRRnx%2ByfQ3vpXKIFKuRN9WAxj9E8VzlwtJQvczvxlTFcz1gOkrlDjoSUmsAnfsC5h%2FkdYP51L17jP1X8qcOFjCZsFzWr5OYJkvDL416XKc23QJOPxhtjjYS8TWsqoGamURdN9FKAKV0XRw2r5jv2GhWosdlBUI2U9Zf38fYs4i%2BRhYifY2vd%2BA%2B3g0gn36cU7RsVLUAd6xnuxcK21K5kA1doJfQkh031qBrYwzCynuCbBjqqAeD05cEpqu9mOaZJNf1%2Bc15tHH0SnDXJRu611uT3mpgMVSVnZhbsjlNgIFhlQ%2BfDaVCYTwt2JhPz095Gm3YtjrsJVeMn0%2FsOwj2gPWG5Y%2F3yTnlXTDHWswFfWTOfNsQ0xNnaAPYmdTHrDRGDNVp1cDk%2BANsPQN6zItDycHsRvraZJKIUSVbW%2BBpmbleFhiavhSQKhnFyE0FJcVMb6FifadSiqP18cthmhWvj&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20221119T002935Z&X-Amz-SignedHeaders=host&X-Amz-Expires=3600&X-Amz-Credential=ASIASXCYXIIFOGNPX7HD%2F20221119%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=bb837068180c40787ecc6c375956bfed200ecdc2b4fa8de4bac35255a7122fd5");
        ImageIcon icon1 = new ImageIcon(url1);
        Image img1 = icon1.getImage();
        Image newImg1 = img1.getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon icon1resized = new ImageIcon(newImg1);
        JButton button1 = new JButton("Chicken Vesuvio");
        button1.setVerticalTextPosition(JButton.BOTTOM);
        button1.setHorizontalTextPosition(JButton.CENTER);
        button1.setIcon(icon1resized);
        button2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(java.net.URI.create("http://www.seriouseats.com/recipes/2011/12/chicken-vesuvio-recipe.html"));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        panel.add(button1);



        //Creates border of the results with heading "Showing Results"
        Border resultsBorder = BorderFactory.createTitledBorder("Showing Results");
        panel.setBorder(resultsBorder);

        this.setVisible(true);
        this.add(panel);



    }
}
