package be.technifutur.javaProjet.horaire;

import be.technifutur.javaProjet.activités.ActivityType;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Stage implements Serializable {

    //4 attributes des stages
    public LocalDateTime start;
    public LocalDateTime end;
    public String name;
    public ActivityType type;


    //constructeurs qui instanciatient ces 4 attributs
    public Stage(LocalDateTime start, LocalDateTime end, String name, ActivityType type){
        this.start = start;
        this.end = end;
        this.name = name;
        this.type = type;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public ActivityType getType() {return type;}
    public void setType(ActivityType type) {this.type = type;}

    public LocalDateTime getStart(){return start;}
    public void setStart(LocalDateTime start) {this.start = start;}

    public LocalDateTime getEnd() {return end;}
    public void setEnd(LocalDateTime end) {this.end = end;}
}
