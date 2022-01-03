package be.technifutur.javaProjet.activités;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Activity implements Serializable {

    public Map<String, ActivityType> map = new TreeMap<>();

    public LocalDateTime startActivity(Date date, Time time){
        Date jour = new Date;
        Time heure = new Time;
        map.put(activity);
        return null;
    }

    public LocalDateTime endActivity(Date date, Time time){

        return null;
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
