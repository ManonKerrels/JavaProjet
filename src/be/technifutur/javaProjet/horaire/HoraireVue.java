package be.technifutur.javaProjet.horaire;

import java.util.Scanner;

public class HoraireVue {
    private Scanner input = new Scanner(System.in);
    private String error = null;
    private String information = null;


    public void setError(String error) {
        System.out.println(error);
        this.error = error;
    }
    public String getError() {return error;}

    /*public void setInformation(String information) {this.information = information;}
    public String getInformation() {return information;}*/

    public String getName() {
        System.out.println("Quel nom voulez-vous donner ?");
        return input.nextLine().trim();
    }

    public String getActivityType(){
        System.out.println("Quel type d'activité voulez-vous encoder ?");
        return input.nextLine().trim();
    }

    public String getStart(){
        System.out.println("À quelle date souhaitez-vous encoder le début de votre activité ?");
        return input.nextLine();
    }

    public String getEnd(){
        System.out.println("Quel serait le jour de fin de votre activité ?");
        return input.nextLine();
    }


    public void afficheActivity(Activity activity) {
        //TODO améliorer code
        System.out.println(activity);
    }
}
