package be.technifutur.javaProjet.controlers;

import be.technifutur.javaProjet.factory.ActivityType;
import be.technifutur.javaProjet.factory.ListActivityType;
import be.technifutur.javaProjet.modeles.Activity;
import be.technifutur.javaProjet.modeles.Horaire;
import be.technifutur.javaProjet.vues.HoraireVue;
import be.technifutur.javaProjet.modeles.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Callable;

public class HoraireModified implements Callable {

    private HoraireVue vue;
    private Horaire model;
    private ListActivityType listActivityType;
    private Activity activity;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public void setVue(HoraireVue vue) {
        this.vue = vue;
    }

    public void setModel(Horaire model) {
        this.model = model;
    }

    public void setListActivityType(ListActivityType listActivityType) {
        this.listActivityType = listActivityType;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Stage call() {
        int choix = 0;
        boolean change = false;
        String input = null;

        String newName = null;
        LocalDateTime newStart = null;
        LocalDateTime newEnd = null;

        input = vue.getChangement();

        if (input != null) {
            setActivity(model.get(input));
            String oldName = activity.getName();
            LocalDateTime oldStart = activity.getStart();
            LocalDateTime oldEnd = activity.getEnd();
            ActivityType type = activity.getType();
            Activity activity = new Activity(type, oldName, oldStart, oldEnd);

            choix = Integer.parseInt(vue.choixChangement());

            switch (choix) {
                case 1:
                    model.remove(oldName);
                    vue.nameChangement();
                    newName = String.valueOf(model.get(input));

                    if (!newName.equals(oldName) && !newName.isBlank() && change) {
                        model.set(newName);
                        activity.setName(newName);
                        boolean inscription = (vue.inscription().equalsIgnoreCase("O") ? true : false);
                        listActivityType.setRegistration(inscription);
                        vue.afficheActivity(new Activity(type, newName, oldStart, oldEnd));
                    } else {
                        vue.setError("Les noms que vous avez encodés sont les mêmes.");
                    }
                    break;

                case 2: //TODO suite du change (date et heure de début)
                    model.remove(String.valueOf(oldStart));
                    vue.startChangement();
                    newStart = LocalDateTime.parse(model.startChange(), formatter);

                    if (!newStart.equals(oldStart) && change){
                        model.set(String.valueOf(newStart));
                        activity.setStart(newStart);
                        boolean inscription = (vue.inscription().equalsIgnoreCase("O") ? true : false);
                        listActivityType.setRegistration(inscription);
                        vue.afficheActivity(new Activity(type, newName, oldStart, oldEnd));
                    } else{
                        vue.setError("Les dates que vous avez encodées sont les mêmes.");
                    }
                    break;

                case 3:
                    //TODO suite du change (date et heure de fin)
                    model.endChange();
                    break;

                default:
                    vue.setError("Le choix que vous avez encodé n'est pas disponible.");
            }
        } else {
            vue.setError("Cette activité n'existe pas dans notre base de données.");
        }
        return null;
    }
}
