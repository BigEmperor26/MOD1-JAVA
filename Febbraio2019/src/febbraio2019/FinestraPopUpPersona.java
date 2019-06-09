/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package febbraio2019;

import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * classe che gestice la finestra di popup per persona
 * @author micky
 */
public class FinestraPopUpPersona extends FinestraPopUp{
    public FinestraPopUpPersona(String label1, String label2, String label3, Pannello pannello) {
        super(label1, label2, label3, pannello);
            control.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                String tmp1 = field1.getText();
                String tmp2= field2.getText();
                Integer tmp3=null;
                try{
                    tmp3 = Integer.parseInt(field3.getText());
                }catch(NumberFormatException ex){
                
                }
                if(tmp1=="" || tmp2 =="" || tmp3==null){
                    System.out.println("Errore, dati non validi");
                }else{
                    if(pannelloassociato.add( new Persona(tmp1,tmp2,tmp3) )){
                        questo.close();
                        field1.clear(); field2.clear(); field3.clear();
                    }else{
                        System.out.println("Errore, elemento già presente");
                    }
                }
            }
        });
    }
    
}
