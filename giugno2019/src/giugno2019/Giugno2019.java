/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giugno2019;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author micky
 */
public class Giugno2019 extends Application {

    private BorderPane root;
    private Button riordina;
    private Stack stack;
    private ParcheggioTile parcheggio;

    public Giugno2019() {
        root = new BorderPane();
        stack = new Stack();
        int dimensione = -1;
        do {
            try {
                dimensione = Integer.parseInt(Commons.getResponse());
            } catch (NumberFormatException ex) {
            }
        } while (dimensione < 3 || dimensione > 11);
        while (stack.getSize() < dimensione) {
            Tile e;
            if (Commons.rand.nextBoolean()) {
                e = new SquareTile(Commons.rand.nextInt(10), Color.color(Commons.rand.nextDouble(), Commons.rand.nextDouble(), Commons.rand.nextDouble()));
            } else {
                e = new CircleTile(Commons.rand.nextInt(10), Color.color(Commons.rand.nextDouble(), Commons.rand.nextDouble(), Commons.rand.nextDouble()));
            }
            stack.add(e);
        }
        parcheggio = new ParcheggioTile();
        riordina = new Button("Riordina");
        riordina.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                stack.ordina();
            }
        });
        root.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler() {
            @Override
            public void handle(Event event) {
                if (((KeyEvent) event).getCode() == KeyCode.R) {
                    riordina.fireEvent(new ActionEvent());
                }
            }
        });
        root.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler() {
            @Override
            public void handle(Event event) {
                if (stack.getRimossi() != null) {
                    parcheggio.add(stack.getRimossi());
                    stack.setRimossi();
                }
            }
        });
        root.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler() {
            @Override
            public void handle(Event event) {
                stack.KeyPressed((KeyEvent) event);
            }
        });
        root.setMaxSize(Commons.SCENEWIDTH, Commons.SCENEHEIGHT);
        root.setMinSize(Commons.SCENEWIDTH, Commons.SCENEHEIGHT);
        root.setTop(riordina);
        root.setLeft(stack);
        BorderPane.setAlignment(stack, Pos.CENTER);
        stack.setAlignment(Pos.CENTER);
        root.setBottom(parcheggio);
        BorderPane.setAlignment(parcheggio, Pos.CENTER);
        parcheggio.setAlignment(Pos.CENTER);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(root, 1000, 1000);

        primaryStage.setTitle("Gioco delle Tile");
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
