package be.technifutur.javaProjet.activités;

import java.util.concurrent.Callable;

public class ActivityControler extends ActivityType{
    private ActivityVue vue;
    private ListActivity model;

    public ActivityControler(String name, boolean registration) {
        super(name, registration);
    }

    //2 accesseurs publics pour ActivitéVue et ActivitéModel
    public void setVue(ActivityVue vue) {this.vue = vue;}
    public void setModel(ListActivity model) {this.model = model;}

    public Callable addActivityType(Callable action) {return action;}

}
