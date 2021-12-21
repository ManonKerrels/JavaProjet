package be.technifutur.javaProjet.activités;

import java.util.ArrayList;
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


    //méthode qui permet d'ajouter un nom d'activité et vérifie si c'est déjà présent ou pas
    public Callable addActivityType(Callable action) {
        String nameActivity = vue.putActivityType();
        if(model.get(nameActivity) == null){
            nameActivity = model.addActivityType();
            
        }
        return action;
    }

}
