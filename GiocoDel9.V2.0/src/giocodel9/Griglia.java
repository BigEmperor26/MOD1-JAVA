/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giocodel9;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Classe che gestisce la griglia di 3x3
 * @author micky
 */
public class Griglia extends GridPane{
    ArrayList<Casella> caselle;
    White white;
    public Node getElementAt(int i, int j){
        for(Node e : this.getChildren()){
            if((GridPane.getRowIndex(e)==i) && (GridPane.getColumnIndex(e)==j)){
                return e;
            }
        }
        return null;
    }
    public Casella getElement(int k){
        for(Casella e:caselle){
            if(e.getNumber()==k){
                return e;
            }
        }
        return null;
    }
    /**sposto della cella  dal gridpane
     *
     * @param moved cella spostata
     **/
    public void move(Casella moved){
        if(isNearWhite(moved)){
            int movedx = moved.getPositionX();
            int movedj = moved.getPositionY();
            int whitex = white.getPositionX();
            int whitej = white.getPositionY();
            this.getChildren().remove(moved);
            this.getChildren().remove(white);
            white.setPosition(movedx, movedj);
            moved.setPosition(whitex, whitej);
            this.add(white, movedx, movedj);
            this.add(moved, whitex, whitej);
        }
    }
    private boolean isNearWhite(Casella look){
        int distance =Math.abs(look.getPositionX() - white.getPositionX() + look.getPositionY() - white.getPositionY());
        return distance==1;
    }
    /** costruttore di una griglia di dimensioni NUMCOLS e NUMROWS**/
    public Griglia(){
        super();
        this.setGridLinesVisible(true);
        for (int i = 0; i < Commons.NUMCOLS; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / Commons.NUMCOLS);
            this.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < Commons.NUMROWS; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / Commons.NUMROWS);
            this.getRowConstraints().add(rowConst);         
        }
        caselle = new ArrayList<Casella>();
        for(int i=0;i<Commons.NUMBER-1;i++){
            caselle.add(new Casella(i,this));
        }
        white= new White();
        int h=0;
        for(int i=0;i<Commons.NUMROWS;i++){
            for(int j=0;j<Commons.NUMCOLS;j++){
                if(i==2&&j==2){
                    white.setPosition(i,j);
                    this.add(white,j,i);
                }else{
                    caselle.get(h).setPosition(j,i);
                    this.add(caselle.get(h),j,i);
                    h++;
                }
            }
        }
    }
}
