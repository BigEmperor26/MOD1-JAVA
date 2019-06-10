/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giugno2018;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author micky
 */
public class Giugno2018 extends Application {

    private Button clear;
    private Button move;
    private Button reset;
    private Button close;
    private Testo from;
    private Testo to;

    private Palo p1;
    private Palo p2;
    private Palo p3;

    private Text messaggio;
    private Stage finestra = new Stage();

    public Giugno2018() {
        from = new Testo("from");
        to = new Testo("to");

        messaggio = new Text("");
        StackPane ground = new StackPane(messaggio);
        finestra.setScene(new Scene(ground, Commons.MESSAGEWIDTH, Commons.MESSAGEHEIGHT));
        clear = new Button("clear");
        clear.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                from.setPalo(null);
                to.setPalo(null);
            }
        });
        reset = new Button("reset");
        move = new Button("move");
        move.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (from.isSetted() && to.isSetted()) {
                    if (to.getPalo().moveAllowed(from.getPalo().getLast())) {
                        Disco spostamento = from.getPalo().remove();
                        to.getPalo().add(spostamento);
                        clear.fireEvent(new ActionEvent());
                    } else {
                        messaggio.setText("impossibile appoggiare un disco su uno più piccolo");
                        finestra.show();
                        close.setDisable(false);
                    }
                } else {
                    messaggio.setText("pali di partenza e arrivo non definiti");
                    finestra.show();
                    close.setDisable(false);
                }
            }
        });
        close = new Button("close");
        close.setDisable(true);
        close.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                finestra.close();
                close.setDisable(true);
            }
        });

    }

    @Override
    public void start(Stage primaryStage) {
        //set dei tre pali. Viene fatto nello start in modo che il pulsante reset possa ripristare la situazione iniziale
        p1 = new Palo("p1",this.from, this.to, messaggio, finestra,close);
        p1.add(new Disco(4));
        p1.add(new Disco(3));
        p1.add(new Disco(2));
        p1.add(new Disco(1));
        p2 = new Palo("p2",this.from, this.to, messaggio, finestra,close);
        p3 = new Palo("p3",this.from, this.to, messaggio, finestra,close);

        // set dei bordi
        BorderPane root = new BorderPane();
        HBox top = new HBox(from, to, clear);
        clear.setAlignment(Pos.CENTER);
        top.setPrefWidth(Commons.WIDTH);
        root.setTop(top);
        root.setLeft(close);
        BorderPane.setAlignment(close, Pos.CENTER);
        root.setRight(reset);
        BorderPane.setAlignment(reset, Pos.CENTER);
        root.setBottom(move);
        BorderPane.setAlignment(move, Pos.CENTER);

        // sel del center con i 3 pali
        StackPane center = new StackPane();
        center.setMaxHeight(Commons.HANOIHEIGHT);
        center.setMaxWidth(Commons.HANOIWIDTH);
        Rectangle sfondo = new Rectangle(Commons.HANOIHEIGHT, Commons.HANOIWIDTH);
        sfondo.setFill(Color.BEIGE);
        HBox pali = new HBox( p1, p2, p3);
        pali.setAlignment(Pos.CENTER);
        pali.setMaxWidth(Commons.HANOIWIDTH);
        center.getChildren().addAll(sfondo, pali);
        root.setCenter(center);
        BorderPane.setAlignment(center, Pos.CENTER);
        // set dello handler del pulsante reset
        reset.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                start(primaryStage);
            }
        });
        //
        Scene scene = new Scene(root, Commons.WIDTH, Commons.HEIGHT);
        primaryStage.setTitle("HANOI");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
