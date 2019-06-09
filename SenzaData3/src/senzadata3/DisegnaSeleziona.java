/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senzadata3;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;

/**
 * classe che gestisce i bottoni Disegna e Seleziona. 
 * @author micky
 */
public class DisegnaSeleziona extends HBox{
    private Button seleziona;
    private Button disegna;
    private boolean disegnaFlag;
    private boolean selezionaFlag;
    public DisegnaSeleziona(){
        disegnaFlag=false; selezionaFlag=false;
        seleziona=new Button("Seleziona");
        disegna= new Button("Disegna");
        this.getChildren().addAll(disegna,seleziona);
        disegna.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                setDisegnaFlag(true);
            }
        });
        seleziona.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                setSelezionaFlag(true);
            }
        });
    }
    /**
     * ritorna se il bottone disegna è stato premuto
     * @return 
     */
    public boolean getDisegnaFlag(){
        return disegnaFlag;
    }
    
    /**
     * ritorna se il bottone seleziona è stato premuto
     * @return 
     */
    public boolean getSelezionaFlag(){
        return selezionaFlag;
    }
    /**
     * setta il flag seleziona. Se flag seleziona = true, allora flag disegna viene impostato a false 
     * @param flag 
     */
    public void setSelezionaFlag(boolean flag){
        selezionaFlag=flag;
        if(flag){disegnaFlag=false;}
    }
    
    /**
     * setta il flag disegna. Se flag disegna = true, allora flag seleziona viene impostato a false 
     * @param flag 
     */
    public void setDisegnaFlag(boolean flag){
        disegnaFlag=flag;
        if(flag){selezionaFlag=false;}
    }
}
