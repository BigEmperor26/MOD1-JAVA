/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.latemar.linguaggi.mod1.yin;

import javafx.scene.control.Button;

/**
 * classe che gestisce i bottoni
 * @author micky
 */
public class Bottone extends Button {
    
    /**
     * costruisce il bottone con testo. Setta la dimensione a metà dello spazio rimanenete su schermo
     * @param testo titolo del bottone
     */
    public Bottone(String testo){
        super(testo);
        this.setWidth(Integer.MAX_VALUE);
        this.setPrefWidth((Commons.WIDTH-Commons.CELLSIZE)/2-5);
    }
}
