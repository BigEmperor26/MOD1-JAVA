/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giugno2019;

import java.util.Optional;
import java.util.Random;
import javafx.scene.control.TextInputDialog;

/**
 *
 * @author micky
 */
/**
 * dimensione della tile
 *
 * @author micky
 */
public class Commons {

    /**
     * dimensione di una tile
     */
    public final static int CELLSIZE = 50;
    /**
     * generatore di numeri casuale
     */
    public final static Random rand = new Random(System.currentTimeMillis());

    public static String getResponse() {
        TextInputDialog dialog = new TextInputDialog();
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
    /**
     * dimensioni della finestra
     */
    public final static int SCENEWIDTH = 800;
    /**
     * dimensioni della finestra
     */
    public final static int SCENEHEIGHT = 800;
}
