//modèle qui correspond à peu près à ListActivityType
//collection et stockage des activités (donner accès aux données) > normalement dans une base de données
//stocker que des données valides

package be.technifutur.javaProjet.modeles;

import be.technifutur.javaProjet.factory.ActivityType;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class Horaire implements Serializable {

    private Map<String, Activity> horaire = new TreeMap<>();
    private String name;



    public Activity get(String oldName) {return horaire.get(oldName.toUpperCase());}
    public void set(String name) {this.name = name;}


    public Activity add(ActivityType type, String name, LocalDateTime start, LocalDateTime end) {
        Activity activity = new Activity(type, name, start, end);
        horaire.put(name.toUpperCase(), activity);
        return activity;
    }

    /*public void change(ActivityType type, String name, LocalDateTime start, LocalDateTime end) {
        Activity activity = new Activity(type, name, start, end);
        horaire.replace(name, activity);
    }*/

    public void remove(String name) {horaire.remove(name.toUpperCase());}

    public CharSequence startChange() {
        LocalDateTime localDateTime;
        return null;
    }

    public CharSequence endChange() {
        return null;
    }


}
