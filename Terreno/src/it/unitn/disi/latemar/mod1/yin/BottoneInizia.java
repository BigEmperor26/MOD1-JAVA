/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.latemar.mod1.yin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *  classe del bottone avvia
 * @author micky
 */
public class BottoneInizia extends Button{
    private Stage controlWindow;
    private Scene scena;
    private BorderPane controlButtons;
    private ControlButton su;
    private ControlButton destra;
    private ControlButton giu;
    private ControlButton sinistra;
    private ControlButton random;
    /*
    private ControlButton start;
    private ControlButton stop;*/
    private Griglia griglia;
    /**
     * event handler del bottone avvia. Se premuto apre una nuova finestra contenente i bottoni
     */
    private class HandlerAvvia implements EventHandler{
        @Override
        public void handle(Event event) {
            controlWindow = new Stage();
            controlWindow.setTitle(Commons.CONTROLWINDOWTITLE);
            controlButtons = new BorderPane();
            su = new ControlButton(Commons.LABELSU);
            su.setOnAction(new EventHandler(){
                @Override
                public void handle(Event event) {
                    griglia.moveAll(0);
                }
            });
            destra = new ControlButton(Commons.LABELDESTRA);
            destra.setOnAction(new EventHandler(){
                @Override
                public void handle(Event event) {
                    griglia.moveAll(1);
                }
            });
            giu = new ControlButton(Commons.LABELGIU);
            giu.setOnAction(new EventHandler(){
                @Override
                public void handle(Event event) {
                    griglia.moveAll(2);
                }
            });
            sinistra = new ControlButton(Commons.LABELSINISTRA);
            sinistra.setOnAction(new EventHandler(){
                @Override
                public void handle(Event event) {
                    griglia.moveAll(3);
                }
            });
            random = new ControlButton(Commons.LABELRANDOM);
            random.setOnAction(new EventHandler(){
                @Override
                public void handle(Event event) {
                    griglia.randomMoveAll();
                }
            });
            /*                    
            start = new ControlButton(Commons.LABELSTART);
            stop = new ControlButton(Commons.LABELSTOP);*/
            controlButtons.setTop(su);
            BorderPane.setAlignment(su, Pos.TOP_CENTER);
            controlButtons.setRight(destra);
            BorderPane.setAlignment(destra, Pos.CENTER_RIGHT);
            controlButtons.setBottom(giu);
            BorderPane.setAlignment(giu,Pos.BOTTOM_CENTER );
            controlButtons.setLeft(sinistra);
            BorderPane.setAlignment(sinistra, Pos.CENTER_RIGHT);
            controlButtons.setCenter(random);
            BorderPane.setAlignment(random, Pos.CENTER);
            scena = new Scene(controlButtons,Commons.CONTROLLERWIDTH,Commons.CONTROLLERHEIGHT);
            controlWindow.setScene(scena);
            controlWindow.show();
        }
    
    }
    /**
     * costruttore del bottone avvia
     * @param testo testo del bottone
     */
    public BottoneInizia(String testo,Griglia griglia) {
        super(testo);
        this.griglia=griglia;
        this.addEventHandler(MouseEvent.MOUSE_CLICKED,new HandlerAvvia());
    }
    
}
