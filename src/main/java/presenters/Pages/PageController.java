package presenters.Pages;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.awt.*;

public class PageController extends Application{

    Stage window;
    Scene StartPage, SearchPage, ResultPage;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        //Button 1, appears on the StartPage, and clicks it bring user to the search page
        Button button1 = new Button("Go to search page!");
        button1.setOnAction(e -> window.setScene(SearchPage));

        //Add button 1 to StartPage
        StackPane layout_Start_Page = new StackPane();
        layout_Start_Page.getChildren().add(button1);
        StartPage = new Scene(layout_Start_Page, 1980, 1080);

        //Button 2, appears on the SearchPage, and clicks it bring user to the Result page
        Button button2 = new Button("Go to Result page!");
        button2.setOnAction(e -> window.setScene(SearchPage));

        //Add button 2 to SearchPage
        StackPane layout_Search_Page = new StackPane();
        layout_Search_Page.getChildren().add(button2);
        SearchPage = new Scene(layout_Search_Page, 1980, 1080);

        //Button 3, appears on the ResultPage, and clicks it bring user back to the Search page
        Button button3 = new Button("Go back to Search page!");
        button3.setOnAction(e -> window.setScene(ResultPage));

        //Add button 3 to ResultPage
        StackPane layout_Result_Page = new StackPane();
        layout_Result_Page.getChildren().add(button2);
        ResultPage = new Scene(layout_Result_Page, 1980, 1080);

        //Button 4, appears on the SearchPage, and clicks it bring user back to the Start page
        Button button4 = new Button("Go back to Start page!");
        button4.setOnAction(e -> window.setScene(StartPage));

        //Add button 4 to StartPage
        layout_Search_Page.getChildren().add(button4);
        SearchPage = new Scene(layout_Search_Page, 1980, 1080);

        window.setScene(StartPage);//let the default screen be the start-page
        window.setTitle("RecipeZ");//Set the window's title to RecipeZ\
        window.show();//display the whole thing
    }
}
