package be.technifutur.javaProjet.horaire;

import java.util.Scanner;

public class HoraireVue {
    private Scanner input = new Scanner(System.in);
    private String error = null;
    private String information = null;


    public void setError(String error) {this.error = error;}
    public String getError() {return error;}

    /*public void setInformation(String information) {this.information = information;}
    public String getInformation() {return information;}*/

    public String getName() {
        System.out.println("À quelle activité souhaitez-vous ajouter un horaire ?");
        return input.nextLine().trim();
    }

    public String getActivityType(){
        System.out.println("Quel type d'activité voulez-vous encoder sous ce nom ?");
        return input.nextLine().trim();
        //enregistrer les réponses dans la Map
    }

    public String getStart(){
        System.out.println("À quelle date et quelle heure souhaitez-vous encoder le début de votre activité ?");
        return input.nextLine();
        //enregistrer les réponses dans la Map
    }

    public String getEnd(){
        System.out.println("Quels seraient le jour et l'heure de fin de votre activité ?");
        return input.nextLine();
        //enregistrer les réponses dans la Map
    }


}
