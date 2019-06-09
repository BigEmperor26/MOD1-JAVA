/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settembre2018;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * classe che gestisce la singola carta
 * @author micky
 */
public class Carta implements Comparable{
    private int valore;
    private Seme seme;
    /**
     * costruttore di carta
     * @param valore valore della carta
     * @param seme seme della carta
     */
    public Carta(int valore, Seme seme) {
        super();
        this.valore = valore;
        this.seme = seme;
    }
    /**
     * metodo toString
     * @return 
     */
    @Override
    public String toString(){
        return valore+"-"+seme;
    }
    /**
     * metodo compareTo. Ordina prima per valore e successivamente per seme
     * @param o
     * @return 
     */
    @Override
    public int compareTo(Object o) {
        if( this.valore < ((Carta)o).getValore() ){ return -1;}
        if( this.valore > ((Carta)o).getValore() ){ return 1;}
        // il jolly è sempre 0, dunque così va bene
        return this.seme.compareTo(((Carta)o).getSeme());
    }

    /**
     * getter di valore
     * @return 
     */
    public int getValore() {
        return valore;
    }

    /**
     * getter di seme
     * @return 
     */
    public Seme getSeme() {
        return seme;
    }

    /** 
     * hashcode
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.valore;
        return hash;
    }

    /**
     * uguaglianza tra carte solo per stesso valore. Indipendente dal seme
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        if (this.valore != other.valore) {
            return false;
        }
        return true;
    }
    /**
     * metodo main di test
     * @param args 
     */
    public static void main(String[] args) {
        Carta m1 = new Carta(0,Seme.C);
        Carta m2 = new Carta(0,Seme.Q);
        System.out.println(m1.equals(m2));
    }
}
