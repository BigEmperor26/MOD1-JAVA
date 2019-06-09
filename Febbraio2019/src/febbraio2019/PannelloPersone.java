/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package febbraio2019;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;

/**
 * classe che gestisce il pannello di sinistra riferito alle persone
 * @author micky
 */
public class PannelloPersone extends Pannello{
    public PannelloPersone(String ord, String nuovo, String l1, String l2, String l3) {
        super(ord, nuovo, l1, l2, l3);
        this.setRight(bottoni);
        this.setBottom(aggiungi);
        BorderPane.setAlignment(aggiungi, Pos.BOTTOM_RIGHT);
        finestra = new FinestraPopUpPersona(l1,l2,l3,this);
    }
    
}
