/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settembre2018;

import java.util.Objects;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * classe che gestisce la carta come Grafica. Necessario utilizzare una classe aggiuntiva poiché la classe Carta implementa il metodo equals.
 * Ciò crea problemi quando si cerca di aggiungere una Carta che è equals ad una altra già presente nel layout
 * @author micky
 */
public class CartaGrafica extends StackPane{
    private Carta carta;
    public CartaGrafica(Carta carta){
        this.carta = carta;
        Rectangle sfondo = new Rectangle (Commons.CARDSIZE,Commons.CARDSIZE); sfondo.setFill(Color.AQUA); sfondo.setStroke(Color.BLACK);
        Text txt = new Text(carta.toString());
        this.getChildren().addAll(sfondo,txt);
    }
    /**
     * getter di carta
     * @return 
     */
    public Carta getCarta(){
        return carta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.carta);
        return hash;
    }

    /**
     * la equals di cartaGrafica non deve essere la equals di carta.
     * La equals di cartaGrafica ritorna true se e soltanto se le due carteGrafiche contengono la STESSA carta
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if(obj==null) return false;
        if(! (obj instanceof CartaGrafica)) return false;
        return this.carta == ((CartaGrafica)obj).getCarta();
    }
    
    /**
     * metodo main di test
     * @param args 
     */
    public static void main(String[] args) {

    }
    
}
