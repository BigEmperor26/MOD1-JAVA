/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luglio2016;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * classe che gestisce la finestra con i bottoni di controllo
 *
 * @author micky
 */
public class Controlli extends Stage {

    private Button primaGiornata;
    private Button secondaGiornata;
    private Button terzaGiornata;
    private Torneo torneo;

    public Controlli(Torneo torneo) {
        super();
        this.torneo = torneo;
        primaGiornata = new Button("1 Giornata");
        primaGiornata.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                torneo.gioca(1);
                primaGiornata.setDisable(true);
                secondaGiornata.setDisable(false);
            }
        });
        secondaGiornata = new Button("2 Giornata");
        secondaGiornata.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                torneo.gioca(2);
                secondaGiornata.setDisable(true);
                terzaGiornata.setDisable(false);
            }
        });
        terzaGiornata = new Button("3 Giornata");
        terzaGiornata.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                torneo.gioca(3);
                terzaGiornata.setDisable(true);
            }
        });

        primaGiornata.setDisable(false);
        secondaGiornata.setDisable(true);
        terzaGiornata.setDisable(true);
        FlowPane c = new FlowPane(primaGiornata, secondaGiornata, terzaGiornata);
        Scene scena = new Scene(c, 300, 100);
        this.setScene(scena);
        this.show();
    }
}
