/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luglio2016;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

/**
 * classe che gestisce il rettangolo
 * @author micky
 */
public abstract class Bandiera extends StackPane { 
    public Bandiera() {
        this.setMaxSize(Commons.BANDIERASIZE, Commons.BANDIERASIZE);
        this.setMinSize(Commons.BANDIERASIZE, Commons.BANDIERASIZE);
    }
    
}
