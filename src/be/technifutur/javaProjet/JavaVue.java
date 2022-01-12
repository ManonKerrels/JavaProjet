//Affichage Choix principal
//Affichage choix secondaire
//Affichage message d'erreur

package be.technifutur.javaProjet;

import java.util.Scanner;

public class JavaVue {

    //attributs privés pointant sur System.in
    private final Scanner input = new Scanner(System.in);
    private String error = null;

    public void setError(String message){
        this.error = message;
    }

    public String saisirMenu(JavaModel model){
        String nameMenu = model.getName();
        System.out.println(nameMenu);
        System.out.println("-".repeat(nameMenu.length()));

        for(int i=0; i < model.getSize(); i++){ //pour l'ensemble du tableau contenant les sous-menus
            System.out.println((i+1)+". "+model.getJavaNode(i).getName()); //affichage des éléments de ce sous-menu
        }

        if(this.error != null){
            System.out.println("Il y a une erreur : "+error); //si une erreur est présente, on va afficher de quel type
        }
        System.out.println("Choisissez ce que vous désirez effectuer dans ce menu : ");
        return input.nextLine(); //on retourne ce choix

    }


}
