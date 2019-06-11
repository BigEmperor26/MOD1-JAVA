/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luglio2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * classe che implementa il campo di gioco. Contiene 3 dadi e lo sfondo è verde
 *
 * @author micky
 */
public class Campo extends StackPane {

    private int dadiAttivi;
    private HBox dadi;
    private ValueBox contatore;

    /**
     * costruttore del campo verde. Di dafault non vi sono ancora dadi
     *
     * @param contatore riferimento al contatore. Necessario per decrementare lo
     * stesso ad ogni rilancio del dado
     */
    public Campo(ValueBox contatore) {
        super();
        this.contatore = contatore;
        this.setMaxSize(Commons.CENTERSIZE, Commons.CENTERSIZE);
        this.setMinSize(Commons.CENTERSIZE, Commons.CENTERSIZE);
        dadi = new HBox();
        dadi.setMaxWidth(3 * Commons.DADOSIZE);
        dadi.setMaxHeight(Commons.DADOSIZE);
        dadiAttivi = 0;
        Rectangle sfondo = new Rectangle(Commons.CENTERSIZE, Commons.CENTERSIZE);
        sfondo.setFill(Color.GREEN);
        this.getChildren().addAll(sfondo, dadi);
        StackPane.setAlignment(dadi, Pos.CENTER);

        // eventhanlder del campo. Se premuto viene aggiunto un dado, senza consumare i lanci rimasti
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler() {
            @Override
            public void handle(Event event) {
                if (dadiAttivi < 3) {
                    mostraDado();
                }
            }
        });
        //event handler per mescolare i DADI. Impossibile attualmente.
        /*this.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler() {
            @Override
            public void handle(Event event) {
            System.out.println("Event filter");
                
            System.out.println(((MouseEvent)event).getTarget().getClass().toString());
            
            System.out.println("Click sul dado che è meglio");
            if(((MouseEvent)event).getTarget().getClass().toString())
            }
        });*/
    }

    /**
     * metodo che permette di aggiungere un dado, con punteggio casuale. il
     * numero di dadi attivi viene incrementato. Massimo 3
     */
    public void mostraDado() {
        if (dadiAttivi < 3) {
            dadiAttivi++;
            dadi.getChildren().add(new Dado(Commons.ran.nextInt(6) + 1, this.contatore, this));
            StackPane.setAlignment(dadi, Pos.CENTER);
        }
    }

    /**
     * metodo che mostra la schermata di vittoria
     */
    public void showWin() {
        Alert finestra = new Alert(Alert.AlertType.INFORMATION);
        finestra.setContentText("Hai Vinto");
        finestra.show();
    }

    /**
     * metodo che controlla se vi sono 3 dadi con 3 punteggi consecutivi in
     * qualsiasi ordine. Se è verificata la condizione viene mostrata la
     * finestra di vittoria
     *
     * @return true se la condizione è verificata. false altrimenti
     */
    public boolean checkWin() {
        if (this.dadiAttivi < 3) {
            return false;
        }
        ArrayList<Integer> valori = new ArrayList<>();
        for (Node e : dadi.getChildren()) {
            if (e instanceof Dado) {
                valori.add(((Dado) e).getScore());
            }
        }
        Collections.sort(valori);
        for (int i = 0; i < valori.size() - 1; i++) {
            if (valori.get(i) != valori.get(i + 1) - 1) {
                return false;
            }
        }
        showWin();
        return true;
    }

    @Override
    public String toString() {
        String t = "";
        int i = 1;
        int somma = 0;
        for (Node e : dadi.getChildren()) {
            if (e instanceof Dado) {
                t += "Dado " + Integer.toString(i) + " vale " + ((Dado) e).getScore() + "\n";
                somma += ((Dado) e).getScore();
                i++;
            }
        }
        t += "il totale è " + somma;
        return t;
    }
}
