/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g2019;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author micky
 */
public class G2019 extends Application {
    private Griglia griglia;
    private int n;
    Button reset;
    Button cheat;
    Contatore punteggio;
    Contatore partiteVinte;
    
    //private Testo
    public G2019 (){       
        //partite vinte viene portato da un game all'altro dunque non viene inializzato nello start
        partiteVinte = new Contatore(Commons.PARTITEVINTE);
        Integer numero = null;
        boolean invalid=true;
        do{
            try{
                numero = Integer.parseInt(InputDialog.getResponse());
                invalid=false;
            }catch(NumberFormatException ex){
                
            }
        }while(numero < 3 || numero > 9 && invalid);
        n=numero;
    }
    @Override
    public void start(Stage primaryStage) {
        //gli oggetti sono dichiarati all'interno di start in maniera che sia più semplice ripristinarli quando non servono più
        HBox testo;
        HBox bottoni;
        BorderPane borderpane;
        
        //top
        punteggio = new Punteggio(Commons.PUNTEGGIO);
        testo=new HBox(Commons.GAMESIZE/n,punteggio,partiteVinte);
        //center
        griglia=new Griglia(n,this);
        //bottom
        reset=new Button(Commons.RESET);
        reset.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
               restart(new Stage());
               primaryStage.close();
            }
        });
        cheat=new Button(Commons.CHEAT);
        cheat.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
               Alert finestraCheat = new Alert(AlertType.INFORMATION);
               finestraCheat.setWidth(Commons.GAMESIZE/4);
               finestraCheat.setWidth(Commons.GAMESIZE/4);
               finestraCheat.setTitle(Commons.CHEAT);
               finestraCheat.setHeaderText(Commons.CHEAT);
               finestraCheat.setContentText(griglia.toString());
               finestraCheat.showAndWait();
            }
        });
        bottoni=new HBox(reset,cheat);
        //layout di gioco
        borderpane=new BorderPane();
        borderpane.setTop(testo); 
        borderpane.setCenter(griglia);
        borderpane.setBottom(bottoni);
        griglia.setAlignment(Pos.CENTER);
        testo.setAlignment(Pos.CENTER);
        bottoni.setAlignment(Pos.CENTER);
        Scene scene = new Scene(borderpane, Commons.GAMESIZE+Commons.GAMESIZE/n, Commons.GAMESIZE + Commons.GAMESIZE/n);
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
    /**
     * metodo che ripristina il gioco. Viene chiamato dal pulsante reset e quando c'è una vittoria
     */
    public void restart(Stage stage){
        this.start(stage);
    }
}
