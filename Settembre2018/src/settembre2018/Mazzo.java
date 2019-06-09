/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settembre2018;

import java.util.ArrayList;
import java.util.Collections;

/**
 * classe che gestisce il mazzo di carte
 * @author micky
 */
public class Mazzo extends InsiemeDiCarte{

    /**
     * costruttore del mazzo. Inizializza il mazzo con un insieme casuale di carte, non ordinato
     */
    public Mazzo() {
        super();
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
               this.set.add(new Carta(i+1,Seme.values()[j]));
            }
        }
        this.set.add(new Carta(0,Seme.J));
        //this.mescola();
    }
    /**
     * metodo main di testo
     * @param args 
     */
    public static void main(String[] args) {
        Mazzo m = new Mazzo();
        m.mescola();
        System.out.println(m);
        m.ordina();
        System.out.println(m);
    }
}
