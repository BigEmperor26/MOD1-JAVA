/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settembre2018;

import java.util.Optional;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * classe che gestisce il giocatore
 * @author micky
 */
public class Giocatore extends VBox{
    private Text nome;
    private Button pescaAvversario;
    private Button coppia;
    private Button pescaMazzo;
    private Mazzo mazzo;
    private Mano mano;
    private Giocatore avversario;
    private boolean hoScartato;
    /**
     * costruttore del giocatore. Costruisce una HBox contenente i campi nome, 3 bottoni. 
     * Il giocatore pesca dal mazzo le prime 4 carte.
     * i bottoni sono disabilitati di default
     * @param nome nome del player
     * @param mazzo riferimento al mazzo 
     */
    public Giocatore(String nome,Mazzo mazz) {
        this.nome = new Text(nome);
        this.mazzo = mazz;
        this.mano = new Mano(this);
        setMano();
        pescaAvversario = new Button("Pesca dall'avversario");
        pescaAvversario.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                avversario.mano.pesca(mano);
                System.out.println("===");
                System.out.println(mano);
                System.out.println(avversario.mano);
                pescaAvversario.setDisable(true);
                coppia.setDisable(false);
                checkWin();
                avversario.checkWin();
            }
        });
        coppia = new Button("Cerca la coppia");    
        hoScartato=false;
        coppia.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                hoScartato = mano.removeCoppie();
                System.out.println("===");
                System.out.println(mano);
                coppia.setDisable(true);
                pescaMazzo.setDisable(false);
                checkWin();
                avversario.checkWin();      
            }
        });
        pescaMazzo = new Button("Pesca dal mazzo");
        pescaMazzo.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                System.out.println("===");
                if(hoScartato){ System.out.println("Ho scartato, non pesco");}
                else{
                    mazzo.pesca(mano);
                }
                System.out.println(mano);
                pescaMazzo.setDisable(true);
                avversario.setPescaAvversarioFlag(false);
            }
        });
        
        HBox barra = new HBox(this.nome,pescaAvversario,coppia,pescaMazzo);
        this.getChildren().add(barra);
        this.getChildren().add(mano);
        pescaAvversario.setDisable(true);
        coppia.setDisable(true);
        pescaMazzo.setDisable(true);
        System.out.println(mano);
    }
    /**
     * metodo che setta il giocatore avversario
     * @param avversario
     */
    public void setAvversario(Giocatore avversario){
        this.avversario = avversario;
    }
    /**
     * pesca le prime 4 carte dal mazzo. Chiamato quando viene costruito un giocatore
     */
    public void setMano(){
        for(int i=0;i<4;i++){
            this.mazzo.pesca(this.mano);
        }
    }
    /** 
     * setter del flag per il bottone pescaAvversario
     * @param pescaAvversarioFlag setta se il bottone è abilitato o meno
     */
    public void setPescaAvversarioFlag(boolean pescaAvversarioFlag) {
        pescaAvversario.setDisable(pescaAvversarioFlag);
    }
    /**
     * metodo toString
     * @return 
     */
    public String toString(){
        return nome.getText();
    }
    
    /**
     * metodo che controlla la vittoria. Se la mano è vuota crea una finestra di vittoria e stampa a terminale
     */
    public void checkWin(){
        if(mano.set.size()==0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"VITTORIA",ButtonType.OK);
            alert.setHeaderText(this.toString() + " ha vinto");
            Optional<ButtonType> result = alert.showAndWait();
            System.out.println(this.toString() + " ha vinto");
            if(result.isPresent() && result.get()==ButtonType.OK){ 
                System.exit(1);
            }
        }
    }
}
