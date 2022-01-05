package be.technifutur.javaProjet.horaire;

import be.technifutur.javaProjet.activités.ActivityType;
import be.technifutur.javaProjet.activités.ListActivityType;

public class HoraireRemove {

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
