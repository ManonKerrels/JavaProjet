package be.technifutur.javaProjet.vues;

import be.technifutur.javaProjet.factory.ActivityType;

import java.util.Scanner;

public class ActivityVue {
    private final Scanner input = new Scanner(System.in);
    private String error = null;
    private String information = null;


    public String putActivityType() { //ajout d'une activité
        System.out.println("Veuillez encoder le nom de l'activité que vous désirez ajouter à notre base de données : ");
        return input.nextLine().trim();
    }

    public String removeActivityType() { //suppression d'une activité
        System.out.println("Veuillez encoder le nom de l'activité à retirer de notre base de données : ");
        String efface = input.nextLine().trim();
        System.out.println("Êtes-vous certain(e) de vouloir supprimer l'activité " + efface + " ?");
        System.out.println("Encodez O pour Oui, et N pour Non.");
        String choix = input.nextLine();
        if (choix.charAt(0) == 'O' || choix.charAt(0) == 'o') {
            System.out.println("L'activité " + efface + " a bien été supprimée !");
        }
        return input.nextLine().trim();
    }

    public String replaceActivityType(){ //nom de la nouvelle activité dans ActivityReplace
        System.out.print("Veuillez afficher le nouveau nom à encoder : ");
        String newValue = input.nextLine();
        return newValue.trim();
    }

    public String oldActivityType(){ //Vieille activité à modifier dans ActivityReplace
        System.out.println("Veuillez encoder l'activité que vous désirez modifier dans notre base de données : ");
        return input.nextLine().trim();
    }

    public String confirmationActivityType(String oldValue){ //confirmation du choix d'activité à modifier dans ActivityReplace
        System.out.println("Êtes-vous certain(e) de vouloir remplacer l'activité "+oldValue+" ?");
        System.out.println("Encodez O pour Oui, et N pour Non.");
        return input.nextLine();
    }

    public String inscription() { //suite de l'ajout d'activité, demande d'inscription ou non
        System.out.println("Souhaitez-vous créer une inscription pour cette activité ? Encodez O pour oui, et N pour non.");
        String choix = input.nextLine().trim();
        if (choix.charAt(0) == 'O' || choix.charAt(0) == 'o') {
            System.out.println("Vous êtes désormais inscrit(e) à cette activité !");
        } else {
            System.out.println("Vous ne vous êtes pas inscrit(e).");
        }
        return choix;
    }

    public void afficherType(ActivityType activityType) {
        System.out.println(activityType);
    }

    public void setError(String error) {
        this.error = error;
    } //message en cas d'erreur

    public void setInformation(String information) {this.information = information;} //message en cas d'information


}
