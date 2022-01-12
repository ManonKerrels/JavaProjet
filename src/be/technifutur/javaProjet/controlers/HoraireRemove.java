package be.technifutur.javaProjet.controlers;

import be.technifutur.javaProjet.factory.ActivityType;
import be.technifutur.javaProjet.factory.ListActivityType;
import be.technifutur.javaProjet.modeles.Horaire;
import be.technifutur.javaProjet.vues.HoraireVue;
import be.technifutur.javaProjet.modeles.Stage;

import java.util.concurrent.Callable;

public class HoraireRemove implements Callable {

    private HoraireVue vue;
    private Horaire model;
    private ListActivityType listActivityType;

    public void setModel(Horaire model) {this.model = model;}
    public void setVue(HoraireVue vue) {this.vue = vue;}
    public void setListActivityType(ListActivityType listActivityType) {this.listActivityType = listActivityType;}


    public Stage call(){
        String name;
        String input;
        vue.setError(null);
        input = vue.getRemoveActivity();
        ActivityType type = listActivityType.get(input);

        if (type != null){
            name = vue.getRemoveConfirmation();
            if(name.charAt(0) == 'O' || name.charAt(0) == 'o'){
                model.remove(name);
            }
        } else{
            vue.setError("Cette activité n'existe pas dans notre base de données.");
        }
        return null;
    }
}
