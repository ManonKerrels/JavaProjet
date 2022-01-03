package be.technifutur.javaProjet.activités;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Activity implements Serializable {

    public Map<String, ActivityType> map = new TreeMap<>();

    public LocalDateTime startActivity(LocalDateTime startActivity){
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-M-yyyy");
        String formattedDate = date.format(formatter);
        LocalDateTime parsedDate = LocalDateTime.parse(formattedDate, formatter);
        return parsedDate;
    }

    public LocalDateTime endActivity(LocalDateTime endActivity){
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-M-yyyy");
        String formattedDate = date.format(formatter);
        LocalDateTime parsedDate = LocalDateTime.parse(formattedDate, formatter);
        return parsedDate;
    }

    public String nameActivity(){
        String nameActivity = new String();
        return nameActivity;
    }

    public ActivityType typeActivity(String name, boolean registrationRequired){
        ActivityType activityType = new ActivityType(name, registrationRequired);
        map.put(activityType.getName(), activityType);
        return activityType;
    }
}
