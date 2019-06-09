/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g2019;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Text;

/**
 * classe che gestisce la tessera di tipo V
 * @author micky
 */
public class V extends Tessera{

    public V(int width, int height, G2019 gioco) {
        super(width, height, gioco);
        tipo="V";
        testo.setText(tipo);
        testo.setVisible(false);
    }
    /**
     * metodo scopri di V,  chiama il metodo vinci di Tessera per mostrare la vittoria
     */ 
    @Override
    public void scopri() {
        testo.setVisible(true);
        vinci();
    }

    /**
     * ovviamente il metodo nascondi di V non fa nulla
     */
    @Override
    public void nascondi() {
    }
    
}
