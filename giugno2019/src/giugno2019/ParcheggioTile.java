/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giugno2019;

import java.util.Collections;
import java.util.List;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 *
 * @author micky
 */
public class ParcheggioTile extends ListaTile {

    public ParcheggioTile() {
        // un parcheggio non è altro che una lista ruotata
        this.setRotate(90);
    }

    /**
     * metodo che aggiunge la Tile e al parcheggio. Ne disattiva lo handler. Non
     * viene fatta uan verifica di equivalenza
     *
     * @param e Tile da aggiungere
     */
    @Override
    public void add(Tile e) {
        e.setRotate(270);
        Color inverted = e.getColore();
        inverted.darker();
        e.setColore(inverted);
        e.removeEventHandler(MouseEvent.MOUSE_CLICKED, e.getHandler());
        this.lista.add(e);
        this.disegna();
    }

    /**
     * metodo che aggiunge tutti gli elementi della collection i all parcheggio
     *
     * @param i
     */
    public void add(List<Tile> i) {
        for (Tile e : i) {
            this.add(e);
        }
    }

}
