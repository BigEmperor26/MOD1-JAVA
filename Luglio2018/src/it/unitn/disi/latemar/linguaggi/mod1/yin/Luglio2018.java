/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.latemar.linguaggi.mod1.yin;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * classe principale
 * @author micky
 */
public class Luglio2018 extends Application {
    private Colonna colonna;
    private HBox bottoniFigura;
    private Bottone circle;
    private Bottone triangle;
    private Bottone hexagon;
    private BorderPane root;
    private TilePane controlli;
    private Bottone add;
    private Bottone removeBottom;
    private Bottone removeTop;
    private Bottone printStack;
    private Cella figuraCentro;
    private Alert finestraComunicazioni;
    /**
     * costruttore della classe principale
     */
    public Luglio2018(){
        root = new BorderPane();
        //colonna di sinistra
        colonna = new Colonna();
        root.setLeft(colonna);
        //CENTER
        //4 tasti sopra alla figura
        controlli = new TilePane();
        controlli.setPrefColumns(2);
        controlli.setMaxWidth(Commons.WIDTH-Commons.CELLSIZE);
        add = new Bottone("Add");
        add.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                if(figuraCentro.hasFigura()){
                    if(!colonna.insert((Figura)figuraCentro.getFigura().clone())){
                        finestraComunicazioni = new Alert(AlertType.WARNING);
                        finestraComunicazioni.setTitle(Commons.COMUNICAZIONI);
                        finestraComunicazioni.setContentText(Commons.MESSAGGIOSTACKPIENO);
                        finestraComunicazioni.showAndWait();
                    }
                }
            }
        });
        removeTop = new Bottone("Remove Top");
        removeTop.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                if(colonna.isEmpty()){
                    finestraComunicazioni = new Alert(AlertType.WARNING);
                    finestraComunicazioni.setTitle(Commons.COMUNICAZIONI);
                    finestraComunicazioni.setContentText(Commons.MESSAGGIOSTACKVUOTO);
                    finestraComunicazioni.showAndWait();
                }else{
                    colonna.removeTop();
                }
            }
        });
        removeBottom = new Bottone("Remove Bottom");
        removeBottom.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                if(colonna.isEmpty()){
                    finestraComunicazioni = new Alert(AlertType.WARNING);
                    finestraComunicazioni.setTitle(Commons.COMUNICAZIONI);
                    finestraComunicazioni.setContentText(Commons.MESSAGGIOSTACKVUOTO);
                    finestraComunicazioni.showAndWait();
                }else{
                    colonna.removeBottom();
                }
            }
        });
        printStack = new Bottone("Print Stack");
        printStack.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                finestraComunicazioni = new Alert(AlertType.WARNING);
                finestraComunicazioni.setTitle(Commons.COMUNICAZIONI);
                finestraComunicazioni.setContentText(colonna.toString());
                finestraComunicazioni.showAndWait();
            }
        });
        controlli.getChildren().addAll(add,removeBottom,removeTop,printStack);
        //figura al centro
        figuraCentro = new Cella();
        //bottoni che aggiungono la figura alla colonna
        bottoniFigura = new HBox();
        bottoniFigura.setMaxWidth(Commons.WIDTH-Commons.CELLSIZE);
        circle = new Bottone("Circle");
        circle.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                figuraCentro.insertDelete(new Figura(0));
                circle.setDisable(true);
                triangle.setDisable(false);
                hexagon.setDisable(false);
            }
        }); 
        triangle = new Bottone("Triangle");
        triangle.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                figuraCentro.insertDelete(new Figura(1));
                circle.setDisable(false);
                triangle.setDisable(true);
                hexagon.setDisable(false);
            }
        });
        hexagon = new Bottone("Hexagon");
        hexagon.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                figuraCentro.insertDelete(new Figura(2));
                circle.setDisable(false);
                triangle.setDisable(false);
                hexagon.setDisable(true);
            }
        });
        bottoniFigura.getChildren().addAll(circle,triangle,hexagon);
        VBox center = new VBox();
        center.getChildren().addAll(controlli,figuraCentro,bottoniFigura);
        root.setCenter(center);
        center.setAlignment(Pos.CENTER);
        
    
    }
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(root,Commons.HEIGHT,Commons.WIDTH);
        primaryStage.setTitle(Commons.TITOLO);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
