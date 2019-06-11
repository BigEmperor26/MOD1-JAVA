/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luglio2017;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * classe che gestisce il campo di testo con la label
 *
 * @author micky
 */
public class ValueBox extends VBox {

    private Text label;
    private TextField campo;
    private int n;

    /**
     * costruttore
     *
     * @param s nome della label
     * @param n contatore iniziale
     */
    public ValueBox(String s, int n) {
        super();
        label = new Text(s);
        campo = new TextField(Integer.toString(n));
        campo.setEditable(false);
        this.getChildren().addAll(label, campo);
        this.n = n;
    }

    /**
     * metodo che decrementa il contatore
     */
    public void decrement() {
        n--;
        campo.setText(Integer.toString(n));
        if (n == 0) {
            Alert finestra = new Alert(AlertType.INFORMATION);
            finestra.setContentText("Hai Perso");
            finestra.showAndWait();
        }
    }

    /**
     * metodo che incrementa il contatore
     */
    public void increment() {
        n++;
        campo.setText(Integer.toString(n));
    }

    /**
     * metodo che ottiene il contatore
     *
     * @return
     */
    public int getN() {
        return n;
    }

}
