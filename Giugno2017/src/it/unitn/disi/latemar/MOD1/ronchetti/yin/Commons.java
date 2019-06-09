/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.latemar.MOD1.ronchetti.yin;

import java.util.Random;

/**
 *
 * @author micky
 */
public class Commons {
    /**
     * dimensione di una singola cella 
     */
    public final static int CELLSIZE = 14;
    
    /**
     * dimensione della griglia
     */
    public final static int GRIDSIZE = 50;
    /**
     * numeri casuali
     */
    public static Random rand = new Random(System.currentTimeMillis());
    /**
     * titolo del messagio dele celle
     */
    public final static String CELLMESSAGE = "Informazioni su questa cella";
        /**
     * messagio libero
     */
    public final static String CELLLIBERO = "Libero";
        /**
     * titolo occupato
     */
    public final static String CELLOCCUPATO = "Occupato";
}
