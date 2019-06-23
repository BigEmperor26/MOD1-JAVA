/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giugno2019;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * classe che gestisce la quadreTile, eredita da Tile
 *
 * @author micky
 */
public class SquareTile extends Tile {

    public SquareTile(int numero, Color colore) {
        super(numero, colore);
        disegna();
        this.handler =  new EventHandler() {
            @Override
            public void handle(Event event) {
                SquareTile.this.numero--;
                if (SquareTile.this.numero == -1) {
                    SquareTile.this.numero = 9;
                }
                SquareTile.this.disegna();
                SquareTile.this.clicked=true;
            }
        };
        this.addEventHandler(MouseEvent.MOUSE_CLICKED,handler);
    }

    @Override
    public void disegna() {
        Rectangle sfondo = new Rectangle(Commons.CELLSIZE, Commons.CELLSIZE);
        sfondo.setFill(this.colore);
        Text testo = new Text(Integer.toString(this.numero));
        testo.setFill(colore.invert());
        this.getChildren().addAll(sfondo, testo);
    }

}
