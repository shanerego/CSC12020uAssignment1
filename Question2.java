//Kizito Okoye and shane rego
package sample;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.*;


public class Question2 extends Application {
    private TextField tfInvestmentAmount = new TextField();
    private TextField tfYears = new TextField();
    private TextField tfAnnualInterestRate = new TextField();
    private TextField tfFutureValue = new TextField();
    private Button btCalculate = new Button("Calculate");
    DropShadow shadow = new DropShadow();


    @Override
    public void start(Stage primaryStage) {
        
        //Intialisation and detailed orientation of the Pane
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(25, 25, 25,25));
        gridPane.setAlignment(Pos.CENTER);
        
        //Intitialisation of the scene
        Scene scene = new Scene(gridPane, 600, 450);
        primaryStage.setTitle("Question 2: Investment-Value calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //Creating Labels and Positioning of the already TextFields and Buttons 
        //Investment Amount
        gridPane.add(new Label("Investment Amount "), 0, 0);
        gridPane.add(tfInvestmentAmount, 1, 0);
        tfInvestmentAmount.setAlignment(Pos.BOTTOM_RIGHT);  
        //Years
        gridPane.add(new Label("Years "), 0, 1);
        gridPane.add(tfYears, 1, 1);
        tfYears.setAlignment(Pos.BOTTOM_RIGHT);   
        //Annual Interest Rate
        gridPane.add(new Label("Annual Interest Rate "), 0, 2);
        gridPane.add(tfAnnualInterestRate, 1, 2);
        tfAnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);   
        //Future value
        gridPane.add(new Label("Future value "), 0, 3);
        gridPane.add(tfFutureValue, 1, 3);
        tfFutureValue.setAlignment(Pos.BOTTOM_RIGHT);
        tfFutureValue.setEditable(false); //hence you can't enter your own value
        //Calculate
        gridPane.add(btCalculate, 1, 4);
        GridPane.setHalignment(btCalculate, HPos.RIGHT);

        // Process events
        btCalculate.setOnAction(e -> calculateInvestmentValue());
        
        /*Above and beyond for extra marks if possible*/
        btCalculate.setStyle("-fx-base: #778899;");
        btCalculate.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        btCalculate.setEffect(shadow);
                    }
                });
        btCalculate.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        btCalculate.setEffect(null);
                    }
                });


    }
    //function that does the calculation for the Investment value
    private void calculateInvestmentValue() {

        double investmentAmount = Double.parseDouble(tfInvestmentAmount.getText());
        int years = Integer.parseInt(tfYears.getText());
        double annualInterestRate = Double.parseDouble(tfAnnualInterestRate.getText());
        double futureValue = investmentAmount * Math.pow((1 + (annualInterestRate / 1200)), (years * 12));
        tfFutureValue.setText(String.format("$%.2f", futureValue));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
