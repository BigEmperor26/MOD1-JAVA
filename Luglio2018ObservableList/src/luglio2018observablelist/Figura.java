/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luglio2018observablelist;

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
    private int n;
    /**
     * costruttore
     * @param n numero di vertici. 0 cerchio, 3 triangolo, 6 esagono
     */
    public Figura(int n){
        super();
        this.n=n;
        this.setMaxSize(Commons.CELLSIZE, Commons.CELLSIZE);
        this.setMinSize(Commons.CELLSIZE, Commons.CELLSIZE);
        Shape disegno = null;
        if(n==0){ disegno = new Circle(Commons.CELLSIZE/2);}
        if(n==3){ disegno = new Polygon(); ((Polygon)disegno).getPoints().addAll(gen_points(3,Commons.CELLSIZE));}
        if(n==6){ disegno = new Polygon(); ((Polygon)disegno).getPoints().addAll(gen_points(6,Commons.CELLSIZE));}
        disegno.setFill(Color.YELLOW);
        disegno.setStroke(Color.RED);
        this.getChildren().add(disegno);
    }
    public Double[] gen_points(int n, int dim){
        Double punti[] = new Double[2*n];
        double x_in = dim/2;
        double y_in = 0;
        double r = dim/2.0;
        punti[0] = x_in;
        punti[1]=y_in;
        double angle = 2*Math.PI/n;
        double curr_angle=0;
        for(int i=2;i<2*n;i+=2){
            curr_angle+=angle;
            punti[i] = x_in + (r*Math.sin(curr_angle));
            punti[i+1] = y_in + (r-r*Math.cos(curr_angle));
        }
        return punti;
    }
    
    /**
     * ritorna il numero di vertici. 
     * @return 0 cerchio, 3 triangolo, 6 esagono
     */
    public int getN(){
        return n;
    }
   
    @Override
    public String toString(){
        switch(n){
            case 0 : return "Circle";
            case 3 : return "Triangle";
            case 6 : return "Hexagon";
        }
        return "";
    }
}
