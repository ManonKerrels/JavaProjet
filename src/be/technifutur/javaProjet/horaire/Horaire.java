package be.technifutur.javaProjet.horaire;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class Horaire implements Serializable {

    public Map<String, Stage> map = new TreeMap<>();

    /*public Stage addHoraireType(String name, boolean registrationRequired){
        Stage horaireType = new Stage(name, registrationRequired);
        map.put(horaireType.getName(), horaireType);
        return horaireType;
    }*/

    public Stage get(String name){
        return map.get(name);
    }

    public Stage remove(String name){
        return map.remove(name);
    }
}
