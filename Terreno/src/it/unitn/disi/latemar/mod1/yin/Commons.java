/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.latemar.mod1.yin;

import java.util.Random;

/**
 *
 * @author michele.yin
 */
public class Commons {
    /**
     * dimensione della cella
     */
    public static final int CELLSIZE = 70; 
    /**
     * dimensione della griglia
     */
    public static final int GRIGLIASIZE = 8;
        /**
     * larghezza del gioco
     */
    public static final int GAMEWIDTH = 800;
        /**
     * altezza della finestra dei controller gioco
     */
    public static final int GAMEHEIGHT = 1000;
        /**
     * larghezza della finestra dei controller gioco
     */
    public static final int CONTROLLERWIDTH = 250;
        /**
     * altezza della finestra dei controller gioco
     */
    public static final int CONTROLLERHEIGHT = 250;
     /**
     * label del contatore
     */
    public static final String LABELCOUNT = "Auto Disponibili";
    /**
     * label del bottone inizia
     */
    public static final String LABELINIZIA = "Inizia";
    /**
     * label del bottone aggiungi auto
     */
    public static final String LABELAGGIUNGIAUTO = "Aggiungi Auto";
        /**
     * label del bottone  destra
     */
    public static final String LABELDESTRA = "Destra";
        /**
     * label del bottone sinistra
     */
    public static final String LABELSINISTRA = "Sinistra";
        /**
     * label del bottone su
     */
    public static final String LABELSU = "Su";
        /**
     * label del bottone giu
     */
    public static final String LABELGIU = "Giu";
        /**
     * label del bottone random
     */
    public static final String LABELRANDOM = "Random";
        /**
     * label del bottone start
     */
    public static final String LABELSTART = "Start";
            /**
     * label del bottone stop
     */
    public static final String LABELSTOP = "Stop";
    /**
     * contatore iniziale delle macchie
     */
    public static final int INITIALCOUNT = 3;
    /**
     * label della finestra di controllo
     */
    public static final String CONTROLWINDOWTITLE = "Controller per le Auto";
     /**
     * Titolo della finestra di gameover
     */
    public static final String GAMEOVERTITLE = "Game Over";
         /**
     * contenuto della finestra di gameover
     */
    public static final String GAMEOVERTEXT = "CRASH";
    /**
     * generatore di numeri casuale
     */
    public static final Random rand = new Random(System.currentTimeMillis());
}
