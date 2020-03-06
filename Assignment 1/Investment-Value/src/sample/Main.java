package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.lang.Math;
import java.time.Year;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class Main extends Application {
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    @Override
    public void start(Stage primaryStage) throws Exception{

        //setting up the gridpane
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,100,80,10));
        pane.setVgap(5);
        pane.setHgap(25);


        //Investment Amount
        pane.add(new Label("Investment Amount"),0,0);
        TextField InvestmentAmount = new TextField();
        InvestmentAmount.setPromptText("Investment Amount");
        pane.add(InvestmentAmount, 1,0);
        InvestmentAmount.getText();

        //Years
        pane.add(new Label("Years"),0,1);
        TextField Years = new TextField();
        Years.setPromptText("Number of years");
        pane.add(Years,1,1);
        Years.getText();

        //Annual Interest rate
        pane.add(new Label("Annual Interest Rate"),0,2);
        TextField AnnualInterestRate = new TextField();
        AnnualInterestRate.setPromptText("Annual Interest Rate");
        pane.add(AnnualInterestRate,1,2);
        AnnualInterestRate.getText();

        //Future investment
        pane.add(new Label("Future Investment"),0,3);
        TextField FutureInvestment = new TextField();
        pane.add(FutureInvestment,1,3);
        FutureInvestment.getText();


        //Calculate button
        Button Calculate = new Button("Calculate");
        pane.add(Calculate,1,4);
        GridPane.setHalignment(Calculate,HPos.RIGHT);

        Calculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                Double months = (Double.parseDouble(Years.getText()) * 12); //years * months = gets the total number of months
                Double montlyIntrestRate = (Double.parseDouble(AnnualInterestRate.getText()) / 12 /100); //yearlyintrest/months /100


                //calculate investment using the formula
                Double part1 = Double.parseDouble(InvestmentAmount.getText());

                Double part2 = 1 + montlyIntrestRate;
                Double part3 = Double.parseDouble(Years.getText()) * 12;
                Double part4 = (double)Math.pow(part2,part3);

                Double finalValue = part1 * part4;

                //Set to two decimals. Then save as String.
                String Stringfinalvalue = df2.format(finalValue);
                FutureInvestment.setText(Stringfinalvalue); //Output to the box

//                FutureInvestment.setText(Double.toString(finalValue));
            }
        });

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise16_5");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}