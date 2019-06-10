/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giugno2018;

import javafx.scene.text.Text;

/**
 * classe che implementa il testo from e to. Contiene dei flag per segnalare se
 * from o to sono stati settati o meno. Inoltre contiene il palo
 *
 * @author micky
 */
public class Testo extends Text {
    private String nome;
    private Palo palo;

    public Testo(String nome) {
        super(nome);
        this.nome=nome;
        this.setWrappingWidth(Commons.WIDTH/10);
    }

    public void setTesto(String s) {
        this.nome=s;
        this.setText(s);
    }

    /**
     * metodo che setta il palo in modo che sia associato al campo di testo
     */
    public void setPalo(Palo palo) {
        this.palo = palo;
        this.setText("");
        String t;
        if(palo==null) t="";
        else t=palo.toString();
        this.setText(this.nome+ " " +t);
    }

    /**
     * ritorna il palo associato correntemente al testo
     *
     * @return
     */
    public Palo getPalo() {
        return this.palo;
    }

    public boolean isSetted() {
        return this.palo != null;
    }
}
