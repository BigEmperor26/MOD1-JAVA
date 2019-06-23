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
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 *
 * @author micky
 */
public class CircleTile extends Tile {

    public CircleTile(int numero, Color colore) {
        super(numero, colore);
        disegna();
        this.handler = new EventHandler() {
            @Override
            public void handle(Event event) {
                CircleTile.this.numero++;
                if (CircleTile.this.numero == 10) {
                    CircleTile.this.numero = 0;
                }
                CircleTile.this.disegna();
                CircleTile.this.clicked = true;
            }
        };
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
    }

    @Override
    public void disegna() {
        Circle sfondo = new Circle(Commons.CELLSIZE / 2);
        sfondo.setFill(this.colore);
        Text testo = new Text(Integer.toString(this.numero));
        testo.setFill(colore.invert());
        this.getChildren().addAll(sfondo, testo);
    }

}
