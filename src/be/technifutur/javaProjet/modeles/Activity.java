//modèle, stockage de 4 infos

package be.technifutur.javaProjet.modeles;

import be.technifutur.javaProjet.factory.ActivityType;

import java.time.LocalDateTime;

public class Activity {

    private ActivityType type;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;

    public Activity(ActivityType type, String name, LocalDateTime start, LocalDateTime end) {
        this.type = type;
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public LocalDateTime getStart() {return start;}
    public void setStart(LocalDateTime start) {this.start = start;}

    public LocalDateTime getEnd() {return end;}
    public ActivityType getType() {return type;}


    @Override
    public String toString() {
        return "Activity{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

}
