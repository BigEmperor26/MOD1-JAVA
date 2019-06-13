/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luglio2018observablelist;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * classe che implementa la cella con le figure.
 *
 * @author micky
 */
public class Cella extends StackPane {

    private Rectangle sfondo;
    private Figura figura;

    public Cella() {
        super();
        this.setMaxSize(Commons.CELLSIZE, Commons.CELLSIZE);
        this.setMinSize(Commons.CELLSIZE, Commons.CELLSIZE);
        sfondo = new Rectangle(Commons.CELLSIZE, Commons.CELLSIZE);
        sfondo.setFill(Color.BLACK);
        sfondo.setStroke(Color.GREEN);
        this.getChildren().add(sfondo);
    }

    public Cella(Figura fig) {
        super();
        this.figura = fig;
        sfondo = new Rectangle();
        sfondo.setFill(Color.BLACK);
        sfondo.setStroke(Color.GREEN);
        this.getChildren().addAll(sfondo);
        this.add(fig);
    }

    /**
     * metodo che permette di aggiungere una data figura alla cella
     *
     * @param fig
     */
    public void add(Figura fig) {
        figura = fig;
        this.getChildren().add(fig);

    }

    @Override
    public String toString() {
        if (figura == null) {
            return "null" ;
        } else {
            return figura.toString();
        }
    }

}
