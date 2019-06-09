/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package febbraio2019;

import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * classe che si occupa del testo di output
 * @author micky
 */
public class Testo extends StackPane{
    private Text txt;
    private String stringa;
    private Rectangle sfondo;
    public Testo(){
        sfondo = new Rectangle(Commons.SIZE/2,Commons.SIZE/2);
        sfondo.setFill(Color.WHITE);
        sfondo.setStroke(Color.BLACK);
        txt = new Text();
        this.getChildren().addAll(sfondo,txt);
        stringa = "";
    }
    /**
     * metodo che permette di settare il testo
     */
    public void setText(String stringa){
        this.stringa = stringa; 
        txt.setText(this.stringa);
        StackPane.setAlignment(txt, Pos.TOP_LEFT);
    }
    /**
     * metodo che permette di aggiungere il testo in coda
     */
    public void insertText(String stringa){
        this.stringa += stringa; 
        txt.setText(this.stringa);
    }
    /**
     * metodo che permette di pulire il testo
     */
    public void clear(){
        this.stringa = "";
        txt.setText(this.stringa);
    }
}
