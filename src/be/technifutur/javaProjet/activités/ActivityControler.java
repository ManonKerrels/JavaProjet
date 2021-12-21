package be.technifutur.javaProjet.activités;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ActivityControler implements Callable {
    private ActivityVue vue;
    private ListActivity model;

    //2 accesseurs publics pour ActivitéVue et ActivitéModel
    public void setVue(ActivityVue vue) {this.vue = vue;}
    public void setModel(ListActivity model) {this.model = model;}


    //méthode qui permet d'ajouter un nom d'activité et vérifie si c'est déjà présent ou pas
    public ActivityType call () {
        boolean enregistrement = false;
        String nameActivity = vue.putActivityType();
        if(model.get(nameActivity) != null){
            vue.putActivityType();
        } else {
            String inscription = vue.inscription();
            if(inscription.charAt(0) == 'O'){
                enregistrement = true;
            }
        }
        model.addActivityType(nameActivity, enregistrement);
        return null;
    }

}
