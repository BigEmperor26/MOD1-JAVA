/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package febbraio2019;

import java.util.*;

/**
 * classe che gestisce l'insieme, Persona o Automobile
 * @author micky
 */
public class SetRecord {
    private ArrayList<Record> insieme;
    /**
     * costruttore
     */
    public SetRecord(){
        insieme = new ArrayList<>();
    }
    /**
     * aggiunge e all'insieme
     * @param e
     * @return 
     */
    public boolean add(Record e){
        if(!insieme.contains(e)){
            insieme.add(e);
            return true;
        }else{
            return false;
        }
    }
    /**
     * converte l'insieme in stringa
     * @return 
     */
    public String toString(){
        String tmp="";
        for(Record e: insieme){
            tmp+=e;
        }
        return tmp;
    }
    /**
     * ritorna la dimensione dell'insieme
     * @return 
     */
    public int count(){
        return insieme.size();
    }
    /**
     * mescola l'insieme
     */
    public void mescola(){
        Collections.shuffle(insieme);
    }
    /**
     * ordina secondo il secondo campo
     */
    public void ordinaField2(){
        insieme.sort(new CompareRecordField2());
    }
    
    /**
     * ordina secondo il terzo campo
     */
    public void ordinaField3(){
        insieme.sort(new CompareRecordField3());
    }
}
