/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package febbraio2019;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * classe che gestisce una delle due metà dello schermo
 * @author micky
 */
public abstract class Pannello extends BorderPane{
    /**
     * testo
     */
    protected Testo testo;
    /**
     * 4 bottoni che fanno parte di un vBOX
     */
    protected Button mescola;
    protected Button ordina;
    protected Button conta;
    protected Button ordinaSpeciale;
    protected VBox bottoni;
    /**
     * bottone isolato in basso
     */
    protected Button aggiungi;
    /**
     * insieme di riferimento
     */
    protected SetRecord set;
    /**
     * finestra popup
     */
    protected FinestraPopUp finestra;

    /**
     * costruttore
     * @param ord testo del bottone ordinamentospeciale
     * @param nuovo testo del bottone aggiungi
     * @param l1 testo del primo campo della finestra di popup
     * @param l2 secondo campo
     * @param l3 terzo campo
     */
    public Pannello(String ord, String nuovo,String l1,String l2,String l3){
        testo = new Testo();
        set = new SetRecord();
        mescola = new Button(Commons.MESCOLA);
        mescola.setPrefWidth(Commons.SIZE/4);
        mescola.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                set.mescola();
                testo.setText(set.toString());
                System.out.println(set.toString());;
            }
        });
        ordina = new Button(Commons.ORDINA);
        ordina.setPrefWidth(Commons.SIZE/4);
        ordina.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                set.ordinaField2();
                testo.setText(set.toString());
                System.out.println(set.toString());;
            }
        });
        conta = new Button(Commons.CONTA);
        conta.setPrefWidth(Commons.SIZE/4);
        conta.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                testo.setText(Integer.toString(set.count()));
                System.out.println(set.count());
            }
        });
        ordinaSpeciale = new Button(ord);
        ordinaSpeciale.setPrefWidth(Commons.SIZE/4);
        ordinaSpeciale.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                set.ordinaField3();
                testo.setText(set.toString());
                System.out.println(set.toString());;
            }
        });
        aggiungi = new Button(nuovo);
        aggiungi.setPrefWidth(Commons.SIZE/4);
        aggiungi.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                finestra.showAndWait();
            }
        
        });
        bottoni = new VBox(mescola,ordina,conta,ordinaSpeciale);
        this.setTop(testo);
        this.setHeight(Commons.SIZE);
        this.setWidth(Commons.SIZE/2);

    }
    /**
     * aggiunge l'elemento e all'insieme e aggiorna il campo di testo
     * @param e elemento da aggiungere
     * @return true se e è stato aggiunto, false altrimenti
     */
    public boolean add(Record e){
        if(set.add(e)){
            testo.setText(set.toString());
            System.out.println(set.toString());
            return true;
        }
        return false;
    }
}
