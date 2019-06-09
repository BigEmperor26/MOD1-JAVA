/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.latemar.mod1.yin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * classe del terreno 
 * @author michele.yin
 */
public abstract class Terreno extends StackPane{
    protected Rectangle cella;
    protected Gioco gioco;
    /**
     * eventhandler del click sul terreno.
     */
    protected class HandlerTerrenoSwap implements EventHandler{
        private Terreno cella;
        /**
         * costruttore del eventhandler
         * @param cella riferimento al terreno
         */
        public HandlerTerrenoSwap(Terreno cella){
            this.cella=cella;
        }
        @Override
        public void handle(Event event) {
            boolean flagStradaConAuto = false;
            if(cella instanceof Strada ){
                flagStradaConAuto = ((Strada)cella).hasAuto();
            }
            if(!gioco.bottoneAggiungiAuto.getActive()&& !flagStradaConAuto){
                gioco.griglia.switchStradaPrato(cella);
            }
                
        }
    }
    public Terreno( Gioco gioco){
        this.gioco=gioco;
        this.cella = new Rectangle(Commons.CELLSIZE,Commons.CELLSIZE);
        cella.setStroke(Color.WHITE);
        this.getChildren().addAll(cella);
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new HandlerTerrenoSwap(this));
    }
}
