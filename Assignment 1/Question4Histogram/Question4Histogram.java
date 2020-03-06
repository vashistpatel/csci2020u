import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static javafx.scene.chart.XYChart.*;

public class TRYING extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        /*java.io.File file = new java.io.File("test.txt");
       /* File file = new File(".");
        for(String fileNames : file.list()) System.out.println(fileNames);*/

        //Creating and setting up the pane
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,10,10,10));

        pane.add(new Label("Enter File: "), 0, 1);
        //Creating the Textfields
        TextField tt = new TextField("Example");
        pane.add(tt, 0, 1);
        //Creating the Buttons
        Button bt = new Button("View");
        //Setting an action on the button
        bt.setOnAction(new EventHandler<ActionEvent>() {
                           @Override
                           public void handle(ActionEvent event) {
                               //Creates string alphabet
                               String[] alpha = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
                               //String fn takes in the value inputted in the textfield
                               String fn = tt.getText();
                               //Sets up an array of 26 space
                               int[] arrayCount = new int[26];
                               //Arraycount = and calls countcHARACTERS function
                               arrayCount = countCharacters(fn);
                               //Creating the Histogram
                               //Creates Y and X Axis for bar chart
                               CategoryAxis xAxis = new CategoryAxis();
                               NumberAxis yAxis = new NumberAxis();
                               //Creates the bar chart
                               BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
                               for(int i=0;i<26;i++){
                                   System.out.println(alpha[i]);
                                   System.out.println(arrayCount[i]);
                               }
                               Series<String, Integer> s1 = new Series<String, Integer>();
                               //putting the string alphabet and array into the Histogram
                               for(int i =0;i<26;i++){
                                   s1.getData().add(new Data<>(alpha[i],arrayCount[i]));
                               }
                               //Sets space of the bargraph to turn it into a histogram
                               bc.setCategoryGap(0);
                               bc.setBarGap(0);

                               bc.setLegendVisible(false);
                               bc.getYAxis().setTickLabelsVisible(false);
                               bc.getYAxis().setOpacity(0);
                               //Adds the bar graph to the pane
                               pane.add(bc,0,0);
                           }
                       }
        );
        //Adds button to the pane, creates a new scene and displays the scene
        pane.add(bt, 0, 2);
        Scene scene = new Scene(pane,500,300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    //Counting characters function is meant to count the characters in a file
    public static int[] countCharacters(String fileName){
        File file = new File(fileName);
        int[] array1 = new int[26];
        try (Scanner input = new Scanner(file)) {
            //Checks to see if there is another word after if not it will end
            while (input.hasNext()) {
                //creating a string temp variable to take in the current word
                String temp = input.next();
                //then uppercases it all
                temp = temp.toUpperCase();
                //puts the word into a char array
                char[] charTemp = temp.toCharArray();
                int size = temp.length();
                //Checks to see how many chars, it counts and stores them.
                for (int i = 0; i < size; i++) {
                    if (charTemp[i] == 'A') {
                        array1[0] += 1;
                    } else if (charTemp[i] == 'B') {
                        array1[1] += 1;
                    } else if (charTemp[i] == 'C') {
                        array1[2] += 1;
                    } else if (charTemp[i] == 'D') {
                        array1[3] += 1;
                    } else if (charTemp[i] == 'E') {
                        array1[4] += 1;
                    } else if (charTemp[i] == 'F') {
                        array1[5] += 1;
                    } else if (charTemp[i] == 'G') {
                        array1[6] += 1;
                    } else if (charTemp[i] == 'H') {
                        array1[7] += 1;
                    } else if (charTemp[i] == 'I') {
                        array1[8] += 1;
                    } else if (charTemp[i] == 'J') {
                        array1[9] += 1;
                    } else if (charTemp[i] == 'K') {
                        array1[10] += 1;
                    } else if (charTemp[i] == 'L') {
                        array1[11] += 1;
                    } else if (charTemp[i] == 'M') {
                        array1[12] += 1;
                    } else if (charTemp[i] == 'N') {
                        array1[13] += 1;
                    } else if (charTemp[i] == 'O') {
                        array1[14] += 1;
                    } else if (charTemp[i] == 'P') {
                        array1[15] += 1;
                    } else if (charTemp[i] == 'Q') {
                        array1[16] += 1;
                    } else if (charTemp[i] == 'R') {
                        array1[17] += 1;
                    } else if (charTemp[i] == 'S') {
                        array1[18] += 1;
                    } else if (charTemp[i] == 'T') {
                        array1[19] += 1;
                    } else if (charTemp[i] == 'U') {
                        array1[20] += 1;
                    } else if (charTemp[i] == 'V') {
                        array1[21] += 1;
                    } else if (charTemp[i] == 'W') {
                        array1[22] += 1;
                    } else if (charTemp[i] == 'Y') {
                        array1[23] += 1;
                    } else if (charTemp[i] == 'X') {
                        array1[24] += 1;
                    } else if (charTemp[i] == 'Z') {
                        array1[25] += 1;
                    }
                }
            }
        }catch(FileNotFoundException e){
        }
        return array1;
    }
}
