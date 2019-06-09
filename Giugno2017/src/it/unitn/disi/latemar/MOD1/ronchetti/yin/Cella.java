/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.latemar.MOD1.ronchetti.yin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * classe che gestice la cella contenente il cerchio
 * @author micky
 */
public class Cella extends StackPane{
    private Circle punto;
    public Cella() {
        Rectangle sfondo = new Rectangle(Commons.CELLSIZE,Commons.CELLSIZE);
        sfondo.setFill(Color.AZURE);
        sfondo.setStroke(Color.BLACK);
        this.getChildren().add(sfondo);
        punto=null;
    }

    public Circle getPunto() {
        return punto;
    }
    /**
     * aggiunge il cerchio alla cella.  Nel caso rimuove il cerchio precedente
     * @param punto 
     */
    public void addPunto(Circle punto) {
        this.getChildren().remove(this.punto);
        this.punto = punto;
        this.getChildren().add(punto);
    }
    /**
     * rimuove il cerchio dalla cella.
     */
    public void removePunto() {
        this.getChildren().remove(this.punto);
        this.punto = null;
    }
    /**
     * ritorna true se la cella ha un punto
     * @return 
     */
    public boolean hasPunto(){
        return this.punto!=null;
    }
    /**
     * aggiunge un punto in maniera casuale o lo elimina.
     */
    public void randomShuffle() {
        int tmp = Commons.rand.nextInt(2);
        System.out.println(tmp);
        if(tmp==0){
            this.removePunto();
        }else{
            Circle cerchio = new Circle(Commons.CELLSIZE/2);
            this.addPunto(cerchio);
        }
    }
}
