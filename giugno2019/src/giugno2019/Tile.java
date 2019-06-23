/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giugno2019;

import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 * classe che gestisce la Tile
 *
 * @author micky
 */
public abstract class Tile extends StackPane implements Comparable<Tile> {

    protected int numero;
    protected Color colore;
    /**
     * flag necessario per la eventdispatchain
     */
    protected boolean clicked;

    protected EventHandler handler;

    /**
     * costruttore della tile
     *
     * @param numero
     * @param color
     */
    public Tile(int numero, Color color) {
        this.setMinSize(Commons.CELLSIZE, Commons.CELLSIZE);
        this.setMaxSize(Commons.CELLSIZE, Commons.CELLSIZE);
        this.numero = numero;
        this.colore = color;
        clicked = false;
    }

    public int getNumero() {
        return this.numero;
    }

    public abstract void disegna();

    /**
     * metodo per controllare se due Tile sono equivalneti. Equivalenza definita
     * se sono dello stesso tipo, square o circle, e hanno lo stesso numero
     *
     * @param e Tile di confronto
     * @return
     */
    public boolean isEquivalent(Tile e) {
        if (e instanceof Tile) {
            if (this.getClass().equals(e.getClass()) && this.numero == e.getNumero()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Tile e) {
        return this.numero - e.getNumero();
    }

    /**
     * metodo che ritorna lo eventHandler della Tile
     *
     * @return eventhandler ritornato
     */
    public EventHandler getHandler() {
        return handler;
    }

    /**
     * metodo che setta il colore della Tile
     *
     * @param colore nuovo colore
     */
    public void setColore(Color colore) {
        this.colore = colore;
        this.disegna();
    }

    /**
     * metodo che ritorna il colore corrente della Tile
     *
     * @return
     */
    public Color getColore() {
        return colore;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
}
