package be.technifutur.javaProjet.activités;

import be.technifutur.javaProjet.Main;

import java.util.concurrent.Callable;

public class ActivityControler implements Callable {
    private ActivityVue vue;
    private ListActivity model;

    //2 accesseurs publics pour ActivitéVue et ActivitéModel
    public void setVue(ActivityVue vue) {
        this.vue = vue;
    }

    public void setModel(ListActivity model) {
        this.model = model;
    }


    //méthode qui permet d'ajouter un nom d'activité et vérifie si c'est déjà présent ou pas
    public ActivityType call() {
        boolean enregistrement = false;

        do {
            String nameActivity = vue.putActivityType();
            model.get(nameActivity);
            if (model.get(nameActivity) != null) {
                if(nameActivity.equals(vue.putActivityType())){
                    System.out.println("Cette activité existe déjà dans notre base de données.");
                }
                vue.putActivityType();
            }

            String inscription = vue.inscription();
            if(vue.inscription() != null) {
                if (inscription.charAt(0) == 'O' || inscription.charAt(0) == 'o') {
                    enregistrement = true;
                }
            }
            vue.afficherType(model.addActivityType(nameActivity, enregistrement));
        } while (!enregistrement);
        return null;
    }

}
