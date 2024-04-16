// Student name: Koichi Nakata (ID: knakata595)

package org.example.lab11_javafx_eventdrivenprogramming;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LabExercise11 extends Application {
    private TextField tfInvestmentAmount = new TextField();
    private TextField tfNumberOfYears = new TextField();
    private TextField tfAnnualInterestRate = new TextField();
    private TextField tfFutureValue = new TextField();
    private Button btCalculate = new Button("Calculate");

    @Override
    public void start(Stage stage) throws IOException {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        gridPane.add(new Label("Investment Amount:"), 0, 0);
        gridPane.add(new Label("Number of Years:"), 0, 1);
        gridPane.add(new Label("Annual Interest Rate:"), 0, 2);
        gridPane.add(new Label("Future Value:"), 0, 3);

        gridPane.add(tfInvestmentAmount, 1, 0);
        gridPane.add(tfNumberOfYears, 1, 1);
        gridPane.add(tfAnnualInterestRate, 1, 2);
        gridPane.add(tfFutureValue, 1, 3);
        gridPane.add(btCalculate, 1, 4);

        gridPane.setAlignment(Pos.CENTER);
        tfInvestmentAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
        tfAnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
        tfFutureValue.setAlignment(Pos.BOTTOM_RIGHT);
        tfFutureValue.setEditable(false);
        GridPane.setHalignment(btCalculate, HPos.RIGHT);

        // // This is the most basic way to implement event handling
        // btCalculate.setOnAction(new CalculateHandler());

        /*
        // Second way to implement event handling
        btCalculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                calculateFutureValue();
            }
        });
         */

        btCalculate.setOnAction(e -> calculateFutureValue());

        Scene scene = new Scene(gridPane, 350, 200);
        stage.setTitle("Lab Exercise 11");
        stage.setScene(scene);
        stage.show();
    }

    class CalculateHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            calculateFutureValue();
        }
    }

    private void calculateFutureValue() {
        double investmentAmount = Double.parseDouble(tfInvestmentAmount.getText());
        int year = Integer.parseInt(tfNumberOfYears.getText());
        double annualInterestRate = Double.parseDouble(tfAnnualInterestRate.getText()) / 100;
        double montlyInterestRate = annualInterestRate / 12;

        double futureValue = investmentAmount *
                Math.pow((1 + montlyInterestRate), year * 12);

        tfFutureValue.setText(String.format("$%.2f", futureValue));
    }

    public static void main(String[] args) {
        launch();
    }
}