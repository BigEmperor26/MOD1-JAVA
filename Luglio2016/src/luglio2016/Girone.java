/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luglio2016;

import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * classe che gestisce il tabellone con i punteggi e la classifica della singola Divisione
 *
 * @author micky
 */
class Girone extends VBox {
    private Squadra a;
    private Squadra b;
    private Squadra c;
    private Squadra d;
    private VBox classificaGrafica = new VBox();
    private ArrayList<Squadra> classifica;
    private VBox partiteGrafica = new VBox();
    private ArrayList<Partita> partite;
    private int giornata;

    /**
     * costruttore del tabellone. Crea 4 squadre coi nomi a,b,c,d
     *
     * @param a
     * @param b
     * @param c
     * @param d
     */
    public Girone(Squadra a, Squadra b, Squadra c, Squadra d) {
        
        partite = new ArrayList <>();
        /*squadre.add(new Squadra(a));squadre.add(new Squadra(b));squadre.add(new Squadra(c));squadre.add(new Squadra(d));
         */
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        //prima giornata
        partite.add(new Partita(this.a, this.b, 1));
        partite.add(new Partita(this.c, this.d, 1));
        //seconda giornata
        partite.add(new Partita(this.a, this.c, 2));
        partite.add(new Partita(this.b, this.d, 2));
        //terza giornata
        partite.add(new Partita(this.a, this.d, 3));
        partite.add(new Partita(this.b, this.c, 3));
        //
        refreshPartite();
        giornata=0;
        this.setMaxSize(Commons.GIRONESIZE, Commons.GIRONESIZE);
        this.setMinSize(Commons.GIRONESIZE, Commons.GIRONESIZE);
        //aggiunta della classifica
        classifica = new ArrayList<>();
        classifica.add(this.a);classifica.add(this.b);classifica.add(this.c);classifica.add(this.d);
        refreshClassifica();
    }

    /**
     * metodo che permette di aggiornare il campo di partiteGrafica contenente le partite
     */
    public void refreshPartite() {
        this.getChildren().remove(partiteGrafica);
        partiteGrafica.getChildren().clear();
        partiteGrafica.getChildren().add(new Text("1 Giornata"));
        for (Partita e : partite) {
            if (e.getGiornata() == 1) {
                partiteGrafica.getChildren().add(e);
            }
        }
        partiteGrafica.getChildren().add(new Text("2 Giornata"));
        for (Partita e : partite) {
            if (e.getGiornata() == 2) {
                partiteGrafica.getChildren().add(e);
            }
        }
        partiteGrafica.getChildren().add(new Text("3 Giornata"));
        for (Partita e : partite) {
            if (e.getGiornata() == 3) {
                partiteGrafica.getChildren().add(e);
            }
        }
        this.getChildren().add(partiteGrafica);
    }
    /**
     * metodo che permette di giocare la successiva giornata del girone.
     */
    public void gioca(int g){
        for( Partita e : partite){
            if(e.getGiornata() == g && !e.isDisputata()){
                e.disputaPartita();
            }
        }
       // refreshPartite();
        giornata++;
        refreshClassifica();
    }
    public void refreshClassifica(){
        Collections.sort(classifica);
        this.getChildren().remove(classificaGrafica);
        classificaGrafica.getChildren().clear();
        classificaGrafica.setSpacing(5.00);
        classificaGrafica.getChildren().add(new Text("CLASSIFICA"));
        for( Squadra e :classifica){
            classificaGrafica.getChildren().add(e);
        }
        this.getChildren().add(classificaGrafica);
        
    }
}
