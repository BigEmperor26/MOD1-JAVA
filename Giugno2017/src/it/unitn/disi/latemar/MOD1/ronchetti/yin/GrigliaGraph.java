/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.latemar.MOD1.ronchetti.yin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

/**
 * classe che implementa la griglia che gestisce il grafico
 * @author micky
 */
public class GrigliaGraph extends Griglia{    
    private GrigliaLineare asseX;
    /**
    * classe che implementa l'event handler della griglia graph
    * @author micky
 */
    private class CellaHandler implements EventHandler{
        private Cella cella;
        private /*static*/ Alert alert;
        public CellaHandler( Cella cella){
            this.cella=cella;
            alert =  new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(Commons.CELLMESSAGE);
        }
        /**
         * handler
         * @param event 
         */
        @Override
        public void handle(Event event) {
            if(cella.hasPunto()){
                alert.setContentText(Commons.CELLOCCUPATO);
            }else{
                alert.setContentText(Commons.CELLLIBERO);
            }
            alert.showAndWait();
        }
    }
    public GrigliaGraph(int row, int column,GrigliaLineare asseX) {
        super(row, column);
        this.addEventHandlerToEveryCell();
        this.asseX = asseX;
    }
    /**
     * aggiunge l'eventHandler a tutte le celle del pane
     */
    public void addEventHandlerToEveryCell(){
        for(Node e: this.getChildren()){
            if(e instanceof Cella){
                ((Cella)e).addEventHandler(MouseEvent.MOUSE_CLICKED, new CellaHandler( (Cella)e) );
            }
        }
    }
    /**
     * disegna la lineare
     */
    public void linear(){
        this.clearPoints();
        for(Node e : asseX.getChildren()){
            if( e instanceof Cella){
                if(((Cella)e).hasPunto()){
                    int x = GridPane.getColumnIndex(e);
                    int y=Commons.GRIDSIZE-x-1;
                    System.out.println("Posizione X "+ x+"Posizione Y "+y);
                    Cella disegno = (Cella)this.getItemAt(x,y);
                    disegno.addPunto(new Circle(Commons.CELLSIZE/2));
                }
            }
        }
    }
    /**
     * funzione che pulisce il grafico
     */
    private void clearPoints(){
        for(Node e:this.getChildren()){
            if( e instanceof Cella){
                ((Cella)e).removePunto();
            }
        }
    }
     /**
     * disegna il seno tra -1 e 1
     */
    public void sin(){
        this.clearPoints();
        for(Node e : asseX.getChildren()){
            if( e instanceof Cella){
                if(((Cella)e).hasPunto()){
                    int x = GridPane.getColumnIndex(e);
                    double xnormalizzato = (double)x*3*Math.PI/(Commons.GRIDSIZE);
                    int y = discretizza (Math.sin(xnormalizzato),-1.0,1.0,(double)Commons.GRIDSIZE);
                    Cella disegno = (Cella)this.getItemAt(y,x);
                    disegno.addPunto(new Circle(Commons.CELLSIZE/2));
                }
            }
        }
    }
    
     /**
     * disegna il coseno tra -1 e 1
     */
    public void cos(){
        this.clearPoints();
        for(Node e : asseX.getChildren()){
            if( e instanceof Cella){
                if(((Cella)e).hasPunto()){
                    int x = GridPane.getColumnIndex(e);
                    double xnormalizzato = (double)x*3*Math.PI/(Commons.GRIDSIZE);
                    int y = discretizza (Math.cos(xnormalizzato),-1.0,1.0,(double)Commons.GRIDSIZE);
                    Cella disegno = (Cella)this.getItemAt(y,x);
                    disegno.addPunto(new Circle(Commons.CELLSIZE/2));
                }
            }
        }
    }
    /**
     * normalizzazione
     */
    private int discretizza (double y, double ymin, double ymax, double nmax){
        return (int)((nmax-1)*(1-(y-ymin)/(ymax-ymin)));
    }
}
