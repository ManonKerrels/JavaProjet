//Controler pour ajouter une nouvelle activité à l'horaire

package be.technifutur.javaProjet.horaire;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HoraireAdd {


    String name;
    String input;
    LocalDateTime start = LocalDateTime.now();
    LocalDateTime end = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-M-yyyy");

    private HoraireVue vue;
    private Horaire model;

    public void setVue(HoraireVue vue) {this.vue = vue;}
    public void setModel(Horaire model) {this.model = model;}

    public Stage call(){
        boolean enregistrement = false;
        vue.setError(null);
        input = vue.getName();
        model.get(name);

        if(model.get(name) != null){
            vue.getActivityType();
        } else{
            vue.setError("Cette activité n'existe pas encore dans notre base de données. Veuillez commencer par l'enregistrer dans nos données.");
        }

        start = LocalDateTime.parse(vue.getStart());
        end = LocalDateTime.parse(vue.getEnd());

        return null;
    }

}
