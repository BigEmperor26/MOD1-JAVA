/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settembre2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

/**
 * classe astratta che gestisce gli insiemi di carte, mano e set. 
 * @author micky
 */
public abstract class InsiemeDiCarte extends FlowPane{
    protected ArrayList<Carta> set;
    public InsiemeDiCarte () {
        super();
        this.set = new ArrayList<>();
    }
    /**
     * metodo toString
     * @return stringa
     */
    @Override
    public String toString(){
        String t="";
        for(Carta e : set){
            t+=e + " ";
        }
        return t;
    }
    /**
     * metodo che mescola il set
     */
    public void mescola(){
        Collections.shuffle(this.set);
    }
    /**
     * metodo che ordina il set
     */
    public void ordina(){
        Collections.sort(this.set);
    }
    /**
     * metodo che aggiunge la carta e dall'insieme corrente
     * @param e carta da aggiungere
     */
    public void add(Carta e){
        set.add(e);
        ridisegna();
    }
    /**
     * metodo che rimuove la carta e dall'insieme corrente
     * @param e carta da rimuovere se presente
     */
    public void remove(Carta e){
        int index=-1;
        for(int i=0;i<set.size();i++){
            Carta f = set.get(i);
            if(e==f){
                index=i;
            }
        }
        if(index!=-1){ set.remove(index); }
        ridisegna();
    }
    /**
     * metodo che pesca una carta casualmente. Ovvero la rimuove dall'insieme di carte corrente e la aggiunge all'insieme di destinazione.
     * L'insieme di destinazione viene ordinato
     * @param destinazione insieme dove inserire le carte
     * */
    public void pesca(InsiemeDiCarte destinazione){
        if(set.size()!=0){
            Carta e = set.get(Commons.rand.nextInt(set.size()));
            destinazione.add(e);
            this.remove(e);
        }
        destinazione.ordina();
        destinazione.ridisegna();
    }
    /**
     * Rimuove dal set tutte coppie di carte che giudica "equals"
     * 
     * @return true almeno la coppia è stata rimossa. false altrimenti
     */
    public boolean removeCoppie(){
        boolean removed = false;
        for(int i = 0; i<set.size();i++){
            removed = removed || removeCoppia();
        }
        return removed;
    }
    /**
     * rimuove la prima coppia
     * @return true se è stata rimossa 
     */
    private boolean removeCoppia(){
        if(set.size()<2) return false;
        boolean flag = false;
        for (int i=0;i<set.size();i++) {
            Carta e = set.get(i);
            for(int j=i+1;j<set.size();j++){
                Carta f = set.get(j);
                if( e.equals(f) ){
                    this.remove(e); this.remove(f);
                    flag = true;
                } 
            }
        }
        return flag;
    }
    /**
     * metodo che ridisegna la componente grafica dell'insieme di carte
     */
    public void ridisegna(){
        this.getChildren().clear();
        for(Carta e : set){
            this.getChildren().add(new CartaGrafica(e));
        }
    }
}
