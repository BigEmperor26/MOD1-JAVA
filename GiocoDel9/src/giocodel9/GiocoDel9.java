/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giocodel9;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Classe principale che gestice il gioco
 * @author micky
 */
public class GiocoDel9 extends Application {
    private Griglia root;
    /**Listener che si occupa di fireEvents per i tasti premuti da tastiera**/
    private class Listener implements EventHandler{
        @Override
        public void handle(Event event) {
            String key = ((KeyEvent)event).getCharacter();     
            System.out.println("Key pressed"+key);
            Casella tmp;
            switch(key){
                //nota fireEvent ha bisogno di un event dello stesso tipo dell'eventhandler associato. Necessarie ricerche su come creare un MouseEvent
                case "0" : tmp=root.getElement(0);if(tmp!=null){System.out.println(tmp); tmp.fireEvent(new ActionEvent());} break;
                case "1" : tmp=root.getElement(1);if(tmp!=null){System.out.println(tmp); tmp.fireEvent(new ActionEvent());} break;
                case "2" : tmp=root.getElement(2);if(tmp!=null){System.out.println(tmp); tmp.fireEvent(new ActionEvent());} break;
                case "3" : tmp=root.getElement(3);if(tmp!=null){System.out.println(tmp); tmp.fireEvent(new ActionEvent());} break;
                case "4" : tmp=root.getElement(4);if(tmp!=null){System.out.println(tmp); tmp.fireEvent(new ActionEvent());} break;
                case "5" : tmp=root.getElement(5);if(tmp!=null){System.out.println(tmp); tmp.fireEvent(new ActionEvent());} break;
                case "6" : tmp=root.getElement(6);if(tmp!=null){System.out.println(tmp); tmp.fireEvent(new ActionEvent());} break;
                case "7" : tmp=root.getElement(7);if(tmp!=null){System.out.println(tmp); tmp.fireEvent(new ActionEvent());} break;
                case "8" : tmp=root.getElement(8);if(tmp!=null){System.out.println(tmp); tmp.fireEvent(new ActionEvent());} break;
            }
        }
    }
    /**Costruttore del gioco**/
    public GiocoDel9(){
        root=new Griglia();  
    }
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(root, Commons.SCENEHEIGHT, Commons.SCENEWIDTH);
        primaryStage.setTitle(Commons.TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
        scene.addEventHandler(KeyEvent.KEY_TYPED, new Listener());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GiocoDel9 game=new GiocoDel9();
        launch(args);
    }
    
}
