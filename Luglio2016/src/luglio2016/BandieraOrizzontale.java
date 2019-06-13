/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luglio2016;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author micky
 */
public class BandieraOrizzontale extends Bandiera{
    public BandieraOrizzontale(Color c1,Color c2, Color c3) {
        super();
        VBox strisce = new VBox();
        Rectangle s1 = new Rectangle(Commons.BANDIERASIZE,Commons.BANDIERASIZE/3);
        Rectangle s2 = new Rectangle(Commons.BANDIERASIZE,Commons.BANDIERASIZE/3);
        Rectangle s3 = new Rectangle(Commons.BANDIERASIZE,Commons.BANDIERASIZE/3);
        s1.setFill(c1); s2.setFill(c2); s3.setFill(c3);
        strisce.getChildren().addAll(s1,s2,s3);
        this.getChildren().add(strisce);
    }
}
