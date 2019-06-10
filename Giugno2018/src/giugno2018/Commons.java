/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giugno2018;

import java.util.Random;

/**
 * classe che contiene un sacco di cose in comune
 *
 * @author micky
 */
public class Commons {

    /**
     * larghezza del giooo
     */
    public final static int WIDTH = 800;
    /**
     * altezza del gioco
     */
    public final static int HEIGHT = 800;
    /**
     * altezza del palo
     */
    public final static int PALOHEIGHT = 400;
    /**
     * larghezza del palo
     */
    public final static int PALOWIDTH = 50;
    /**
     * altezza del disco
     */
    public final static int DISCOHEIGHT = 20;
    /**
     * passi con cui cresce la larghezza del disco
     */
    public final static int DISCOWIDTH = 50;
    /**
     * altezza del rettangolo centrale di sfondo
     */
    public final static int HANOIHEIGHT = 600;
    /**
     * larghezza del rettangolo centrale di sfondo
     */
    public final static int HANOIWIDTH = 600;
    /**
     * altezza della finstra di comunicazioni
     */
    public final static int MESSAGEHEIGHT = 100;
    /**
     * larghezza della finestra di comunicazioni
     */
    public final static int MESSAGEWIDTH = 500;
    /**
     *
     * generatore di numeri casuale
     */
    public final static Random rand = new Random(System.currentTimeMillis());
}
