/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package febbraio2019;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author micky
 */
public class Febbraio2019 extends Application {
    private Pannello persone;
    private Pannello automobili;
    private HBox root;
    public Febbraio2019 (){
        persone = new PannelloPersone(Commons.ORDINAANNO,Commons.NUOVAPERSONA,Commons.NOME,Commons.COGNOME,Commons.ANNODINASCITA);
        automobili = new PannelloAutomobili(Commons.ORDINAPREZZO,Commons.NUOVAAUTOMOBILE,Commons.MARCA,Commons.MODELLO,Commons.PREZZO);
    }
    @Override
    public void start(Stage primaryStage) {
        root = new HBox();
        root.getChildren().addAll(persone,automobili);
        //root.setSpacing(Commons.SPACING);
        Scene scene = new Scene(root, Commons.SIZE,Commons.SIZE);
        
        primaryStage.setTitle(Commons.TITOLO);
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
