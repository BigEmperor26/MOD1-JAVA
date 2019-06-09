/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settembre2018;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author micky
 */
public class Settembre2018 extends Application {
    private Giocatore pluto;
    private Giocatore pippo;
    private Mazzo mazzo;
    public Settembre2018 (){
        mazzo = new Mazzo();
        System.out.println(mazzo);
        pluto = new Giocatore ( "PLUTO",mazzo);
        pippo = new Giocatore ( "PIPPO",mazzo); 
        pippo.setAvversario(pluto);
        pluto.setAvversario(pippo);
        pluto.setPescaAvversarioFlag(false);
        System.out.println(mazzo);
    }
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();   
        root.setTop(pluto);
        root.setBottom(pippo);
        //root.setCenter(mazzo); 
        Scene scene = new Scene(root, Commons.SCENEWIDTH, Commons.SCENEHEIGHT);
        primaryStage.setTitle("Gioco");
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
