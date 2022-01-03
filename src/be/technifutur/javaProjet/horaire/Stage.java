package be.technifutur.javaProjet.horaire;

import be.technifutur.javaProjet.activités.ActivityType;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Stage implements Serializable {
    public LocalDateTime start;
    public LocalDateTime end;
    public String name;
    public ActivityType type;
}
