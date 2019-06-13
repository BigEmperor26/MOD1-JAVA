/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luglio2016;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * classe che gestisce la singola squadra di calcio. Contiene un nome e una bandiera
 * @author micky
 */
class Squadra extends HBox implements Comparable{
    private Text nome;
    private String s;
    private Bandiera bandiera;
    private int punteggio;
    public Squadra(String nome){
        this.s=nome;
        this.nome = new Text(punteggio + " "+ nome);
        this.nome.setWrappingWidth(Commons.BANDIERASIZE);
        bandiera = new BandieraCroce(Color.AQUA,Color.BLUE);
        this.getChildren().addAll(this.nome,bandiera);
        this.setAlignment(Pos.CENTER);
        punteggio=0;
    }
    /**
     * costruttore di una squadra
     * @param nome nome
     * @param tipoBandiera 0 bandiera a croce, 1 bandiera verticale, 2 bandiera orizzontale
     * @param c1 colore 
     * @param c2 colore
     * @param c3 colore
     */
    public Squadra(String nome, int tipoBandiera,Color c1, Color c2, Color c3){
        this.s=nome;
        this.nome = new Text(punteggio + " "+ nome);
        this.nome.setWrappingWidth(Commons.BANDIERASIZE);
        switch(tipoBandiera){
            case 0:bandiera = new BandieraCroce(c1,c2); break;
            
            case 1:bandiera = new BandieraVerticale(c1,c2,c3); break;
            
            case 2:bandiera = new BandieraOrizzontale(c1,c2,c3); break;
        
        }
        this.getChildren().addAll(this.nome,bandiera);
        this.setAlignment(Pos.CENTER);
        punteggio=0;
    }
    public String toString(){
        return this.s;
    }
    /**
     * metodo che permette di aggiungere i punti al punteggio corrente
     * @param punti 
     */
    public void incrementPunteggio(int punti){
        punteggio+=punti;
    }

    public int getPunteggio(){
        return punteggio;
    }
    @Override
    public int compareTo(Object o) {
        if(o instanceof Squadra){
            return ((Squadra)o).getPunteggio() - this.punteggio;
        }
        return this.toString().compareTo(((Squadra)o).toString());
    }
    /**
     * metodo che permette di aggiornare il punteggio
     */
    public void refreshPunteggio(){
        this.nome.setText(punteggio + " "+ s);
    }


    
}
