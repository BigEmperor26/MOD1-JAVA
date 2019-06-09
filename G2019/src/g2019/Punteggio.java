/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g2019;

import javafx.scene.paint.Color;

/**
 * classe che gestisce il punteggio, automatizzando le operazioni di cambiamento colore
 * @author micky
 */
public class Punteggio extends Contatore{
    public Punteggio(String label) {
        super(label);
    }
    /**
     * aggiunge n al contatore. Cambia il colore del testo a seconda del punteggio <10 = BLU , ==10 = Verde >10=ROSSO
     * @param n numero da aggiungere
     */
    public void add(int n){
        super.add(n);
        if(conta<10){
            displayConta.setFill(Color.BLUE);
        }
        if(conta>10){
            displayConta.setFill(Color.RED);
        }
        if(conta==10){
            displayConta.setFill(Color.GREEN);
        }
    }    
    /**
     * sottrae n al contatore. Cambia il colore del testo a seconda del punteggio <10 = BLU , ==10 = Verde >10=ROSSO
     * @param n numero da aggiungere
     */
    public void sub(int n){
        super.sub(n);
        if(conta<10){
            displayConta.setFill(Color.BLUE);
        }
        if(conta>10){
            displayConta.setFill(Color.RED);
        }
        if(conta==10){
            displayConta.setFill(Color.GREEN);
        }
    }
}
