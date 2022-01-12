//controler

package be.technifutur.javaProjet.controlers;

import be.technifutur.javaProjet.factory.ActivityType;
import be.technifutur.javaProjet.modeles.Horaire;
import be.technifutur.javaProjet.vues.ActivityVue;
import be.technifutur.javaProjet.factory.ListActivityType;

import java.util.concurrent.Callable;

public class ActivityAdd implements Callable {
    private ActivityVue vue;
    private ListActivityType model;

    //2 accesseurs publics pour ActivityVue et ActivityModel
    public void setVue(ActivityVue vue) {
        this.vue = vue;
    }

    public void setModel(ListActivityType model) {
        this.model = model;
    }


    //méthode qui permet d'ajouter un nom d'activité et vérifie si c'est déjà présent ou pas
    public ActivityType call() {
        boolean enregistrement = false;
        vue.setError(null);
        String nameActivity = vue.putActivityType();
        model.get(nameActivity);

        if (model.get(nameActivity) == null) { //si l'activité n'existe pas dans la map, on demande si on veut s'inscrire
            String inscription = vue.inscription();
            if (inscription.charAt(0) == 'O' || inscription.charAt(0) == 'o') {
                enregistrement = true;
            }
        } else {
            vue.setError("Cette activité existe déjà dans notre base de données.");
        }

        vue.afficherType(model.addActivityType(nameActivity, enregistrement));
        return null;
    }



}
