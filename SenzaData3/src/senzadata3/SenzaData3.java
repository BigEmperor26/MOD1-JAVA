/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senzadata3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 *
 * @author micky
 */
public class SENZADATA3 extends Application {

    private Tavola tavola;
    private Button cancella;
    private InputTest inputRadius;
    private InputTest inputN;
    private ColorPicker colorPicker;
    private Color currentColor;
    private DisegnaSeleziona disegnaseleziona;
    public SENZADATA3() {
        tavola = new Tavola(Integer.MAX_VALUE,Integer.MAX_VALUE);
        disegnaseleziona=new DisegnaSeleziona();
        //disegna
        tavola.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler() {
            @Override
            public void handle(Event event) {
                if (disegnaseleziona.getDisegnaFlag()) {
                    try{
                        Shape tmp;
                        tmp =  perfectPoly((int)inputN.getN(),2*inputRadius.getN());
                        tavola.add(tmp, ((MouseEvent) event).getX() - inputRadius.getN(), ((MouseEvent) event).getY() - inputRadius.getN());
                        
                        tmp.setFill(currentColor);
                        disegnaseleziona.setDisegnaFlag(false);
                    }catch(Exception ex){
                        System.out.println("Non hai inserito dati validi");
                    }
                }
            }
        });
        //seleziona
        tavola.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler() {
            @Override
            public void handle(Event event) {
                if (disegnaseleziona.getSelezionaFlag()) {
                    try{
                        Shape e;
                        e = (Shape) tavola.nearest(((MouseEvent) event).getX() - inputRadius.getN(), ((MouseEvent) event).getY() - inputRadius.getN() );
                        disegnaseleziona.setSelezionaFlag(false);
                        e.setFill(Color.color(Commons.rand.nextDouble(), Commons.rand.nextDouble(), Commons.rand.nextDouble()));
                    }catch(Exception ex){
                        System.out.println("Errore strano");
                    }
                }
            }
        });
        inputRadius = new InputTest("Raggio");
        inputN = new InputTest("N Lati");
        colorPicker = new ColorPicker();
        colorPicker.setOnAction( new EventHandler(){
            @Override
            public void handle(Event event) {
                currentColor = colorPicker.getValue();
                System.out.println(currentColor);
            }
        });
        cancella = new Button("Cancella");
        cancella.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                tavola.clear();
            }
        });
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setCenter(tavola);
        HBox bottomControls = new HBox(disegnaseleziona,cancella, inputRadius,inputN,colorPicker);
        root.setBottom(bottomControls);
        Scene scene = new Scene(root, Commons.SIZE, Commons.SIZE);
        primaryStage.setTitle("PAINT 2.0 XD");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * crea qualsiasi figura inscritta in un cerchio di raggio radius
     *
     * @param n numero di lati
     * @param radius raggio
     * @return p polygon
     */
    private Polygon perfectPoly(int n, double radius) {
        Polygon p = new Polygon();
        p.getPoints().addAll(gen_points(n, radius));
        return p;
    }

    /**
     * funzione che genera la successione di vertici
     *
     * @param n
     * @param radius
     * @return
     */
    private Double[] gen_points(int n, double radius) {
        Double[] punti = new Double[2 * n];
        double x_in = radius/2;
        double y_in = 0;
        double r = radius / 2;
        punti[0] = x_in;
        punti[1] = y_in;
        double angle = 2 * Math.PI / n;
        double curr_angle = 0;
        for (int i = 2; i < 2*n; i+= 2) {
            curr_angle += angle;
            double x = x_in + (r * Math.sin(curr_angle));
            double y = y_in + (r - r * Math.cos(curr_angle));
            punti[i] = x;
            punti[i + 1] = y;
        }
        return punti;
    }
}
