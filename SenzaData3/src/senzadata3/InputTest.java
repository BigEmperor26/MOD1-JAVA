/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senzadata3;


import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

/**
 * classe che gestisce l'input, usato per il numero di lati e il raggio. Il bottone Ok o la pressione del tasto enter inserisce il valore
 * @author micky
 */
public class InputTest  extends FlowPane{
    private double n;
    private TextField campo;
    private Text testo;
    private Button ok;
    public InputTest(String testo){
        n=0;
        campo=new TextField();
        this.testo=new Text(testo);
        ok=new Button("OK");
        InputTest reference=this;
        ok.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                reference.setN();
            }
        });
        campo.setOnKeyPressed(new EventHandler(){
            @Override
            public void handle(Event event) {
                if(((KeyEvent)event).getCode()==KeyCode.ENTER){
                    ok.fireEvent(new ActionEvent());
                }
            }
        });
        this.setPrefWrapLength(600/3);
        this.getChildren().addAll(this.testo,campo,ok);
    }
    /**
     * setta il numero dal campo di testo
     */
    private void setN() {
        double tmp = 0;
        try {
            tmp = Double.parseDouble(campo.getText());
        } catch (NumberFormatException ex) {
            System.out.print("Numero non valido");
        }/*finally{
            campo.clear();
        }*/
        n = tmp;
    }

    /** 
     * ritorna il valore N contenuto attualmente
     * @return 
     */
    public double getN() {
        return n;
    }
    

}
