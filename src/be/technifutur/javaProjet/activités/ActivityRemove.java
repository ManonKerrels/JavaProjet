package be.technifutur.javaProjet.activités;

import java.util.concurrent.Callable;

public class ActivityRemove implements Callable {
    private ActivityVue vue;
    private ListActivity model;

    public void setVue(ActivityVue vue) {this.vue = vue;}

    public void setModel(ListActivity model) {this.model = model;}

    public ActivityType call() {
        String efface = vue.removeActivityType();

        if (model.remove(efface) != null){
            vue.removeActivityType();
            if(efface.charAt(0) == 'O' || efface.charAt(0) == 'o'){
                model.remove(efface);
            }
        }
        return null;
    }
}
