package be.technifutur.javaProjet.horaire;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class ListHoraire implements Serializable {

    public Map<String, HoraireType> map = new TreeMap<>();

    public HoraireType addHoraireType(String name, boolean registrationRequired){
        HoraireType horaireType = new HoraireType(name, registrationRequired);
        map.put(horaireType.getName(), horaireType);
        return horaireType;
    }

    public HoraireType get(String name){
        return map.get(name);
    }

    public HoraireType remove(String name){
        return map.remove(name);
    }
}
