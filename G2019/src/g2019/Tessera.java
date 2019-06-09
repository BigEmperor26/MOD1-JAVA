package g2019;


import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * classe che gestisce la tessera
 * @author micky
 */
public abstract class Tessera extends StackPane{
    protected G2019 gioco;
    protected Alert finestra;
    protected Text testo;
    protected Rectangle rect;
    protected String tipo;
    /**
     * event handler per il click del mouse
     */
    private class PressedHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            if(!testo.isVisible()){
                scopri();
            }else{
                nascondi();
            }
        }
    }
    public Tessera(int width, int height,G2019 gioco){
        super();
        rect= new Rectangle(width,height);
        rect.setFill(Color.YELLOW);
        rect.setStroke(Color.BLACK);
        testo=new Text();
        this.getChildren().addAll(rect,testo);
        this.gioco=gioco;
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new PressedHandler());
    }
    public abstract void scopri();
    public abstract void nascondi();
    /**
     * metodo che apre una finestra di vittoria. Chiamato da S e da V
     */
    public void vinci(){
        finestra = new Alert(Alert.AlertType.INFORMATION);
        finestra.setWidth(Commons.GAMESIZE/4);
        finestra.setWidth(Commons.GAMESIZE/4);
        finestra.setHeaderText(Commons.VINTO);
        System.out.println(this + " " + Commons.VINTO);
        Optional<ButtonType> result = finestra.showAndWait();
        if(result.isPresent()&&result.get()==ButtonType.OK){
            finestra.close();
            gioco.partiteVinte.add(1);
            gioco.reset.fireEvent(new ActionEvent());
        }
    }
    /**
     * metodo che apre la finestra di sconfitta. Chiamato da P
     */
    public void perdi(){
        finestra = new Alert(Alert.AlertType.INFORMATION);
        finestra.setWidth(Commons.GAMESIZE/4);
        finestra.setWidth(Commons.GAMESIZE/4);
  
        finestra.setContentText(Commons.PERSO);
        System.out.println(this + " " + Commons.PERSO);
        Optional<ButtonType> result = finestra.showAndWait();
        if(result.isPresent()&&result.get()==ButtonType.OK){
            System.exit(1);
        }
    }
    public String toString(){
        return tipo;
    }
}
