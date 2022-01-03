//modèle

package be.technifutur.javaProjet.activités;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class ListActivity implements Serializable {

    public Map<String, ActivityType> map = new TreeMap<>();

    public ActivityType addActivityType(String name, boolean registrationRequired){
        ActivityType activityType = new ActivityType(name, registrationRequired);
        map.put(activityType.getName(), activityType);
        return activityType;
    }

    public ActivityType get(String name){
        return map.get(name);
    }

    public ActivityType remove(String name){
        return map.remove(name);
    }

}
