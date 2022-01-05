//modèle qui correspond à peu près à ListActivityType
//collection et stockage des activités (donner accès aux données) > normalement dans une base de données
//stocker que des données valides

package be.technifutur.javaProjet.horaire;

import be.technifutur.javaProjet.activités.ActivityType;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class Horaire implements Serializable {

    private Map<String, Activity> horaire = new TreeMap<>();

    public Activity get(String name) {return horaire.get(name);}


    public void add(ActivityType type, String name, LocalDateTime start, LocalDateTime end) {
        Activity activity = new Activity(type, name, start, end);
        horaire.put(name, activity);
    }

    public void change(ActivityType type, String name, LocalDateTime start, LocalDateTime end) {
        Activity activity = new Activity(type, name, start, end);
        horaire.replace(name, activity);
    }

    public void remove(String name) {horaire.remove(name);}

    public void nameChange(String newName) {
        //horaire.replace(newName);
    }

    public void startChange() {
    }

    public void endChange() {
    }
}
