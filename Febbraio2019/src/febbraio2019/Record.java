/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package febbraio2019;

import java.util.Comparator;
import java.util.Objects;

/**
 * classe record, Viene usata sia per Persona e Automobile. 
 * @author micky
 */
public abstract class Record {
    private String field1;
    private String field2;
    private Integer field3;
    /**
     * costruttore
     * @param field1 primo campo
     * @param field2 secondo campo
     * @param field3 terzo campo
     */
    public Record(String field1,String field2,Integer field3){
        this.field1=field1;
        this.field2=field2;
        this.field3=field3;
    } 
    /**
     * hashcode
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.field1);
        hash = 37 * hash + Objects.hashCode(this.field2);
        hash = 37 * hash + Objects.hashCode(this.field3);
        return hash;
    }

    /**
     * equals
     * @param obj
     * @return true se hanno tutti e tre i campi uguali. false altrimenti
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Record other = (Record) obj;
        if (!Objects.equals(this.field1, other.field1)) {
            return false;
        }
        if (!Objects.equals(this.field2, other.field2)) {
            return false;
        }
        if (!Objects.equals(this.field3, other.field3)) {
            return false;
        }
        return true;
    }
    /**
     * metodo toString
     * @return 
     */
    @Override
    public String toString() {
        return field1 + " " + field2 + " " + field3 + "\n";
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public Integer getField3() {
        return field3;
    }

}
