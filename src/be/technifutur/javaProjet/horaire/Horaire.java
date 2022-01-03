package be.technifutur.javaProjet.horaire;

import be.technifutur.javaProjet.activités.ActivityType;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class Horaire implements Serializable {

    public Map<String, Stage> map = new TreeMap<>();

    public Stage addStage(LocalDateTime start, LocalDateTime end, String name, ActivityType type){
        Stage stage = new Stage(start, end, name, type);
        map.put(stage.getName(), stage);
        return stage;
    }
}
