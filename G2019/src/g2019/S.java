/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g2019;

import java.util.Optional;
import javafx.event.EventType;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * classe che gestisce la tessera di tipo S
 * @author micky
 */
public class S extends Tessera{
    private int numero;
    public S(int width, int height, G2019 gioco) {
        super(width, height, gioco);
        numero=Commons.rand.nextInt(9)+1;
        tipo="S";
        testo.setText(Integer.toString(numero));
        testo.setVisible(false);
    }
    /**
     * metodo scopri di S, chiama il metodo add di Punteggio
     */ 
    @Override
    public void scopri() {
        testo.setVisible(true);
        gioco.punteggio.add(numero);
        System.out.println(this + " " + numero);
        if(gioco.punteggio.getConta()==10){
            vinci();
        }
    }
    
    /**
     * nasconde la tessera, chiamando il metodo sub di Punteggio
     */
    @Override
    public void nascondi() {
        testo.setVisible(false);
        gioco.punteggio.sub(numero);
        System.out.println(this + " " + numero);
        if(gioco.punteggio.getConta()==10){
            vinci();
        
        }
    }
    /**
     * toString
     */
    @Override
    public String toString(){
        return Integer.toString(numero);
    }
    
}
