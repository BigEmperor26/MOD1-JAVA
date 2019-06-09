/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.latemar.MOD1.ronchetti.yin;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

/**
 * classe che gestisce le due griglie di gioco
 * @author micky
 */
public abstract class Griglia extends GridPane{
    public Griglia(int row, int column){
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                this.add(new Cella(),i,j);
            }
        }
        this.setGridLinesVisible(true);
    }
    
    /**
     * ottengo l'elemnto in posizione i e j
     * @param i riga
     * @param j colonna
     * @return 
     */
    public Node getItemAt(int i, int j){
        for(Node e: this.getChildren()){
            try{
                if(GridPane.getColumnIndex(e)==j && GridPane.getRowIndex(e)==i){
                    return e;
                }
            }catch(NullPointerException ex){
            
            }
        }
        return null;
    }
}
