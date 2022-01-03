//modèle qui correspond à peu près à ListActivityType

package be.technifutur.javaProjet.horaire;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class Horaire implements Serializable {

    public Map<String, Stage> map = new TreeMap<>();

    public String get(String name) {
        return null;
    }


}
