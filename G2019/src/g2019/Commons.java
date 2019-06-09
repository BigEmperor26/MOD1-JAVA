package g2019;

import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * classe che gestisce alcuni parametri di gioco 
 * @author micky
 */
public class Commons {
    /**
     * dimensione della finestra di gioco
     */
    public static final int GAMESIZE = 800;

     /**
     * messaggio di sconfitta
     */
    public static final String PERSO = "Peccato, hai perso!";
     /**
     * messaggio di vittoria
     */
    public static final String VINTO = "Complimenti, hai vinto!";
    /**
     * label punteggio
     */
    public static final String PUNTEGGIO = "Punteggio";
    /**
     * label partitevinte
     */
    public static final String PARTITEVINTE = "Partite Vinte";
    /**
     * generatore di numeri casuale per il punteggio delle tessere di tipo S
     */
    public static final Random rand = new Random(System.currentTimeMillis());
    /**
     * label del bottone reset
     */
    public static final String RESET = "Reset";
    /**
     * label del bottone cheat
     */
    public static final String CHEAT = "Cheat";
}
