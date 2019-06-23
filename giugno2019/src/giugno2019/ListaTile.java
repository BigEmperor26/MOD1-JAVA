/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giugno2019;

import java.util.ArrayList;
import javafx.scene.layout.VBox;

/**
 * classe che gestisce l'insieme delle Tile
 * @author micky
 */
public abstract class ListaTile extends VBox {
    /**
     * insieme delle tile contenute
     */
    protected ArrayList <Tile> lista;
    public ListaTile(){
        lista = new ArrayList<>();
        this.disegna();
    }
    /**\
     * metodo che si occupa di disegnare la lista di carte
     */
    protected void disegna(){
        this.getChildren().clear();
        for(Tile e : lista) {
            this.getChildren().add(e);
        }
    }
    /**
     * interfaccia per l'aggiunta di elementi nell'insieme
     */
    public abstract void add(Tile e);
    /**
     * metodo che ritorna la dimensione della lista
     * @return 
     */
    public int getSize(){
        return this.lista.size();
    }
}
