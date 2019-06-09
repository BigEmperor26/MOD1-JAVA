/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g2019;

import java.util.Optional;
import javafx.scene.control.TextInputDialog;

/**
 * classe che gestisce l'input ad inizio della partita
 * @author micky
 */
public class InputDialog {
    static String getResponse(){
        TextInputDialog dialog= new TextInputDialog();
        dialog.setHeaderText("Dimensione della griglia?");
        Optional<String> result = dialog.showAndWait();
        if(result.isPresent()) return result.get();
        return null;
    }
}
