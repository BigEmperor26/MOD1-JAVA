/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g2019;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * classe che gestice il contatore di partite vinte
 * @author micky
 */
public class Contatore extends HBox{
    protected int conta;
    protected Text label;
    protected Text displayConta;
    public Contatore(String label){
        super();
        this.label=new Text(label);
        conta=0;
        displayConta=new Text(Integer.toString(conta));
        this.getChildren().addAll(this.label,displayConta);
    }
 
    /**
     * aggiunge n al contatore
     * @param n numero da aggiungere
     */
    public void add(int n){
        conta+=n;
        displayConta.setText(Integer.toString(conta));
    }
    /**
     * sottrae n al contatore
     * @param n numero da sottrarre
     */
    public void sub(int n){
        conta-=n;
        if(conta<0) { conta=0;}
        displayConta.setText(Integer.toString(conta));
    }
    /**
     * 
     * @return il valore corrente di conta 
     */
    public int getConta() {
        return conta;
    }
    /**
     * modifica il valore corrente di Conta
     */
    public void setConta(int conta) {
        this.conta=conta;
    }
}
