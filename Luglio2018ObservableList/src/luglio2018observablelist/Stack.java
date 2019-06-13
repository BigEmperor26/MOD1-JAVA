/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luglio2018observablelist;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;

/**
 * classe che implementa lo stack di figure
 *
 * @author micky
 */
public class Stack extends VBox {

    /**
     * lista di figura correntemente contenute nello stack. Le figure sono
     * codificate dal numero di vertici.
     */
    private ObservableList<Integer> lista;

    public Stack() {
        this.setRotate(180);
        lista = FXCollections.observableArrayList();
        lista.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change c) {
                redraw();
            }

        });
        //aggiunta delle celle vuote
        redraw();

    }

    /**
     * metodo che ridisegna lo stack. Chiamato ad ogni modifica della lista di
     * figure
     */
    private void redraw() {
        int i = 0;
        this.getChildren().clear();
        for (Integer j : lista) {
            Cella c = new Cella();
            c.add(new Figura(j));
            if(j==3) c.setRotate(180);
            this.getChildren().add(c);
            i++;
        }
        for (int j = i; j < Commons.NUM; j++) {
            this.getChildren().add(new Cella());
        }
    }

    /**
     * metodo che aggiunge una figura di vertici i allo stack
     *
     * @param i numero di vertici
     */
    public void add(Integer i) {
        if (lista.size() < Commons.NUM) {
            lista.add(i);
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setContentText("Stack pieno");
            alert.show();
        }
    }

    /**
     * metodo che permette di rimuovere la figura in cima
     */
    public void removeTop() {
        if (lista.size() != 0) {
            int last = lista.size() - 1;
            lista.remove(last);
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setContentText("Rimozione da uno stack vuoto");
            alert.show();
        }
    }

    /**
     * metodo che permette di rimuovere la figura dal fondo
     */
    public void removeBottom() {
        if (lista.size() != 0) {
            lista.remove(0);
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setContentText("Rimozione da uno stack vuoto");
            alert.show();
        }
    }
    /**
     * ritorna la stringa con i nomi delle figure.
     * @return 
     */
    public String toString(){
        String stringa = "";
        ArrayList <String> stringhe = new ArrayList<>();
        for(Node e: this.getChildren()){
            if(e instanceof Cella){
                stringhe.add(((Cella)e).toString());
            }
        }
        for(int i = stringhe.size()-1 ; i>=0 ;i--){
            String el = stringhe.get(i);
            stringa+=el+" ";
        }
        return stringa;
    }
}
