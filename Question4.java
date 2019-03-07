package sample;


import java.awt.Graphics;
import com.sun.marlin.stats.Histogram;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



public class Question4 extends Application {
    private TextArea ta = new TextArea();
    private Histogram histogram = new Histogram("");
    private Button btShowHistogram = new Button("Show Histogram");

    DropShadow shadow = new DropShadow();




    @Override
    public void start(Stage primaryStage) throws Exception{
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);

        //Connect each alphabet on the xAxis to the count in order to get the height of the bars(i.e yAxis)
        //Loop the through incrementally
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data());


        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 500, 275);
        borderPane.getChildren().addAll();


        primaryStage.setTitle("Question 4: Histogram");
        primaryStage.setScene(scene);
        primaryStage.show();


        //Hbox for buttons and textarea
        HBox hbox = new HBox();
        hbox.setSpacing(1);
        hbox.getChildren().addAll(ta, btShowHistogram);

        //Store text area in a scroll pane
        ScrollPane scrollPane = new ScrollPane(ta = new TextArea());
        scrollPane.setPrefSize(300, 200);
        ta.setWrapText(true);

        //Place scroll pane and button in the scene
        //Border pane to put the histogram
        borderPane.setCenter(scrollPane);
        borderPane.setBottom(hbox);



        //Register action handler for buttons
        btShowHistogram.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                //counts the number of letters in the area
                int[] count = countLetter();
                //set the letter count to
                histogram.showHistogram(count);
            }
        });
        btShowHistogram.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        btShowHistogram.setEffect(shadow);
                    }
                });
        btShowHistogram.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        btShowHistogram.setEffect(null);
                    }
                });



    }




    //Case insensitive occurrences counter for each letter and returns count array
    public int[] countLetter()
    {
        int[] count = new int[26];
        String text = ta.getText();


        for(int i=0; i < text.length(); i++){
            char character = text.charAt(i);
            if((character >= 'A') && (character <= 'Z')){
                count[character - 'A']++;
            }
            else if((character >= 'a') && (character <= 'z')){
                count[character - 'a']++;
            }
        }

        return count;
    }


    //Occurence of 26 letters counter
    private int[] count;


    //Sets the count and displays the histogram
    public void showHistogram(int[] count) {
        this.count = count;
        repaint();

    }




    /*Paints the histogram*/
    @Override
    protected void paintComponent(Graphics g){
        if (count == null) return;//if count is null display nothing
        super.paintComponent(g);


        //Dynamically finding the pane size and bar width and interval
        int height = getHeight;
        int width = getWidth();
        int interval = (width - 40) / count.length;
        int individualWidth = (int)(((width - 40) / 24) * 0.60);


        //Locate the maximum count and make that the highest bar in the Histogram
        int maxCount = 0;
        for (int i = 0; i < count.length; i++) {
            if(maxCount < count[i])
                maxCount = count;
        }
        int x = 30;//starting position

        //draw a horizontal base line
        g.drawLine(10, height - 45, width - 10, height - 45);
        for (int i = 0; i < count.length; i++){
            //Find the bar height
            int barHeight = (int)(((double)count[i] / (double)maxCount) * (height - 55));

            //Display a bar
            g.drawRect(x, height - 45 - barHeight, individualWidth, barHeight);
            //Display a the respective letter under the base line
            g.drawString((char)(65 + i) + "", x, height - 30);
            //Move x for displaying the next character
            x += interval;
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
