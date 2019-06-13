/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luglio2016;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author micky
 */
public class BandieraCroce  extends Bandiera{
    public BandieraCroce(Color c1,Color c2) {
        super();
        Rectangle s1 = new Rectangle(Commons.BANDIERASIZE,Commons.BANDIERASIZE);
        Rectangle s2 = new Rectangle(Commons.BANDIERASIZE/6,Commons.BANDIERASIZE);
        Rectangle s3 = new Rectangle(Commons.BANDIERASIZE,Commons.BANDIERASIZE/6);
        s1.setFill(c1); s2.setFill(c2); s3.setFill(c2);
        this.getChildren().addAll(s1,s2,s3);
    }
}