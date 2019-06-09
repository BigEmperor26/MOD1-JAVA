/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.latemar.linguaggi.mod1.yin;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * classe che gestisce la cella nera su cui le figure sono visualizzate
 * @author micky
 */
public class Cella extends StackPane{
    private Figura figura;
    public Cella(){
        super();
        Rectangle sfondo = new Rectangle();
        sfondo = new Rectangle (Commons.CELLSIZE,Commons.CELLSIZE);
        sfondo.setFill(Color.BLACK);
        sfondo.setStroke(Color.GREEN);
        this.getChildren().add(sfondo);
        figura=null;
    }
    /** 
     * metodo che sostutuisce la figura, rimuovendo lo sfondo
     * @param figu figura da inserire
     */
    public void insertDelete(Figura figu){
        figura=figu;
        this.getChildren().clear();
        this.getChildren().add(figura);
    }
    /**
     * metodo che rimuove la figura dalla cella
     */
    public void removeFigura(){
        this.getChildren().remove(figura);
        figura=null;
    }
    /** 
     * metodo che sostituisce la figura senza rimuovere lo sfondo
     * @param figu figura da inserire
     */
    public void setFigura(Figura figu){
        this.getChildren().remove(figura);
        figura=figu;
        this.getChildren().add(figura);
    }
    public boolean hasFigura(){
        return figura!=null;
    }

    public Figura getFigura() {
        return figura;
    }
    @Override
    public String toString(){
        if(figura==null){
            return "null";
        }
        return figura.toString();
    }
    /*
    @Override
    public int compareTo(Object o) {
        if(figura==null){
            return -1;
        }
        return figura.compareTo(o);
    }*/
}
