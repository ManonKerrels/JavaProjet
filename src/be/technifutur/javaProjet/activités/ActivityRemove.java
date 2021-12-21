package be.technifutur.javaProjet.activités;

import java.util.concurrent.Callable;

public class ActivityRemove implements Callable {
    private ActivityVue vue;
    private ListActivity model;

    public ActivityType call() {
        String efface = vue.removeActivityType();

        if (model.remove(efface) != null){
            vue.removeActivityType();
            model.remove(efface);
        }
        return null;
    }
}
