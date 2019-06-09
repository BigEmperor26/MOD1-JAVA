/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.latemar.mod1.yin;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * classe che gestisce il campo col numero di auto disponibili
 * @author michele.yin
 */
public class ValueBox extends VBox{
    private TextField campo;
    private int conta;
    private Text testo;
    private Gioco gioco;
    /**
     * costruttore
     * @param k numero di macchine con cui inizia
     * @param gioco riferimento al gioco
     */
    public ValueBox(int k,Gioco gioco){
        conta=k;
        this.gioco=gioco;
        campo=new TextField(Integer.toString(conta));
        campo.setEditable(false);
        testo = new Text(Commons.LABELCOUNT);
        this.getChildren().addAll(campo,testo);
    }
    /**
     * modifica il valore corrente di conta
     * @param conta nuovo valore di conta
     */
    public void setConta(int conta){
        this.conta=conta;
        campo.setText(Integer.toString(this.conta));
        if(this.conta==0){
            gioco.bottoneAggiungiAuto.setDisable(true);
        }
    }
    /**
     * ottiene il valore corrente di conta
     * @return 
     */
    public int getConta(){
        return this.conta;
    }
}
