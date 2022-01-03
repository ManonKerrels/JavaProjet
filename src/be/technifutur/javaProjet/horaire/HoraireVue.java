package be.technifutur.javaProjet.horaire;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HoraireVue {
    private Scanner input = new Scanner(System.in);
    private String error = null;
    private String information = null;


    public void setError(String error) {this.error = error;}
    public String getError() {return error;}

    public void setInformation(String information) {this.information = information;}
    public String getInformation() {return information;}

    public String getName() {
        System.out.println("À quelle activité souhaitez-vous ajouter un horaire ?");
        String name = input.nextLine().trim();
        return name;
    }

    public String getStart(){
        System.out.println("À quelle date et quelle heure souhaitez-vous encoder le début de votre activité ?");
        String name = input.nextLine();
        return name;
    }

    public String confirmation(){
        System.out.println("Souhaitez-vous encoder cette plage-horaire ?");
        String choix = input.nextLine().trim();
        if (choix.charAt(0) == 'O' || choix.charAt(0) == 'o') {
            System.out.println("Vous êtes désormais inscrit(e) à cette activité !");
        } else {
            System.out.println("Vous ne vous êtes pas inscrit(e).");
        }
        return choix;
    }


}
