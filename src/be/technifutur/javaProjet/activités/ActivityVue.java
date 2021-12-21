package be.technifutur.javaProjet.activités;

import java.util.Scanner;

public class ActivityVue {
    private Scanner input = new Scanner(System.in);
    private String error = null;

    public String putActivityType(){
        System.out.println("Veuillez encoder le nom de l'activité choisie : ");
        if(this.error != null){
            System.out.println("Il y a une erreur : "+error);
        }
        String choix = input.nextLine().trim();
        System.out.println("Nouvelle activité ajoutée !");
        return choix;
    }

    public String inscription(){
        System.out.println("Souhaitez-vous créer une inscription pour cette activité ? Encodez O pour oui, et N pour non.");
        String choix = input.nextLine().trim();
        if(choix.charAt(0) == 'O' || choix.charAt(0) == 'o'){
            System.out.println("Vous êtes désormais inscrit(e) à cette activité !");
        }
        return choix;
    }

    public void afficherType(ActivityType activityType){
        System.out.println(activityType);
    }

    public void setError(String error) {this.error = error;}
}
