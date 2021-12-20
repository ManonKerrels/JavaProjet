package be.technifutur.javaProjet;

import java.util.Scanner;

public class JavaVue {

    //Affichage Choix principal
    //Affichage choix secondaire
    //Affichage message d'erreur

    private Scanner input = new Scanner(System.in);

    public String saisirMenu(JavaModel model){
        String nameMenu = model.getName();
        System.out.println(nameMenu);
        System.out.println("-".repeat(nameMenu.length()));



        return nameMenu;
    }


}
