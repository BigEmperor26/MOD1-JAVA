/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package febbraio2019;

import java.util.Comparator;

/**
 * classe che serve a comparare i record secondo il loro field3(Anno di nascita o Prezzo)
 * @author micky
 */
    public class CompareRecordField3 implements Comparator{
        /**
        * metodo compareto sul primo campo, ordine alfabetico
        * @param o oggetto da comparare
        * @return 
        */
        @Override
        public int compare(Object o1, Object o2){
            return ((Record)o1).getField3().compareTo(((Record)o2).getField3());
        }
    }
