package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class Main extends Application {

    Pane pane = new Pane();

    @Override
    public void start(Stage primaryStage) throws Exception{

        //creates the cirlce
        Circle circle = new Circle(150,150,100);
        pane.getChildren().add(circle);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);

        //creates the angle, dots and the lines bewtween them
        Circle[] circleDots = new Circle[3];
        Line[] lines = new Line[3];
        Text[] angles = new Text[3];

        for (int i = 0; i < circleDots.length; i++) {
            angles[i] = new Text();
            circleDots[i] = new Circle(0,0,5); //stating point for the dots
            randomLoaction(circleDots[i], circle);

            final int indexNum = i;

            //mouse movement
            circleDots[i].setOnMouseDragged(mouseEvent -> {
                double rad = Math.atan2(mouseEvent.getY()-circle.getCenterY(),mouseEvent.getX()-circle.getCenterX());
                double x = circle.getCenterX()+circle.getRadius()*Math.cos(rad);
                double y = circle.getCenterY()+circle.getRadius()*Math.sin(rad);
                circleDots[indexNum].setCenterX(x);
                circleDots[indexNum].setCenterY(y);
                //update the new line location
                newLineLocation(lines,circleDots,angles);
            });

            //sets the colour
            circleDots[i].setFill(Color.RED);
            circleDots[i].setStroke(Color.BLACK);

        }

        for (int i = 0; i < lines.length; i++) {
            int smallCirlce = i+1;
            if(smallCirlce == lines.length){
                smallCirlce = 0;
            }
            lines[i] = new Line(circleDots[i].getCenterX(),circleDots[i].getCenterY(),circleDots[smallCirlce].getCenterX(),circleDots[smallCirlce].getCenterY());
        }

        newLineLocation(lines, circleDots,angles);
        pane.getChildren().addAll(lines);
        pane.getChildren().addAll(circleDots);
        pane.getChildren().addAll(angles);

        //Outputs the pane
        primaryStage.setScene(new Scene(pane, 300, 300));
        primaryStage.show();
    }


    //updates the new location of the line after the mouse movements by the user
    private void newLineLocation(Line[] line, Circle[] circle,Text[] angle){
        for (int i = 0; i < line.length; i++) {
            int index = i+1;
            if (index == line.length){
                index = 0;
            }
            line[i].setStartX(circle[i].getCenterX());
            line[i].setStartY(circle[i].getCenterY());
            line[i].setEndX(circle[index].getCenterX());
            line[i].setEndY(circle[index].getCenterY());
            angle[i].setX(circle[i].getCenterX()+10);
            angle[i].setY(circle[i].getCenterY()-10);
        }
        double a = lineLength(line[0]);
        double b = lineLength(line[1]);
        double c = lineLength(line[2]);
        double A = Math.toDegrees(Math.acos((a*a-b*b-c*c)/(-2*b*c)));
        double B = Math.toDegrees(Math.acos((b*b-a*a-c*c)/(-2*a*c)));
        double C = Math.toDegrees(Math.acos((c*c-b*b-a*a)/(-2*a*b)));
        angle[2].setText(String.format("%.2f",A));
        angle[0].setText(String.format("%.2f",B));
        angle[1].setText(String.format("%.2f",C));


    }

    //calculates the length of the line
    private static double lineLength(Line line){
        double startX = line.getStartX();
        double startY = line.getStartY();
        double endX = line.getEndX();
        double endY = line.getEndY();
        double lineofLenght = Math.sqrt(((startX-startY)*(startX-startY)) + ((endX-endY)*(endX-endY)));
        return lineofLenght;
    }

    //sets the points to random loaction
    private void randomLoaction(Circle circleDot, Circle circle){
        double random = Math.random()*360;
        double x = circle.getCenterX()+circle.getRadius()*Math.cos(Math.toRadians(random));
        double y = circle.getCenterY()+circle.getRadius()*Math.sin(Math.toRadians(random));
        circleDot.setCenterY(y);
        circleDot.setCenterX(x);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
