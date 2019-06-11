/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luglio2017;

import java.util.ArrayList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * classe che implementa il dado. Il dado mostra solo una faccia alla volta
 *
 * @author micky
 */
public class Dado extends StackPane {

    private int n;
    /**
     * i punti sono contenuti in un gridpane 3x3
     */
    private GridPane punti;
    private boolean triggered;


    /**
     * costruttore di un dado.Viene mostrata la faccia n.
     *
     * @param n numero di punti sulla faccia mostrata
     */
    public Dado(int n) {
        super();
        this.setMaxSize(Commons.DADOSIZE, Commons.DADOSIZE);
        this.setMinSize(Commons.DADOSIZE, Commons.DADOSIZE);
        Rectangle sfondo = new Rectangle(Commons.DADOSIZE, Commons.DADOSIZE);
        sfondo.setFill(Color.WHITE);
        sfondo.setStroke(Color.BLACK);
        punti = new GridPane();
        punti.setMinSize(Commons.DADOSIZE, Commons.DADOSIZE);
        punti.setMaxSize(Commons.DOTSIZE, Commons.DADOSIZE);
        punti.setAlignment(Pos.CENTER);
        for (int i = 0; i < 3; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100 / 3);
            punti.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < 3; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100 / 3);
            punti.getRowConstraints().add(rowConst);
        }
        this.getChildren().addAll(sfondo, punti);
        this.n = n;
        roll(n);
        /**
         *  filter del dado. Setta il flag a true in modo che il Campo, contenente il dado, possa effettuare un roll se l'event dispatch chain è passata da qua
         * */
        
        this.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler() {
            @Override
            public void handle(Event event) {
                triggered=true;
            }
        });
        
        
    }

    /**
     * metodo che ritorna il punteggio corrente del dado
     *
     * @return punteggio della faccia corrente
     */
    public int getScore() {
        return this.n;
    }

    /**
     * metodo che re-roll il dado. 
     * @param n punteggio desiderato per la faccia. compreso tra 0 e 6
     */
    public void roll(int n) {
        punti.getChildren().clear();
        this.n = n;
        triggered=false;
        ArrayList<StackPane> p = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Circle cerchio = new Circle(Commons.DOTSIZE);
            cerchio.setFill(Color.BLACK);
            StackPane tmp = new StackPane();
            tmp.getChildren().add(cerchio);
            p.add(tmp);
        }
        switch (n) {
            case 1:
                punti.add(p.get(0), 1, 1);
                break;
            case 2:
                punti.add(p.get(0), 0, 0);
                punti.add(p.get(1), 2, 2);
                break;
            case 3:
                punti.add(p.get(0), 0, 0);
                punti.add(p.get(1), 1, 1);
                punti.add(p.get(2), 2, 2);
                break;
            case 4:
                punti.add(p.get(0), 0, 0);
                punti.add(p.get(1), 2, 0);
                punti.add(p.get(2), 0, 2);
                punti.add(p.get(3), 2, 2);
                break;
            case 5:
                punti.add(p.get(0), 0, 0);
                punti.add(p.get(1), 2, 0);
                punti.add(p.get(2), 0, 2);
                punti.add(p.get(3), 2, 2);
                punti.add(p.get(4), 1, 1);
                break;
            case 6:
                punti.add(p.get(0), 0, 0);
                punti.add(p.get(1), 1, 0);
                punti.add(p.get(2), 2, 0);
                punti.add(p.get(3), 0, 2);
                punti.add(p.get(4), 1, 2);
                punti.add(p.get(5), 2, 2);
                break;
            default:
        }
        for (Node e : this.punti.getChildren()) {
            StackPane.setAlignment(e, Pos.CENTER);
        }
    }

    /**
     * ritorna il flag per la gestione dell'event dispatch chain
     * @return 
     */
    public boolean isTriggered() {
        return triggered;
    }
    
}
