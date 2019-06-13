/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luglio2018observablelist;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 *
 * @author micky
 */
public class Luglio2018ObservableList extends Application {

    //bottoni di controllo
    private FlowPane controlliAlto;
    private Button add;
    private Button removeBottom;
    private Button removeTop;
    private Button printStack;
    //bottoni per il controllo della figura
    private HBox figure;
    private Button triangle;
    private Button hexagon;
    private Button circle;
    //figura
    private Node figura;
    //stack di figure
    private Stack stack;
    //contenitore per le componenti sopracitate
    private VBox controlli;

    public Luglio2018ObservableList() {
        
        add = new Button("add");
        add.setMinWidth(Commons.CELLSIZE*(Commons.NUM-1)/2);
        add.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (figura instanceof Figura) {
                    stack.add(((Figura) figura).getN());
                }
            }
        });
        removeBottom = new Button("remove Bottom");
        removeBottom.setMinWidth(Commons.CELLSIZE*(Commons.NUM-1)/2);
        removeBottom.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                stack.removeBottom();
            }
        });
        removeTop = new Button("remove Top");
        removeTop.setMinWidth(Commons.CELLSIZE*(Commons.NUM-1)/2);
        removeTop.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                stack.removeTop();
            }
        });
        printStack = new Button("print Stack");
        printStack.setMinWidth(Commons.CELLSIZE*(Commons.NUM-1)/2);
        printStack.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText(stack.toString());
                alert.show();
            }
        });
        circle = new Button("circle");
        circle.setMinWidth(Commons.CELLSIZE*(Commons.NUM-1)/3);
        circle.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                controlli.getChildren().clear();
                figura = new Figura(0);
                controlli.getChildren().addAll(controlliAlto,figura,figure);
            }
        });
        triangle = new Button("triangle");
        triangle.setMinWidth(Commons.CELLSIZE*(Commons.NUM-1)/3);
        triangle.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                 controlli.getChildren().clear();
                figura = new Figura(3);
                controlli.getChildren().addAll(controlliAlto,figura,figure);
            }
        });
        hexagon = new Button("hexagon");
        hexagon.setMinWidth(Commons.CELLSIZE*(Commons.NUM-1)/3);
        hexagon.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                 controlli.getChildren().clear();
                figura = new Figura(6);
                controlli.getChildren().addAll(controlliAlto,figura,figure);
            }
        });
        figura = new Cella();
        stack = new Stack();
        controlliAlto = new FlowPane(add, removeTop, removeBottom, printStack);
        controlliAlto.setPrefWidth(Commons.CELLSIZE*(Commons.NUM-1));
        figure = new HBox(circle, triangle, hexagon);
        controlli = new VBox(controlliAlto, figura, figure);
        controlli.setAlignment(Pos.CENTER);
    }

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        root.setLeft(stack);
        root.setCenter(controlli);
        Scene scene = new Scene(root, Commons.CELLSIZE * Commons.NUM, Commons.CELLSIZE * Commons.NUM);
        primaryStage.setTitle("Figure Geometriche");
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
