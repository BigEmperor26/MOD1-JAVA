/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settembre2018;

import java.util.ArrayList;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 * classe che gestisce la mano di un giocatore
 * @author micky
 */
public class Mano extends InsiemeDiCarte{
    private Giocatore giocatore;
    /**
     * costruttore di mano
     */
    public Mano(Giocatore giocatore){
        super();
        this.giocatore = giocatore;
    }
    /**
     * metodo toString
     * @return 
     */
    @Override
    public String toString(){
        return giocatore+" "+super.toString();
    }
     /**
     * metodo che aggiunge la carta alla mano
     * @param e carta da aggiungere
     */
    /*@Override
    public void add(Carta e){
        super.add(e);
        checkWin();
    }
    /**
     * metodo che rimuove la carta e dalla mano
     * @param e carta da rimuovere se presente
     */
    /*public void remove(Carta e){
        super.remove(e);
        checkWin();
    }
    
    /**
     * Rimuove dal set tutte coppie di carte che giudica "equals"
     * 
     * @return true almeno la coppia è stata rimossa. false altrimenti
     */
    /*public boolean removeCoppie(){
        boolean res = super.removeCoppie();
        checkWin();
        return res;
    }*/
    
}
