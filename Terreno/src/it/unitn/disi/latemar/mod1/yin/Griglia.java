/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.latemar.mod1.yin;

import java.util.ArrayList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *classe della griglia
 * @author michele.yin
 */
public class Griglia extends GridPane{
    private Gioco gioco;
    /**
     * costruttore della griglia quadrata di gioco
     * @param k dimensione della tabella
     * @param gioco riferimento al gioco
     */
    public Griglia(int k,Gioco gioco){
        this.gioco=gioco;
        for(int i=0;i<k;i++){
            for(int j=0;j<k;j++){
                Terreno tmp;
                if(i==0||i==k-1||j==0||j==k-1){
                    tmp=new Strada(gioco);
                }else{
                    tmp=new Prato(gioco);
                }
                this.add(tmp, i, j);
            }
        }
    }
    /**
     * metodo che sostituisce Prato e Strada
     * @param changed il terreno da modificare
     */
    public boolean switchStradaPrato(Terreno changed){
        System.out.println(changed);
        int y; int x;
        y = GridPane.getRowIndex(changed);
        x = GridPane.getColumnIndex(changed);
        this.getChildren().remove(changed);
        if(changed instanceof Strada){
            this.add(new Prato(gioco), x, y);
            return true;
        }
        if(changed instanceof Prato){
            this.add(new Strada(gioco), x, y);
            return true;
        }
        return false;
    }
    /**
     * funzione che sposta tutte le auto in una direzione
     * @param direction 0 = su , 1 = destra , 2 = giu, 3 = sinistra 
     */
    public void moveAll(int direction){
        ArrayList<Auto> autoDaSpostare = new ArrayList<>();
        for(Node e : this.getChildren()){
            if(e instanceof Strada){
                if( ((Strada) e).hasAuto() ){
                    autoDaSpostare.add(((Strada)e).getAuto() );
                }
            }
        }
        for(Auto e:autoDaSpostare){
            this.move(e,direction);
        }
        this.collisionDetector();
    }
     /**
     * funzione che sposta tutte le auto in direzione casuale
     */
    public void randomMoveAll(){
        ArrayList<Auto> autoDaSpostare = new ArrayList<Auto>();
        for(Node e : this.getChildren()){
            if(e instanceof Strada){
                if( ((Strada) e).hasAuto() ){
                    autoDaSpostare.add(((Strada)e).getAuto() );
                }
            }
        }
        for(Auto e:autoDaSpostare){
            int direction = Commons.rand.nextInt(4);
            this.move(e,direction);
            System.out.print("Auto n. " + e.getIdAuto() +" - direzione ");
            switch(direction){
                case 0 : System.out.println(Commons.LABELSU); break;
                case 1 : System.out.println(Commons.LABELDESTRA); break;
                case 2 : System.out.println(Commons.LABELGIU); break;
                case 3 : System.out.println(Commons.LABELSINISTRA); break;
            }
            if(moveAllowed(e,direction)){
                System.out.print(" - mossa permessa");
            }else{
                System.out.print(" - mossa non permessa");
            }
        }
        this.collisionDetector();
    }
    /**
     * controlla se ci sono state collisioni. Nel caso apre una finestra e il gioco termina
     */
    public void collisionDetector(){
        //check if collision was detected
        for(Node e : this.getChildren()){
            if(e instanceof Strada){
                if(((Strada)e).collisionDetected()){
                    BorderPane finestra = new BorderPane();
                    Text testo = new Text(Commons.GAMEOVERTEXT);
                    Button ok = new Button("ok");
                    ok.setOnAction( new EventHandler(){
                        @Override
                        public void handle(Event event) {
                            System.exit(1);
                        }
                    
                    });
                    finestra.setCenter(testo);
                    finestra.setRight(ok);
                    BorderPane.setAlignment(ok, Pos.CENTER_RIGHT);
                    Scene alertMessage = new Scene(finestra,Commons.CONTROLLERWIDTH,Commons.CONTROLLERHEIGHT);
                    Stage gameOver = new Stage();
                    gameOver.setTitle(Commons.GAMEOVERTITLE);
                    gameOver.setScene(alertMessage);
                    gameOver.show();
                    
                }
            }
        }
    }
    /**
     * funzione che sposta la singola auto in una direzione 
     * @param e auto da spostare
     * @param direction 0 = su , 1 = destra , 2 = giu, 3 = sinistra
     */
    public void move(Auto e , int direction){
        if(moveAllowed(e,direction)){
            int x = GridPane.getColumnIndex(e.getParent());
            int y = GridPane.getRowIndex(e.getParent());
            switch(direction){
                case 0 : y= y-1; break;
                case 1 : x= x+1; break;
                case 2 : y= y+1; break;
                case 3 : x= x-1; break;
            }
            // sono sicuro che lo spostamento è permesso adesso. dunque non ci saranno cast error
            Strada spostamento = (Strada)this.getItemAt(x, y);
            ((Strada)e.getParent()).removeAuto(e);
            spostamento.addAuto(e);
        }
        
    }
    /**
     * controlla se l'auto può spostarsi in quella direzione. Il crash non è gestito da questa funzione
     * @param e auto da spostare 
     * @param direction direzione 0 su 1 destra 2 giu 3 sinistra
     * @return true se la mossa è permessa. false altrimenti 
     */
    private boolean moveAllowed(Auto e, int direction){
        int x = GridPane.getColumnIndex(e.getParent());
        int y = GridPane.getRowIndex(e.getParent());
        switch(direction){
            case 0 : y= y-1; break;
            case 1 : x= x+1; break;
            case 2 : y= y+1; break;
            case 3 : x= x-1; break;
        }
        Terreno spostamento = (Terreno)this.getItemAt(x, y);
        if( spostamento instanceof Strada) {
            return true;
        }else{ 
            return false;
        }
    }
    /**
     * ottengo il Terreno alla posizione column e row. Null se non vi è nulla
     * @param column indice di colonna
     * @param row indice di riga
     * @return 
     */
    private Node getItemAt (int column, int row){
        for (Node e : this.getChildren()) {
            try{
                if( GridPane.getRowIndex(e) == row && GridPane.getColumnIndex(e) == column){
                    return e;
                }
            }catch(NullPointerException ex){
            }
        }
        return null;
    }
    /**
     * funzione che scambia due celle in un gridpane. 
     * @param a 
     * @param b
     * @return 
     */
    /*
    private void swap2Cells(Node a, Node b){
        System.out.println("Swap Called on " + a + b);
        int xa = GridPane.getColumnIndex(a);
        int ya = GridPane.getRowIndex(a);
        int xb = GridPane.getColumnIndex(b);
        int yb = GridPane.getRowIndex(b);
        GridPane.setColumnIndex(a,xb);
        GridPane.setRowIndex(a,yb);
        GridPane.setColumnIndex(b,xa);
        GridPane.setRowIndex(b,yb);
        this.getChildren().remove(a);
        this.getChildren().remove(b);
        this.add(a, xb, yb);
        this.add(b, xa, ya);
    }*/
    
}
