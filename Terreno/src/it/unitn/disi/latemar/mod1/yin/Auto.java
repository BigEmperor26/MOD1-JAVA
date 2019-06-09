/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.latemar.mod1.yin;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 * Classe che gestisce l'auto
 * @author micky
 */
public class Auto extends Circle{
    private static int numeroAuto=0;
    private int idAuto;
    /**
     * costruttore di una auto
     */
    public Auto(){
        super(Commons.CELLSIZE/3);
        this.idAuto=numeroAuto++;
        this.setStroke(Color.WHITE);
        this.setFill(Color.RED);
    }
    /**
     * ritorna l'id della auto
     * @return  valore di ritorno numerico crescente
     */
    public int getIdAuto() {
        return idAuto;
    }
}
