/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.latemar.linguaggi.mod1.yin;

import java.util.ArrayList;
import javafx.collections.transformation.SortedList;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

/**
 * classe che gestisce la colonna di figura a sinistra
 * @author micky
 */
public class Colonna extends VBox{
    private ArrayList<Cella> colonna;
    /**
     * costruttore di colonna
     */
    public Colonna(){
        colonna = new ArrayList<>();
        for(int i=0; i<Commons.COLONNASIZE;i++){
            Cella e = new Cella();
            colonna.add(e);
        }   
        for(int i=Commons.COLONNASIZE-1; i>=0;i--){
            Cella tmp = colonna.get(i);
            this.getChildren().add(tmp);
        }
        
    }
    /**
     * aggiunge la figura nella prima locazione libera della colonna
     * @param figura figura da aggiungere
     * @return true se la figura è stata inserita correttamente. False altriementi
     */
    public boolean insert(Figura figura){
        if(figura==null){
            return false;
        }
        for(Cella e : colonna){
            if(!((Cella)e).hasFigura()){
                ((Cella)e).setFigura(figura);
                return true;
            }
        }
        return false;
    }
    /**
     * funzione che ritorna se la colonna è vuota, ovvero non ha figure
     * @return true se la colonna non ha figure. false altrimenti
     */
    public boolean isEmpty(){
        for(Cella e : colonna){
            if(((Cella)e).hasFigura()){
                return false;
            }
        }
        return true;
    }
    /**
     * funzione che rimuove una figura dalla cima.
     * @return ritorna la figura rimossa. null se non è stato rimosso nulla
     */
    public Figura removeTop(){
        for(int i=Commons.COLONNASIZE-1; i>=0;i--){
            Cella tmp = colonna.get(i);
            if(tmp.hasFigura()){
                tmp.removeFigura();
                return tmp.getFigura();
            }
        }
        return null;
    }
    /**
     * funzione che rimuove una figura dal basso e trasla le figure correnti.  
     * @return ritorna la figura rimossa. null se non è stato rimosso nulla
     */
    public Figura removeBottom(){
        for(Cella e : colonna){
            if(e.hasFigura()){
                e.removeFigura();
                this.compact();                
                return e.getFigura();
            }
        }
        return null;
    }
    /**
     * compatta lo stack, eliminando gli spazi vuoti in basso
     */
    private void compact(){
        for(Cella e : colonna){
            if(!e.hasFigura()){
                colonna.remove(e);
                break;
            }
        }
        colonna.add(new Cella());
        this.getChildren().clear();
        for(int i=Commons.COLONNASIZE-1; i>=0;i--){
            Cella tmp = colonna.get(i);
            this.getChildren().add(tmp);
        }
    }
    @Override
    public String toString(){
        ArrayList <String> testo  = new ArrayList <>();
        String txt="";
        for(Cella e : colonna){
            if(e.hasFigura()){
                testo.add(e.toString());
            }
        }
        testo.sort(String::compareToIgnoreCase);
        for(Cella e : colonna){
            if(!e.hasFigura()){
                testo.add(0,e.toString());
            }
        }
        for(String e : testo){
            txt = txt + " "+ e;
        }
        return txt;
    }
}

