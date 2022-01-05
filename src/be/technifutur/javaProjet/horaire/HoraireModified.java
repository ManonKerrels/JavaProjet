package be.technifutur.javaProjet.horaire;

import be.technifutur.javaProjet.activités.ActivityType;
import be.technifutur.javaProjet.activités.ListActivityType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HoraireModified {

    private HoraireVue vue;
    private Horaire model;
    private ListActivityType listActivityType;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy H:m:s");

    public void setVue(HoraireVue vue) {this.vue = vue;}
    public void setModel(Horaire model) {this.model = model;}
    public void setListActivityType(ListActivityType listActivityType) {this.listActivityType = listActivityType;}

    public Stage call(){
        String oldName = null;
        String newName = null;
        boolean change = false;
        int choix = 0;
        LocalDateTime start = null;
        LocalDateTime end = null;
        vue.setError(null);

        String input = vue.getChangement();
        ActivityType type = listActivityType.get(input);

        if (type != null){
            input = vue.choixChangement();
            model.change(type, oldName, start, end);
            switch (choix){
                case 1:
                    model.nameChange(oldName);
                    break;
                case 2:
                    model.startChange();
                    break;
                case 3:
                    model.endChange();
                    break;
                default: vue.setError("Le choix que vous avez encodé n'est pas disponible.");
            }
        } else{
            vue.setError("Cette activité n'existe pas dans notre base de données.");
        }


        return null;
    }
}
