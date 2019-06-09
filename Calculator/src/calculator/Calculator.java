/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.text.Font;

/**
 *
 * @author michele.yin
 */
public class Calculator extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        /*
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        */
        BorderPane root = new BorderPane();
        //TITOLO
        Text text = new Text();
        text.setFont(new Font(20));
        text.setText("MiniCalculator");
        BorderPane.setAlignment(text , Pos.TOP_CENTER);
        BorderPane.setMargin(text, new Insets(12,12,12,12));
        root.setTop(text);
        //CAMPI DI TESTO/BOTTONI
        VBox vbox = new VBox();
        TextField firstInput = new  TextField();
        TextField secondInput = new  TextField();
        TextField res = new  TextField();
        //campi di bottoni appartenenti a VBOX
        TilePane buttons = new TilePane();
        Button sum = new Button("SUM");
        sum.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler(){
            public void handle(Event e){
                double first;
                double second;
                double result;
                try{    
                    first = Double.parseDouble(firstInput.getText());
                    second = Double.parseDouble(secondInput.getText());
                    result = first+second;
                    res.setText(Double.toString(result));
                }catch(NumberFormatException ex){
                    res.setText("Numeri non validi");
                }; 
               
            }
        });
        Button sub = new Button("SUB");
        sub.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler(){
            public void handle(Event e){
                double first;
                double second;
                double result;
                try{    
                    first = Double.parseDouble(firstInput.getText());
                    second = Double.parseDouble(secondInput.getText());
                    result = first-second;
                    res.setText(Double.toString(result));
                }catch(NumberFormatException ex){
                    res.setText("Numeri non validi");
                }; 
               
            }
        });
        Button mul = new Button("MUL");
         mul.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler(){
            public void handle(Event e){
                double first;
                double second;
                double result;
                try{    
                    first = Double.parseDouble(firstInput.getText());
                    second = Double.parseDouble(secondInput.getText());
                    result = first*second;
                    res.setText(Double.toString(result));
                }catch(NumberFormatException ex){
                    res.setText("Numeri non validi");
                }; 
               
            }
        });
        Button div = new Button("DIV");
        div.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler(){
            public void handle(Event e){
                double first;
                double second;
                double result;
                try{    
                    first = Double.parseDouble(firstInput.getText());
                    second = Double.parseDouble(secondInput.getText());
                    result = first/second;
                    res.setText(Double.toString(result));
                }catch(NumberFormatException ex){
                    res.setText("Numeri non validi");
                }; 
               
            }
        });

        /*
        HBox.setHgrow(sum, Priority.ALWAYS);
        HBox.setHgrow(sub, Priority.ALWAYS);
        HBox.setHgrow(mul, Priority.ALWAYS);
        HBox.setHgrow(div, Priority.ALWAYS);*/
      //  buttons.setSpacing(10);
        buttons.setPrefColumns(4);
        buttons.getChildren().addAll(sum,sub,mul,div);
        //Result
 
        vbox.getChildren().addAll(firstInput,secondInput,buttons,res);
        
        Button clear = new Button("CLEAR");
        clear.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler(){
            public void handle(Event e){
                firstInput.clear();
                secondInput.clear();
                res.clear();
            }
        });
        BorderPane.setAlignment(clear, Pos.CENTER_RIGHT);
        BorderPane.setMargin(clear, new Insets(10,10,10,10));
        root.setRight(clear);
        BorderPane.setMargin(vbox, new Insets(30,30,30,30));
        root.setCenter(vbox);
//root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
