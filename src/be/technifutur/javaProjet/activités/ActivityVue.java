package be.technifutur.javaProjet.activités;

import java.util.Scanner;

public class ActivityVue {
    private Scanner input = new Scanner(System.in);

    public String putActivityType(){
        System.out.println("Veuillez encoder le nom de l'activité choisie : ");
        String choix = input.nextLine();
        return choix;
    }

    public String inscription(ListActivity listActivity){
        System.out.println("Souhaitez-vous créer une inscription pour cette activité ? Encodez O pour oui, et N pour non.");
        String choix = input.nextLine();
        return choix;
    }

}
