/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giocodel9;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

/**
 * classe che rappresenta le singole entità di celle 
 * @author micky
 */
public class Casella extends Button{
    private int k;
    private Griglia celle;
    private int i;
    private int j;
    /**Listener per la casella**/
    private class Listener implements EventHandler{
        Casella cella;
        public Listener (Casella cella){
            this.cella=cella;
        }
        @Override
        public void handle(Event event) {
            celle.move(cella);
        }
    }
    /**costruisce una casella numerata col dato intero**/
    public Casella(int k,Griglia celle){
        super(Integer.toString(k));
        this.k=k;
        this.setMaxSize(Commons.CELLSIZE, Commons.CELLSIZE);
        this.celle=celle;
        this.setOnAction(new Listener(this));
    }
    public int getNumber(){
        return this.k;
    }
    public void setPosition(int i, int j){
        this.i=i;
        this.j=j;
    }
    public int getPositionX(){
        return this.i;
    }
    
    public int getPositionY(){
        return this.j;
    }
}
