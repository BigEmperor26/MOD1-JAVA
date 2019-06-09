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

/**
 * Classe che gestisce la griglia di 3x3
 * @author micky
 */
public class Griglia extends GridPane{
    ArrayList<Casella> caselle;
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
    /**rimozone della cella dal gridpane**/
    public void remove(Casella deleted){
        System.out.println(deleted);
        this.getChildren().remove(deleted);
        caselle.remove(deleted);
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
        for(int i=0;i<Commons.NUMBER;i++){
            caselle.add(new Casella(i,this));
        }
        int h=0;
        for(int i=0;i<Commons.NUMROWS;i++){
            for(int j=0;j<Commons.NUMCOLS;j++){
                this.add(caselle.get(h),j,i);
                h++;
            }
        }
    }
}
