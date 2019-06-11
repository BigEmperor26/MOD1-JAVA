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
    private ValueBox contatore;
    /**
     * i punti sono contenuti in un gridpane 3x3
     */
    private GridPane punti;
    private Campo campo;

    /**
     * costruttore di un dado.Viene mostrata la faccia n.Il costruttore non
     * consuma il contatore dei lanci rimasti
     *
     * @param n numero di punti sulla faccia mostrata
     * @param contatore riferimento al contatore
     * @param campo riferimento al campo in cui è contenuto
     */
    public Dado(int n, ValueBox contatore, Campo campo) {
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
        this.contatore = contatore;
        this.n = n;
        this.campo = campo;
        roll(n);
        contatore.increment();
        /**
         * handler del dado. Se il dado è premuto col mouse, viene rigenerato
         * casualmente il punteggio
         */
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler() {
            @Override
            public void handle(Event event) {
                if (contatore.getN() > 0) {
                    roll(Commons.ran.nextInt(6) + 1);
                }
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

    public void roll(int n) {
        punti.getChildren().clear();
        this.n = n;
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
        this.contatore.decrement();
        this.campo.checkWin();
    }
    /**
     * metodo che cambia la faccia del dado con la n-esima
     *
     * @param n punteggio che si vuole ottenere sulla faccia del dado
     */
    /*public void roll(int n) {
        punti.getChildren().clear();
        this.n=n;
        for (int i = 0; i < n; i++) {
            punti.getChildren().add(new Circle(Commons.DOTSIZE));
        }
        this.contatore.decrement();
        this.campo.checkWin();
    }*/
}
