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

    public String removeActivityType() { //suppression d'une activité
        System.out.println("Veuillez encoder le nom de l'activité à retirer : ");
        String efface = input.nextLine().trim();
        System.out.println("Êtes-vous certain(e) de vouloir supprimer l'activité " + efface + " ?");
        System.out.println("Encodez O pour Oui, et N pour Non.");
        String choix = input.nextLine();
        if (choix.charAt(0) == 'O' || choix.charAt(0) == 'o') {
            System.out.println("L'activité " + efface + " a bien été supprimée !");
        }
        return input.nextLine().trim();
    }

    public String replaceActivityType(){
        System.out.println("Veuillez encoder l'activité que vous désirez modifier : ");
        String oldValue = input.nextLine().trim();
        System.out.println("Êtes-vous certain(e) de vouloir remplacer l'activité "+oldValue+" ?");
        System.out.println("Encodez O pour Oui, et N pour Non.");
        String choix = input.nextLine();
        System.out.printf("Veuillez afficher le nouveau nom à encoder : ");
        String newValue = input.nextLine();

        if(oldValue.equals(newValue)){
            System.out.printf("Les noms que vous avez encodés sont les mêmes !");
        } else{
            if (choix.charAt(0) == 'O' || choix.charAt(0) == 'o'){
                System.out.println("L'activité "+oldValue+" a bien été modifiée en "+newValue+" !");
            }
        }
        return input.nextLine().trim();
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
    }
}
