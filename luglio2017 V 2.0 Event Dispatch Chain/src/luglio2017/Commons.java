/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luglio2017;

import java.util.Random;

/**
 * classe che contiene le cose comuni
 *
 * @author micky
 */
public class Commons {

    /**
     * Dimensione del dado
     */
    public final static int DADOSIZE = 200;
    /**
     * Dimensione dell punto sul dado
     */
    public final static int DOTSIZE = 10;

    /**
     * larghezza della applicazione
     */
    public final static int WIDTH = 1000;

    /**
     * altezza del gioco della applicazione
     */
    public final static int HEIGHT = 1000;
    /**
     * dimensione della parte interattiva del gioco
     */
    public final static int CENTERSIZE = 800;
    /**
     * generatore di numeri casuale
     */
    public final static Random ran = new Random(System.currentTimeMillis());
}
