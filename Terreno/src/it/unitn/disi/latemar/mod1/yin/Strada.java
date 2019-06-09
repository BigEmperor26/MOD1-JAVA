/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.latemar.mod1.yin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * classe strada
 * @author michele.yin
 */
public class Strada extends Terreno{
    /**
     * event handler che implementa il metodo per aggiungere una auto alla strada
     */
    private class HandlerAddAuto implements EventHandler{
        private Strada strada;
        public HandlerAddAuto(Strada strada){
            this.strada=strada;
        }
        @Override
        public void handle(Event event) {
            if(strada.gioco.bottoneAggiungiAuto.getActive()){
                if(!strada.hasAuto()){
                    strada.addAuto(new Auto());
                    strada.gioco.bottoneAggiungiAuto.setActive(false);
                    int t = strada.gioco.conta.getConta();
                    System.out.println(t);
                    strada.gioco.conta.setConta(t-1);
                }
            }
        }
    }
    /**
     * costruttore di strada
     * @param gioco riferimento al gioco
     */
    public Strada(Gioco gioco){
        super(gioco);
        cella.setFill(Color.GRAY);
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new HandlerAddAuto(this));
    }

    /**
     * funzione che descrive se una strada ha una auto
     * @return true se la strada corrente ha una Auto, false altrimenti
     */
    public boolean hasAuto(){
        for(Node e:this.getChildren()){
            if(e instanceof Auto){
                return true;
            }
        }
        return false;
    }
    /**
     * funzione che aggiunge una auto al pane
     * @param e auto da aggiungere
     */
    public void addAuto(Auto e){
        this.getChildren().add(e);
    }
    /**
     * funzione che rimove la specificata auto dal pane
     * @param e auto da rimuovere
     */
    public void removeAuto(Auto e){
        this.getChildren().remove(e);
    }    
    /**
     * funzione che ritorna l'auto contenuta nella strada
     * @return true se la strada corrente ha una Auto, false altrimenti
     */
    public Auto getAuto(){
        for(Node e:this.getChildren()){
            if(e instanceof Auto){
                return (Auto)e;
            }
        }
        return null;
    }
    /**
     * funzione che ritorna se vi sono più macchine nella stessa strada
     * @return true se c'è stata una collisione. false altrimenti
     */
    public boolean collisionDetected(){
        int count = 0;
        for(Node e:this.getChildren()){
            if(e instanceof Auto){
                count++;
            }
        }
        return count>1;
    }
}
