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
        int choix = 0;

        String newName;
        boolean change = false;

        LocalDateTime start = null;
        LocalDateTime end = null;
        vue.setError(null);
        vue.setInformation(null);

        String input = vue.getChangement();
        ActivityType type = listActivityType.get(input);

        if (input != null){
            choix = Integer.parseInt(vue.choixChangement());
            switch (choix){
                case 1:
                    newName = vue.nameChangement();
                    if (!input.equalsIgnoreCase(newName) && !input.isBlank() && !newName.isBlank() && change){
                        model.remove(input);
                        if (input != null){
                            listActivityType.setName(newName);
                            model.add(type, newName, start, end);
                            //TODO problème: cette phrase ne s'affiche pas
                            vue.setInformation("Le programme "+input+" a bien été modifié en "+newName);
                        }
                    }
                    break;

                case 2:
                    //TODO suite du change (date et heure de début)
                    model.startChange();
                    break;

                case 3:
                    //TODO suite du change (date et heure de fin)
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
