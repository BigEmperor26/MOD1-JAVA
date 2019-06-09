/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senzadata3;

import java.util.Random;

/**
 * classe che gestisce alcune cose in comune dell'interfaccia
 * @author micky
 */
public class Commons {
    /**
     * generatore di numeri casuale
     */
    public final static Random rand = new Random(System.currentTimeMillis());
    /**
     * dimensione della finestra
     */
    public final static int SIZE = 800;
    /**
     * dimensione dello spazio di disegno
     */
    public final static int CANVASSIZE = 600;
}
