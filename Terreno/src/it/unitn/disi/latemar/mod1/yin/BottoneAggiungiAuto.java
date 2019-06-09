/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.latemar.mod1.yin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * classe del bottone AggiungiAuto
 * @author micky
 */
public class BottoneAggiungiAuto extends Button{
    private boolean hasBeenPressed;
    /**
     * event handler del bottone premuto. Se è stato premuto abilita l'aggiunta di un'auto
     */
    private class ButtonHandler implements EventHandler{
        private BottoneAggiungiAuto bottone;
        /**
         * costruttore
         * @param bottone riferimento al bottone 
         */
        public ButtonHandler(BottoneAggiungiAuto bottone){
            this.bottone=bottone;
        }
        @Override
        public void handle(Event event) {
            bottone.setActive(true);
        }
    }
    /**
     * costruttore del bottone
     * @param testo testo del bottone
     */
    public BottoneAggiungiAuto(String testo){
        super(testo);
        hasBeenPressed=false;
        this.setOnAction(new ButtonHandler(this));
    }
    /**
     * ritorna il flag se il bottone è stato premuto o meno
     * @return 
     */
    public boolean getActive(){
        return hasBeenPressed;
    }
    /**
     * setta il flag 
     * @param flag flag del bottone se è premuto o meno
 
     */
    public void setActive(boolean flag){
        hasBeenPressed=flag;
    }
}
