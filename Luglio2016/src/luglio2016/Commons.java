package luglio2016;


import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author micky
 */
public class Commons {
 
    /**
     * generatore di numer casuale
     */
    public static final Random rand = new Random(System.currentTimeMillis());
    /**
     * dimensione della finestra che contiene il girone
     */
    public static final int GIRONESIZE = 400;
    /**
     * dimensione della bandiera
     * 
     */
    public static final int BANDIERASIZE = 50;
}
