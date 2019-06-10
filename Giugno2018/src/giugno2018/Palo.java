/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giugno2018;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * classe che implementa il palo di Hanoi
 *
 * @author micky
 */
public class Palo extends StackPane {
    private String nome;
    private VBox dischi;
    private Testo from;
    private Testo to;
    private Text messaggio;
    private Stage finestra;
    private Button close;

    private class paloHandler implements EventHandler {

        private Palo palo;

        public paloHandler(Palo palo) {
            this.palo = palo;
        }

        @Override
        public void handle(Event event) {
            if (!from.isSetted()) {
                if (palo.getSize() == 0) {
                    messaggio.setText("il palo di partenza non può essere vuoto");
                    finestra.show();
                    close.setDisable(false);

                } else {
                    from.setPalo(palo);
                }
            } else {
                if (from.isSetted() && !to.isSetted()) {
                    if (palo == from.getPalo()) {
                        messaggio.setText("il palo di partenza e quello di destinazione non possono coincidere");
                        finestra.show();
                        close.setDisable(false);
                    } else {
                        to.setPalo(palo);
                    }
                } else {
                    if (from.isSetted() && to.isSetted()) {
                        messaggio.setText("il palo di partenza e quello di destinazione sono già stati definiti");
                        finestra.show();
                        close.setDisable(false);
                    }
                }
            }
        }
    }

    /**
     * costrutore di palo
     *
     * @param from Testo di partenza
     * @param to Testo di arrivo
     * @param messaggio riferimento al campo messagio della finestra delle
     * comunicazioni
     * @param finestra riferimento alla finestra delle comunicazioni
     * @param close riferimento al bottone close
     */
    public Palo(String nome,Testo from, Testo to, Text messaggio, Stage finestra, Button close) {
        super();
        this.nome = nome;
        this.from = from;
        this.to = to;
        this.messaggio = messaggio;
        this.finestra = finestra;
        this.close = close;
        this.setMinWidth(4*Commons.DISCOWIDTH);
        this.setMaxWidth(4*Commons.DISCOWIDTH);
        this.setMaxHeight(Commons.PALOHEIGHT);
        dischi = new VBox();
        //rotate in modo che i dischi vengano aggiunti in alto e non in basso
        dischi.setRotate(180);
        Rectangle sfondo = new Rectangle(Commons.PALOWIDTH, Commons.PALOHEIGHT);
        sfondo.setFill(Color.BLACK);
        this.getChildren().addAll(sfondo, dischi);
        //la vbox è ruotata ovviamente, dunque si usa top e non bottom
        dischi.setAlignment(Pos.TOP_CENTER);
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new paloHandler(this));
    }

    /**
     * metodo che aggiunge il disco al palo corrente. Ritorna true se il disco è
     * stato aggiunto
     *
     * @param disco disco da aggiungere
     * @return true se il disco è stato aggiunto correttamente. false altrimenti
     */
    public boolean add(Disco disco) {
        if (moveAllowed(disco)) {
            //this.getChildren().remove(dischi);
            this.dischi.getChildren().add(disco);
            //this.getChildren().add(dischi);
            return true;
        }
        return false;
    }

    /**
     * metodo che rimuove l'elemento in cima al palo corrente
     *
     * @return ritorna l'elemento rimosso. Se non vi sono elementi è ritornato
     * null
     */
    public Disco remove() {
        if (this.dischi.getChildren().size() == 0) {
            return null;
        }
        int indice = this.dischi.getChildren().toArray().length - 1;
        Disco ultimo = (Disco) this.dischi.getChildren().toArray()[indice];
        this.dischi.getChildren().remove(ultimo);
        return ultimo;
    }

    /**
     * metodo che ritorna l'elemento in cima al palo corrente senza rimuoverlo
     *
     * @return ritorna l'elemento rimosso. Se non vi sono elementi è ritornato
     * null
     */
    public Disco getLast() {
        if (this.dischi.getChildren().size() == 0) {
            return null;
        }
        int indice = this.dischi.getChildren().toArray().length - 1;
        Disco ultimo = (Disco) this.dischi.getChildren().toArray()[indice];
        return ultimo;
    }

    /**
     * metodo che controlla se la mossa è permessa. E' permessa se l'ultimo
     * disco inserito ha dimensione maggiore del disco da inserire
     *
     * @param disco disco da inserire
     * @return
     */
    public boolean moveAllowed(Disco disco) {
        if (this.dischi.getChildren().size() == 0) {
            return true;
        }
        int indice = this.dischi.getChildren().toArray().length - 1;
        Disco ultimo = (Disco) this.dischi.getChildren().toArray()[indice];
        if (ultimo.getSize() > disco.getSize()) {
            return true;
        }
        return false;
    }

    /**
     * ritorna il numero di dischi correntemente contenuto nel palo
     *
     * @return
     */
    public int getSize() {
        return this.dischi.getChildren().size();
    }
    @Override
    public String toString(){
        if(this.nome==null) return "";
        return this.nome;
    }
}
