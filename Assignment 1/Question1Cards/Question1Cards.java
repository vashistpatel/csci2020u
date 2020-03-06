/*
*Saenthuran 100705726
* Vashist Patel
* In order for this code to wo rk you need a folder that is named "Cards"
* only then will the code work
*
* */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Random;


public class Question1Cards extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Creates a pane
        Pane pane = new HBox(10);
        //Sets padding for the pane
        pane.setPadding(new Insets(5,5,5,5));
        //Creates a string cards that holds 3 strings
        String[] cards = {"1","2","3"};
        //Setup the random function
        Random rand = new Random();
        //Randomly generate a number between 1-52 and add it to Cards/#.png assuming you have the cards in a fodler called cards
        for(int i=0;i<3;i++){
            int a = rand.nextInt(52-1+1)+1;
            cards[i] = "Cards/" +a+".png";

        }
        //Initializes and sets the images
        Image img = new Image(cards[0]);
        Image img2 = new Image(cards[1]);
        Image img3 = new Image(cards[2]);
        ImageView imgView = new ImageView(img);
        ImageView imgView2= new ImageView(img2);
        ImageView imgView3= new ImageView(img3);
        //Adds the images to the panes
        pane.getChildren().add(imgView);
        pane.getChildren().add(imgView2);
        pane.getChildren().add(imgView3);
        //creates the scene and outputs the 3 generated images
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Card Generator");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}