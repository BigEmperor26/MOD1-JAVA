/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.latemar.MOD1.ronchetti.yin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

/**
 * classe che implementa la griglia lineare
 * @author micky
 */
public class GrigliaLineare extends Griglia{
    /**
     * classe che implementa l'event handler della cella
     */
    private class CellaHandler implements EventHandler{
        private Cella cella;
        public CellaHandler( Cella cella){
            this.cella=cella;
        }
        /**
         * handler
         * @param event 
         */
        @Override
        public void handle(Event event) {
            if(cella.hasPunto()){
                cella.removePunto();
            }else{
                cella.addPunto(new Circle(Commons.CELLSIZE/2));
            }
        }
    }
    public GrigliaLineare(int row){
        super(row,1);
        this.addEventHandlerToEveryCell();
    } 
    /**
     * aggiunge l'eventHandler a tutte le celle del pane
     */
    public void addEventHandlerToEveryCell(){
        for(Node e: this.getChildren()){
            if(e instanceof Cella){
                ((Cella)e).addEventHandler(MouseEvent.MOUSE_CLICKED, new CellaHandler( (Cella)e) );
            }
        }
    }
    /**
     * setta casualmente se le celle del gridpane avranno o meno cerchi
     */
    public void setRandom() {
        for(Node e: this.getChildren()){
            if(e instanceof Cella){
                ((Cella)e).randomShuffle();
            }
        }
    }
    /**
     * aggiunge i cerchi a ogni elemento della griglia
     */
    public void addCircleToAll() {
        for(Node e: this.getChildren()){
            if(e instanceof Cella){
                ((Cella)e).addPunto( new Circle(Commons.CELLSIZE/2));
            }
        }
    }
    /**
     * aggiunge i cerchi a ogni elemento della griglia
     */
    public void removeCircleToAll() {
        for(Node e: this.getChildren()){
            if(e instanceof Cella){
                ((Cella)e).removePunto();
            }
        }
    }
 
    
}
