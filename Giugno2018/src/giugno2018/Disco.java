/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giugno2018;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * classe che implementa il disco che viene inserito sul palo
 *
 * @author micky
 */
public class Disco extends Rectangle {

    private int size;

    /**
     * costruisco un disco di colore casuale e dimensione size
     *
     * @param size intero che specifica la dimensione del disco
     */
    public Disco(int size) {
        super(size * Commons.PALOWIDTH, Commons.DISCOHEIGHT);
        this.size = size;
        this.setFill(Color.color(Commons.rand.nextFloat(), Commons.rand.nextFloat(), Commons.rand.nextFloat()));
    }

    /**
     * ritorna la dimensione del disco
     */
    public int getSize() {
        return this.size;
    }
}
