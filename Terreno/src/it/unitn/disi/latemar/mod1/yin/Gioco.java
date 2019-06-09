/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.latemar.mod1.yin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author michele.yin
 */
public class Gioco extends Application {
    Griglia griglia;
    ValueBox conta;
    HBox bottom;
    BottoneInizia inizia;
    BottoneAggiungiAuto bottoneAggiungiAuto;
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        //matrice
        griglia = new Griglia(Commons.GRIGLIASIZE,this);
        root.setCenter(griglia);
    //    root.getChildren().add(griglia);
        //bottom
        bottom = new HBox();
        bottoneAggiungiAuto = new BottoneAggiungiAuto(Commons.LABELAGGIUNGIAUTO);
        conta = new ValueBox(Commons.INITIALCOUNT,this);
        inizia = new BottoneInizia(Commons.LABELINIZIA,griglia);
        bottom.getChildren().addAll(conta,inizia,bottoneAggiungiAuto);
        
        root.setBottom(bottom);
        Scene scene = new Scene(root, Commons.GAMEWIDTH, Commons.GAMEHEIGHT);
        
        primaryStage.setTitle("Hello World!");
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
