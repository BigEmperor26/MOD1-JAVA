/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giocodel9;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author micky
 */
public class White extends Rectangle{
    private int i;
    private int j;
    public White(){
        super(Commons.SCENEHEIGHT/Commons.NUMROWS,Commons.SCENEWIDTH/Commons.NUMCOLS);
        this.setFill(Color.WHITE);
    }
    public void setPosition(int i, int j){
        this.i=i;
        this.j=j;
    }
    public int getPositionX(){
        return this.i;
    }
    public int getPositionY(){
        return this.j;
    }
}
