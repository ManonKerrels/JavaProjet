package be.technifutur.laboJava.serialization;

import be.technifutur.javaProjet.factory.ListActivityType;
import be.technifutur.javaProjet.modeles.Horaire;

import java.io.*;

public class DataType implements Serializable {
    private final ListActivityType map;
    private final Horaire horaire;


    public DataType(){
        this.map = new ListActivityType();
        this.horaire = new Horaire();
    }


    public ListActivityType getListActivityType() {
        return map;
    }

    public Horaire getHoraire() {
        return horaire;
    }

}