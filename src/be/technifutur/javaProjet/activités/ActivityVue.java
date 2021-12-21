package be.technifutur.javaProjet.activités;

import java.util.Scanner;

public class ActivityVue {
    private Scanner input = new Scanner(System.in);
    private String error = null;

    public String putActivityType() {
        System.out.println("Veuillez encoder le nom de l'activité choisie : ");
        if (this.error != null) {
            System.out.println("Il y a une erreur : " + error);
        }
        return input.nextLine().trim();
    }

    public String inscription(){
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
