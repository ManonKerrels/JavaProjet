//Controler pour ajouter une nouvelle activité à l'horaire

package be.technifutur.javaProjet.controlers;

import be.technifutur.javaProjet.factory.ActivityType;
import be.technifutur.javaProjet.factory.ListActivityType;
import be.technifutur.javaProjet.modeles.Horaire;
import be.technifutur.javaProjet.vues.HoraireVue;
import be.technifutur.javaProjet.modeles.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HoraireAdd {
    private HoraireVue vue;
    private Horaire model;
    private ListActivityType listActivityType;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy H:m:s");

    public void setVue(HoraireVue vue) {this.vue = vue;}
    public void setModel(Horaire model) {this.model = model;}
    public void setListActivityType(ListActivityType listActivityType) {this.listActivityType = listActivityType;}

    public Stage call(){
        String name;
        String input;
        LocalDateTime start;
        LocalDateTime end;
        vue.setError(null);
        input = vue.getActivityType();
        ActivityType type = listActivityType.get(input);

        if(type != null){
            name = vue.getName();
            start = LocalDateTime.parse(vue.getStart(), formatter);
            end = LocalDateTime.parse(vue.getEnd(), formatter);
            model.add(type, name, start, end);
            vue.afficheActivity(model.get(name.toUpperCase()));
        } else{
            vue.setError("Cette activité n'existe pas encore dans notre base de données. Veuillez commencer par l'enregistrer.");
        }

        return null;
    }

}
