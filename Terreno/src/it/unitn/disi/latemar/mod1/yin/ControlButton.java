/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.latemar.mod1.yin;

import javafx.scene.control.Button;

/**
 *
 * @author micky
 */
public class ControlButton extends Button{

    public ControlButton(String text) {
        super(text);
        this.setMaxHeight(20);
        this.setMaxWidth(80);
    }
    
}
