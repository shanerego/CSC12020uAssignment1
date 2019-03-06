//Shane Rego 100623789 and Kizito Okoye 100611918

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import java.util.Random;

public class Question1 extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        
        //Initialization of GridPane
        GridPane pane = new GridPane();
        Random rand = new Random();
        
        //assigning variables for generating the random numbers
        int img_no = rand.nextInt(54) + 1;
        int img_no1 = rand.nextInt(54) + 1;
        int img_no2 = rand.nextInt(54) + 1;
        
        //Positioning and orientation of nodes in Pane
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5);
        pane.setVgap(5);
        
        //Pulling image and adding them to there respective positions
        ImageView imageView1 = new ImageView(img_no+".png");
        pane.add(imageView1, 0, 0);
        ImageView imageView2 = new ImageView(img_no1+".png");
        pane.add(imageView2, 1, 0);
        ImageView imageView3 = new ImageView(img_no2+".png");
        pane.add(imageView3, 2, 0);

        //Initialization of Scene
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Question 1: Displaying Three Cards"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }


    public static void main(String[] args) {
        launch(args);
    }
}
