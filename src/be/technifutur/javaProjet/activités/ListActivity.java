package be.technifutur.javaProjet.activités;

import java.util.Map;
import java.util.TreeMap;

public class ListActivity{

    Map<String, ActivityType> map = new TreeMap<>();

    public ActivityType addActivityType(String name, boolean registrationRequired){
        ActivityType activityType = new ActivityType(name, registrationRequired);
        map.put(activityType.getName(), activityType);
        activityType.setName();
        activityType.isRegistrationRequired();
        return activityType;
    }

    public ActivityType getName(String name){
        return map.get(name);
    }

    public ActivityType remove(String name){
        return map.get(name);
    }
}
