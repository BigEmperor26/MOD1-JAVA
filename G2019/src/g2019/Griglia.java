/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g2019;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

/**
 * classe che gestisce la griglia con le tessere
 * @author micky
 */
public class Griglia extends GridPane{
    private G2019 gioco;
    private int n;
    public Griglia(int n,G2019 gioco){
        this.n=n;
        this.gioco=gioco;
        int xVittoria;
        int yVittoria;
        int xPerdita;
        int yPerdita;
        do{
            xVittoria = Commons.rand.nextInt(n);
            yVittoria = Commons.rand.nextInt(n);
            xPerdita = Commons.rand.nextInt(n);
            yPerdita = Commons.rand.nextInt(n);
        }while(xVittoria==xPerdita && yVittoria==yPerdita);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Tessera nodo;
                nodo = new S(Commons.GAMESIZE/n,Commons.GAMESIZE/n,gioco);
                if(j==xVittoria && i==yVittoria){
                    nodo = new V(Commons.GAMESIZE/n,Commons.GAMESIZE/n,gioco);
                }
                if(j==xPerdita && i==yPerdita){
                    nodo = new P(Commons.GAMESIZE/n,Commons.GAMESIZE/n,gioco);
                }
                this.add(nodo,j, i);
                System.out.print(nodo);
            }
            System.out.println("");
        }
    }
    /**
     * ottiene la stringa degli elementi Tessera contenuti nel gridpane
     * @return 
     */
    public String toString(){
        String tmp="";
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Tessera nodo;
                nodo = (Tessera)getItemAt(j,i);
                tmp+=nodo;
            }
            tmp+="\n";
        }
        return tmp;
    }
    /**
    * meotodo ritira l'elemento in posizione column e row
    * @param column
    * @param row
    * @return 
    */
    public Node getItemAt(int column, int row){
        for(Node e: this.getChildren()){
            if(e instanceof Tessera){
                try{
                    if(GridPane.getColumnIndex(e)==column && GridPane.getRowIndex(e)==row ){
                        return e;
                    }
                }catch(NullPointerException ex){}
            }
        }
        return null;
    }
}
