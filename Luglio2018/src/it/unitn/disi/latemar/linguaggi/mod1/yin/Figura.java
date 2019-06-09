/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.latemar.linguaggi.mod1.yin;

import java.util.Comparator;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

/**
 * classe che implementa la figura 
 * @author micky
 */
public class Figura extends StackPane{
    private Shape figura;
    private int indice;
    public Figura(int a){
        indice = a;
        switch(a){
            case 0 : figura = new Circle(Commons.CELLSIZE/2);break;
            case 1 : figura = new Polygon();((Polygon)figura).getPoints().addAll(new Double[]{Commons.CELLSIZE/2,0.0 ,0.0,Commons.CELLSIZE,Commons.CELLSIZE,Commons.CELLSIZE}); break;
            case 2 : figura = new Polygon();((Polygon)figura).getPoints().addAll(new Double[]{Commons.CELLSIZE/(2*Math.sqrt(3)),0.0 ,Commons.CELLSIZE*(1-1/(2*Math.sqrt(3))),0.0,Commons.CELLSIZE,Commons.CELLSIZE/2,Commons.CELLSIZE*(1-1/(2*Math.sqrt(3))),Commons.CELLSIZE,Commons.CELLSIZE/(2*Math.sqrt(3)),Commons.CELLSIZE,0.0,Commons.CELLSIZE/2}); break;
        }
        figura.setFill(Color.YELLOW);
        figura.setStroke(Color.RED);
        this.getChildren().add(figura);
    }
    public int getIndice(){
        return indice;
    }
    /**
     * copia della figura
     * @return ritorna la copia della figura
     */
    public Figura clone(){
        Figura copia;
        switch(this.getIndice()){
            case 0 : copia = new Figura(0);break;
            case 1 : copia = new Figura(1);break;
            case 2 : copia = new Figura(2);break;
            default : copia = new Figura(0); break;
        }       
        return copia;
    }

    @Override
    public String toString(){
        switch(this.getIndice()){
            case 0 : return "Circle";
            case 1 : return "Triangle";
            case 2 : return "Hexagon";
            default : return "null";
        } 
    }
    /*
    @Override
    public int compareTo(Object o) {
        if( this.getIndice() < ((Figura)o).getIndice()){
            return -1;
        }
        if( this.getIndice() > ((Figura)o).getIndice()){
            return 1;
        }
        return 0;
    }*/
}
