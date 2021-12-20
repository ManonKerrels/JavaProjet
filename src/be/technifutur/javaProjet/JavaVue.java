//Affichage Choix principal
//Affichage choix secondaire
//Affichage message d'erreur

package be.technifutur.javaProjet;

import java.util.Scanner;

public class JavaVue {

    //attributs privés pointant sur System.in
    private Scanner input = new Scanner(System.in);
    private String error = null;

    public void setError(String message){
        this.error = message;
    }

    public String saisirMenu(JavaModel model){
        String nameMenu = model.getName();
        System.out.println(nameMenu);
        System.out.println("-".repeat(nameMenu.length()));

        return nameMenu;
    }


}
