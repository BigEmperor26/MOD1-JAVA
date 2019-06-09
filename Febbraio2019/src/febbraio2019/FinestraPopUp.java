/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package febbraio2019;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * classe che gestice la finestra che si apre quando viene premuto il bottone nuova automobile/persona.
 * Consiste in uno stage, con relativa scena e layout. All'interno del layout sono presenti le label e i campi di testo, oltre al bottone di inserimento
 * @author micky
 */
public abstract class FinestraPopUp extends Stage{
    protected Text label1;
    protected Text label2;
    protected  Text label3;
    protected TextField field1;
    protected TextField field2;
    protected TextField field3;
    protected HBox campo1;
    protected HBox campo2;
    protected HBox campo3;
    protected Scene scene;
    protected BorderPane layout;
    protected Button control;
    protected Pannello pannelloassociato;
    protected Stage questo;
    /**
     * costruttore
     * @param label1
     * @param label2
     * @param label3
     * @param pannello 
     */
    public FinestraPopUp(String label1,String label2, String label3, Pannello pannello){
        this.label1 = new Text(label1);
        this.label1.setWrappingWidth(Commons.SIZE/4);
        this.label2 = new Text(label2);
        this.label2.setWrappingWidth(Commons.SIZE/4);
        this.label3 = new Text(label3);
        this.label3.setWrappingWidth(Commons.SIZE/4);
        field1 = new TextField();
        field2 = new TextField();
        field3 = new TextField();
        campo1 = new HBox();
        campo2 = new HBox();
        campo3 = new HBox();
        campo1.getChildren().addAll(this.label1,field1);
        campo2.getChildren().addAll(this.label2,field2);
        campo3.getChildren().addAll(this.label3,field3);
        pannelloassociato = pannello;
        questo=this;
        control= new Button(Commons.CONTROLLA);

        layout = new BorderPane();
        layout.setCenter(new VBox(campo1,campo2,campo3));
        layout.setBottom(control);
        scene = new Scene(layout,Commons.SIZE/2,Commons.SIZE/2);
        this.setScene(scene);
    }
}
