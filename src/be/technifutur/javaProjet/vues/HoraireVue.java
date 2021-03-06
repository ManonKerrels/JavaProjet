package be.technifutur.javaProjet.vues;

import be.technifutur.javaProjet.modeles.Activity;

import java.util.Scanner;

public class HoraireVue {
    private final Scanner input = new Scanner(System.in);
    private String error;
    private String information;


    public void setError(String error) {this.error = error;}
    public String getError() {return error;}

    public void setInformation(String information) {this.information = information;}
    public String getInformation() {return information;}



    //HoraireAdd
    public String getActivityType(){
        System.out.println("Sous quelle activité désirez-vous encoder un horaire ?");
        return input.nextLine().trim();
    }

    public String getName() {
        System.out.println("Quel nom de programme voulez-vous donner pour cette activité ?");
        return input.nextLine().trim();
    }

    public String getStart(){
        System.out.println("À quelles date et heure souhaitez-vous encoder le début de votre activité ? ");
        System.out.println("Veuillez encoder sous le format suivant : 12/01/1897 10:00 ");
        return input.nextLine();
    }

    public String getEnd(){
        System.out.println("Quels seraient le jour et l'heure de fin de votre activité ?");
        System.out.println("Veuillez encoder sous le format suivant : 12/01/1897 12:00 ");
        return input.nextLine();
    }

    public void afficheActivity(Activity activity) {
        System.out.println("L'activité a reçu dans son horaire le programme "+activity.getName());
        System.out.println("Ce dernier commence le "+activity.getStart());
        System.out.println("Et se termine le "+activity.getEnd());
        System.out.println(activity);
    }




    //HoraireRemove
    public String getRemoveActivity() {
        System.out.println("Veuillez encoder le nom de l'activité dont vous souhaitez supprimer le programme/l'horaire : ");
        return input.nextLine();
    }

    public String getRemoveConfirmation() {
        System.out.println("Êtes-vous certain(e) de vouloir supprimer l'horaire de cette activité ?");
        System.out.println("Encodez O pour Oui, et N pour Non.");
        String choix = input.nextLine();
        if (choix.charAt(0) == 'O' || choix.charAt(0) == 'o'){
            System.out.println("L'horaire/le programme de cette activité a bien été supprimé.");
        }
        return choix;
    }




    //HoraireModified
    public String getChangement() {
        System.out.println("Veuillez encoder le nom de l'activité dont vous désirez changer le programme ou l'horaire : ");
        return input.nextLine();
    }

    public String choixChangement() {
        System.out.println("Désirez-vous :");
        System.out.println("1. Changer le nom du programme de cette activité ?");
        System.out.println("2. Changer la date et l'heure du début de l'horaire ?");
        System.out.println("3. Changer la date et l'heure de la fin de l'horaire ?");
        return input.nextLine();
    }

    public String nameChangement() {
        System.out.println("Veuillez encoder le nouveau nom de programme : ");
        return input.nextLine();
    }

    public String inscription() {
        System.out.println("Souhaitez-vous créer une inscription pour cette activité ? Encodez O pour oui, et N pour non.");
        String choix = input.nextLine().trim();
        if (choix.charAt(0) == 'O' || choix.charAt(0) == 'o') {
            System.out.println("Vous êtes désormais inscrit(e) à cette activité !");
        } else {
            System.out.println("Vous ne vous êtes pas inscrit(e).");
        }
        return choix;
    }

    public String startChangement() {
        System.out.println("Veuillez encoder les nouvelles date et heure de début auxquelles vous désirez encoder votre activité : ");
        return input.nextLine();
    }

    public void endChangement() {
        System.out.println("Veuillez encoder les nouvelles date et heure de fin auxquelles vous désirez encoder votre activité : ");
        input.nextLine();
    }
}
