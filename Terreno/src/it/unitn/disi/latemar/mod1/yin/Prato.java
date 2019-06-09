/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.latemar.mod1.yin;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *classe prato
 * @author michele.yin
 */
public class Prato extends Terreno{
   /**
    * costruttore di prato
    * @param gioco 
    */
    public Prato(Gioco gioco){
        super(gioco);
        cella.setFill(Color.GREEN);
    }
}
