/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senzadata3;

import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * classe che implementa la superficie di disegno
 * @author micky
 */
public class Tavola extends Pane{
    ArrayList <Node> listaNodi;
    /**
     * crea una tavola bianca su cui disegnare
     * @param x width
     * @param y height
     */
    public Tavola(int x, int y){
        super();
        Rectangle sfondo = new Rectangle(x,y);
        sfondo.setFill(Color.WHITE);
        listaNodi = new ArrayList<>();
        this.getChildren().add(sfondo);
    }
    /**
     * aggiunge il nodo e alla tavola in posizione x,y. Non è centrato, il centramento viene gestito dal chiamante
     * @param e nodo da aggiungere
     * @param x posizione x
     * @param y posizione y
     */
    public void add(Node e,double x, double y){
        this.listaNodi.add(e);
        this.getChildren().add(e);
        e.setTranslateX(x);
        e.setTranslateY(y);
    }
    /**
     * rimuove tutti gli elementi dalla tavola eccetto lo sfondo
     */
    public void clear(){
        this.listaNodi.clear();
        this.getChildren().clear();
        Rectangle sfondo = new Rectangle(Integer.MAX_VALUE,Integer.MAX_VALUE);
        sfondo.setFill(Color.WHITE);
        this.getChildren().add(sfondo);
    }
    /**
     * ritorna il nodo il cui centro più vicino a date coordinate
     * @param x coordinata x
     * @param y coordinata y
     * @return nodo più vicino
     */
    public Node nearest(double x, double y){
        if(listaNodi.size()==0) return null;
        Node best = listaNodi.get(0);
        for( Node e : listaNodi){
            if(e instanceof Shape){
                if( Math.abs(e.getTranslateX()-x)<Math.abs(best.getTranslateX()-x) && Math.abs(e.getTranslateY()-y)<Math.abs(best.getTranslateY()-y) ){
                    best=e;
                }
            }
        }
        return best;
    }
    
}
