package be.technifutur.javaProjet.activités;

import java.util.Scanner;

public class ActivityVue {
    private Scanner input = new Scanner(System.in);
    private String error = null;

    public String putActivityType() { //ajout d'une activité
        System.out.println("Veuillez encoder le nom de l'activité choisie : ");
        if (this.error != null) {
            System.out.println("Il y a une erreur : " + error);
        }
        return input.nextLine().trim();
    }

    public String removeActivityType(){ //suppression d'une activité
        System.out.println("Veuillez encoder le nom de l'activité à retirer : ");
        if(input != null){
            System.out.println("Êtes-vous certain(e) de vouloir supprimer cette activité ?");
        } else{
            System.out.println("Cette activité ne fait pas partie de votre liste.");
        }
        return input.nextLine().trim();
    }

    public String inscription(){ //suite de l'ajout d'activité, demande d'inscription ou non
        System.out.println("Souhaitez-vous créer une inscription pour cette activité ? Encodez O pour oui, et N pour non.");
        String choix = input.nextLine().trim();
        if(choix.charAt(0) == 'O' || choix.charAt(0) == 'o'){
            System.out.println("Vous êtes désormais inscrit(e) à cette activité !");
        } else {
            System.out.println("Vous ne vous êtes pas inscrit(e).");
        }
        return choix;
    }

    public void afficherType(ActivityType activityType){
        System.out.println(activityType);
    }

    public void setError(String error) {this.error = error;}
}
