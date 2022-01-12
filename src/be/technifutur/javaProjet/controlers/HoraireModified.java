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

            choix = Integer.parseInt(vue.choixChangement());

            switch (choix) {
                case 1 -> {
                    model.remove(oldName);
                    newName = vue.nameChangement();
                    if (!newName.equals(oldName) && !newName.isBlank()) {
                        activity.setName(newName);
                        boolean inscription = (vue.inscription().equalsIgnoreCase("O"));
                        Activity activity = model.add(type, newName, oldStart, oldEnd);
                        vue.afficheActivity(activity);
                    } else {
                        vue.setError("Les noms que vous avez encodés sont les mêmes.");
                    }
                }
                case 2 -> {
                    model.remove(String.valueOf(oldStart));
                    newStart = LocalDateTime.parse(vue.startChangement(), formatter);
                    if (!newStart.equals(oldStart)) {
                        model.set(String.valueOf(newStart));
                        activity.setStart(newStart);
                        boolean inscription = (vue.inscription().equalsIgnoreCase("O"));
                        listActivityType.setRegistration(inscription);
                        Activity activity = model.add(type, oldName, newStart, oldEnd);
                        vue.afficheActivity(activity);
                    } else {
                        vue.setError("Les dates de début que vous avez encodées sont les mêmes.");
                    }
                }
                case 3 -> {
                    model.remove(String.valueOf(oldEnd));
                    vue.endChangement();
                    newEnd = LocalDateTime.parse(vue.getEnd(), formatter);
                    if (!newEnd.equals(oldEnd)){
                        model.set(String.valueOf(newEnd));
                        activity.setEnd(newEnd);
                        boolean inscription = (vue.inscription().equalsIgnoreCase("O"));
                        listActivityType.setRegistration(inscription);
                        Activity activity = model.add(type, oldName, oldStart, newEnd);
                        vue.afficheActivity(activity);
                    } else {
                        vue.setError("Les dates de fin que vous avez encodées sont les mêmes.");
                    }
                }
                default -> vue.setError("Le choix que vous avez encodé n'est pas disponible.");
            }
        } else {
            vue.setError("Cette activité n'existe pas dans notre base de données.");
        }
        return null;
    }
}
