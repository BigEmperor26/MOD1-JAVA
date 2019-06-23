/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giugno2019;

import java.util.ArrayList;
import java.util.Collections;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * classe che gestice l'insieme di Tile vcrticale
 *
 * @author micky
 */
public class Stack extends ListaTile {

    ArrayList<Tile> rimossi;

    /**
     * costruttore di uno stack
     */
    public Stack() {
        rimossi = null;
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler() {
            @Override
            public void handle(Event event) {
                Stack.this.removeDuplicate();
                for (Tile e : Stack.this.lista) {
                    if (e.isClicked()) {
                        Stack.this.lista.remove(e);
                        if (e instanceof SquareTile) {
                            Stack.this.lista.add(0, e);
                        }
                        if (e instanceof CircleTile) {
                            Stack.this.lista.add(e);
                        }
                        e.setClicked(false);
                        Stack.this.disegna();
                        return;
                    }
                }
            }
        });
    }

    /**
     * metodo per aggiungere l'elemento e allo stack. Viene controllato se due
     * Tile sono equivalenti e non vengono aggiunte nel caso
     *
     * @param e Tile da aggiungere
     */
    @Override
    public void add(Tile e) {
        boolean isIn = false;
        if (this.lista.size() < 1) {
            this.lista.add(e);
        } else {
            for (Tile i : this.lista) {
                if (e.isEquivalent(i)) {
                    isIn = true;
                }
            }
            if (!isIn) {
                this.lista.add(e);
            }
        }
        this.disegna();
    }

    /**
     * metodo che ordina lo stack secondo i numeri presenti nelle singole tile
     */
    public void ordina() {
        Collections.sort(this.lista);
        this.disegna();
    }

    /**
     * ritorna la lista degli elementi rimossi
     *
     * @return
     */
    public ArrayList<Tile> getRimossi() {
        return rimossi;
    }

    public ArrayList<Tile> setRimossi() {
        return rimossi = null;
    }

    /**
     * metodo che rimuove gli elementi equivalenti dello stack
     *
     * @return ArrayList contentente gli elementi rimossi
     */
    public ArrayList<Tile> removeDuplicate() {
        rimossi = new ArrayList<>();
        for (int i = 0; i < this.lista.size(); i++) {
            for (int j = i + 1; j < this.lista.size(); j++) {
                Tile indiceI = this.lista.get(i);
                Tile indiceJ = this.lista.get(j);
                if (indiceI.isEquivalent(indiceJ) && i != j) {
                    rimossi.add(indiceJ);
                    rimossi.add(indiceI);
                    // rimozione prima del j-esimo e poi del i-esimo perché il jesimo è dopo il iesimo e la rimnozione dell'iesimo causerebbe problemi con l'indice
                    this.lista.remove(j);
                    this.lista.remove(i);
                }
            }
        }
        this.disegna();
        return rimossi;
    }

    /**
     * metodo che si occupa di esdeguire un fireEvent sulla Tile dello stack il
     * cui numero è il tasto da tastiera premuto. In caso vi siano p'ù Tile con
     * lo stesso numero, è scelto il primo
     *
     * @param keyEvent
     */
    public void KeyPressed(KeyEvent keyEvent) {
        int numero = -1;
        try {
            numero = Integer.parseInt(keyEvent.getCharacter());
        } catch (NumberFormatException ex) {
        }
        for (Tile e : this.lista) {
            if (e.getNumero() == numero) {
                e.fireEvent(new MouseEvent(MouseEvent.MOUSE_CLICKED, e.getLayoutX(), e.getLayoutY(), e.getLayoutX(), e.getLayoutY(), MouseButton.PRIMARY, 1, true, true, true, true, true, true, true, true, true, true, null));
                return;

            }
        }
    }
}
