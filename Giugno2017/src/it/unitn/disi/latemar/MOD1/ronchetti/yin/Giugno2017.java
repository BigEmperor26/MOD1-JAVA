/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.latemar.MOD1.ronchetti.yin;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author micky
 */
public class Giugno2017 extends Application {
    private GrigliaGraph grigliaGrande;
    private GrigliaLineare grigliaPiccola;
    private Button linear;
    private Button sin;
    private Button cos;
    private Button random;
    private Button allOn;
    private Button allOff;
    
    public Giugno2017(){
        grigliaPiccola = new GrigliaLineare(Commons.GRIDSIZE);
        grigliaGrande = new GrigliaGraph(Commons.GRIDSIZE,Commons.GRIDSIZE,grigliaPiccola);
        random = new Button("Random");
        random.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                grigliaPiccola.setRandom();
            }
        });
        allOn = new Button("All ON");
        allOn.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                grigliaPiccola.addCircleToAll();
            }
        });
        allOff = new Button("All OFF");
        allOff.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                grigliaPiccola.removeCircleToAll();
            }
        });
        linear = new Button("Linear");
        linear.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                grigliaGrande.linear();
            }
        });
        sin = new Button("Sin");
        sin.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                grigliaGrande.sin();
            }
        });
        
        cos = new Button("Cos");
        cos.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                grigliaGrande.cos();
            }
        });
    }
    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        
        VBox grigliaPiccolaBottoni;
        HBox filaBottoni;
        filaBottoni = new HBox();
        grigliaPiccolaBottoni = new VBox();
        // set della griglia grande
        root.setCenter(grigliaGrande);
        // filaBottoni
        filaBottoni.getChildren().addAll(linear,sin,cos,random,allOn,allOff);
        // set 
        grigliaPiccolaBottoni.getChildren().addAll(grigliaPiccola,filaBottoni);
        
        root.setBottom(grigliaPiccolaBottoni);
        Scene scene = new Scene(root, 1000, 1000);
        
        primaryStage.setTitle("Plotter");
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
