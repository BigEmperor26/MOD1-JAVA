/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g2019;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 * classe che gestisce la tessera di tipo P
 * @author micky
 */
public class P extends Tessera{
    public P(int width, int height, G2019 gioco) {
        super(width, height, gioco);
        tipo="P";
        testo.setText(tipo);
        testo.setVisible(false);
    }
    /**
     * metodo scopri di P, chiama il metodo perdi di tessera per terminare il gioco
     */ 
    @Override
    public void scopri() {
        testo.setVisible(true);
        perdi();
    }
    
    /**
     * ovviamente il metodo nascondi di P non fa nulla
     */
    @Override
    public void nascondi() {
    }
    
}
