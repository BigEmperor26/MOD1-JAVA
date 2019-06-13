/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luglio2016;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * classe che implementa il torneo. Contiene 4 gironi
 * @author micky
 */
public class Torneo extends GridPane{
    private Girone gironeA;
    private Girone gironeB;
    private Girone gironeC;
    private Girone gironeD;
    public Torneo(){
        gironeA =new Girone(new Squadra("Italia",1,Color.RED,Color.WHITE,Color.GREEN),new Squadra("Germania",2,Color.RED,Color.YELLOW,Color.BLACK),new Squadra("C"),new Squadra("D"));
        gironeB =new Girone(new Squadra("E"),new Squadra("F"),new Squadra("G"),new Squadra("H"));
        gironeC =new Girone(new Squadra("I"),new Squadra("J"),new Squadra("K"),new Squadra("L"));
        gironeD =new Girone(new Squadra("M"),new Squadra("N"),new Squadra("O"),new Squadra("P"));
        this.add(gironeA, 0, 0);
        this.add(gironeB, 1, 0);
        this.add(gironeC, 0, 1);
        this.add(gironeD, 1, 1);
    }
    /**
     * metodo che permette di disputare la partita
     */
    public  void gioca(int g){
        for(Node e : this.getChildren()){
            if( e instanceof Girone){
                ((Girone)e).gioca(g);
            }
        }
    }
}
