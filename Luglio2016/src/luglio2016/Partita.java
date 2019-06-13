/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luglio2016;

import javafx.scene.text.Text;

/**
 * classe che gestisce l'evento partita. Contiene due squadre, un flag che stabilisce se la partita è stata disputata o meno e l'eventuale punteggio. 
 * @author micky
 */
class Partita extends Text{
    private Squadra a;
    private Squadra b;
    private boolean disputata;
    private int[] punteggio;
    private int giornata;
    public Partita(Squadra a,Squadra b, int giornata){
        super();
        this.a=a; this.b=b; disputata=false;
        punteggio = new int [2];
        this.giornata=giornata;
        this.setText(this.toString());
    }
    /**
     * metodo che disputa la partita. Il vincitore è scelto in maniera causale. i punteggi sono scelti in maniera casuale tra 0 e 2
     */
    public void disputaPartita(){
        punteggio[0] = Commons.rand.nextInt(3);
        punteggio[1] = Commons.rand.nextInt(3);
        disputata = true;
        this.setText(this.toString());
        if(vincitrice()==a){
            a.incrementPunteggio(3);
        }
        if(vincitrice()==b){
            b.incrementPunteggio(3);
        }
        if(vincitrice()==null){
            a.incrementPunteggio(1);
            b.incrementPunteggio(1);
        }
        a.refreshPunteggio();
        b.refreshPunteggio();
    }
    public String toString(){
        if(disputata)
        return a.toString()+" "+b.toString() + "\t" + punteggio[0] + "-"+punteggio[1];
        else
        return a.toString()+" "+b.toString();     
    }

    /**
     * ritorna la giornata in cui viene disputata la partita
     * @return intero compreso tra 1 e 3. 
     */
    public int getGiornata() {
        return this.giornata;
    }
    /**
     * ritorna la squadra che ha vinto la partita
     * @return la squadra vincitrice. null se pareggio
     */
    public Squadra vincitrice(){
        if(punteggio[0]>punteggio[1]) return a;
        if(punteggio[0]<punteggio[1]) return b;
        return null;
    }
    /**
     * 
     */
    public boolean isDisputata(){
        return disputata;
    }
}
