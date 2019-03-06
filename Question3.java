package sample;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Question3 extends Application {
    double width = 600;
    double height = 600;

    private Circle[] circlePoints = new Circle[]{new Circle(0, 0, 5),
            new Circle(0, 0, 5), new Circle(0, 0, 5)};
    private Text[] text = {new Text(), new Text(), new Text()};

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        Circle circle = new Circle(width/2, height/2, 100);
        Pane paneObject = new Pane();


        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        Circle[] circlePoints = new Circle[3];
        Line[] line = new Line[3];


// Creates the handler for the first circle point
        circlePoints[0] = new Circle(0,0,5);
        setARandomLocation(circlePoints[0],circle);
        circlePoints[0].setOnMouseDragged(e ->{
            double radValue = Math.atan2(e.getY() - circle.getCenterY(), e.getX() - circle.getCenterX());
            double x = circle.getCenterX() + circle.getRadius() * Math.cos(radValue);
            double y = circle.getCenterY() + circle.getRadius() * Math.sin(radValue);
            circlePoints[0].setCenterX(x);
            circlePoints[0].setCenterY(y);
            updateTheLineLocation(line,circlePoints, text);
        });

// Creates the handler for the second circle point
        circlePoints[1] = new Circle(0,0,5);
        setARandomLocation(circlePoints[1],circle);
        circlePoints[1].setOnMouseDragged(e ->{
            double radValue = Math.atan2(e.getY() - circle.getCenterY(), e.getX() - circle.getCenterX());
            double x = circle.getCenterX() + circle.getRadius() * Math.cos(radValue);
            double y = circle.getCenterY() + circle.getRadius() * Math.sin(radValue);
            circlePoints[1].setCenterX(x);
            circlePoints[1].setCenterY(y);
            updateTheLineLocation(line,circlePoints, text);
        });


// Creates the handler for the third circle point
        circlePoints[2] = new Circle(0,0,5);
        setARandomLocation(circlePoints[2],circle);
        circlePoints[2].setOnMouseDragged(e ->{
            double radValue = Math.atan2(e.getY() - circle.getCenterY(), e.getX() - circle.getCenterX());
            double x = circle.getCenterX() + circle.getRadius() * Math.cos(radValue);
            double y = circle.getCenterY() + circle.getRadius() * Math.sin(radValue);
            circlePoints[2].setCenterX(x);
            circlePoints[2].setCenterY(y);
            updateTheLineLocation(line,circlePoints, text);
        });





        for (int i = 0; i < line.length; i++){
            int circleIndex = (i + 1 >= circlePoints.length) ? 0 : i + 1;
            line[i] = new Line(
                    circlePoints[i].getCenterX(), circlePoints[i].getCenterY(),
                    circlePoints[circleIndex].getCenterX(),
                    circlePoints[circleIndex].getCenterY()
            );
        }


//call the method to update to the new location
        updateTheLineLocation(line, circlePoints, text);
        paneObject.getChildren().addAll(line);
        paneObject.getChildren().addAll(circlePoints[0], circlePoints[1], circlePoints[2],text[0], text[1], text[2],circle);

        primaryStage.setScene(new Scene(paneObject,width,height));
        primaryStage.setTitle("Question 3");
        primaryStage.show();

    }



//method that updates the line location everytime a mouse event occurs
    private void updateTheLineLocation(Line[] line, Circle[] p, Text[] angles){
        for(int i = 0; i < line.length; i++){
            int circleIndex = (i + 1 >= p.length) ? 0 : i + 1;
            line[i].setStartX(p[i].getCenterX());
            line[i].setStartY(p[i].getCenterY());
            line[i].setEndX(p[circleIndex].getCenterX());
            line[i].setEndY(p[circleIndex].getCenterY());
            angles[i].setX(p[i].getCenterX()+2);
            angles[i].setY(p[i].getCenterX()-2);

        }

        double a = distanceCalculator(line[0]);
        double b = distanceCalculator(line[1]);
        double c = distanceCalculator(line[2]);
        double[] angle = new double[3];
        angle[0] = Math.acos((a * a - b * b - c * c) / (-2 * b * c));

        angle[1] = Math.acos((b * b - a * a - c * c) / (-2 * a * c));

        angle[2] = Math.acos((c * c - b * b - a * a) / (-2 * a * b));

        for(int i = 0; i < line.length; i++){
            text[i].setText(String.format("%.2f", Math.toDegrees(angle[i])));
        }


    }



//random location generation function
    private void setARandomLocation(Circle cPoint, Circle c){
        double angle = Math.random()*360;
        double x = c.getCenterX() + c.getRadius() * Math.cos(Math.toRadians(angle));
        double y = c.getCenterY() + c.getRadius() * Math.sin(Math.toRadians(angle));
        cPoint.setCenterX(x);
        cPoint.setCenterY(y);
    }

//calculation function that calculates distance the line to the vertex
    private static double distanceCalculator(Line line){
        double x1 = line.getStartX();
        double y1 = line.getStartY();
        double x2 = line.getEndX();
        double y2 = line.getEndY();
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }


    public static void main(String[] args) {
        launch(args);
    }
