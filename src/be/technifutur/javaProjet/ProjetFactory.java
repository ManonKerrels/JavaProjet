//Choix principal (1. Gestion d'activité, 2. Quitter)
//Gérer les activités (1. créer une activité, 2. supprimer une activité)
//Gérer créer une activité (1. Encoder nom d'activité, 2. Demande O-N pour s'inscrire)


package be.technifutur.javaProjet;

import java.util.concurrent.Callable;

public class ProjetFactory {

    //fonction utilitaire pour créer des Items
    private Item createItem(String name, Callable action){
        Item item = new Item();
        item.setName(name);
        item.setAction(action);
        return item;
    }


    //méthode pour créer un menu
    public JavaControler createMenu(JavaModel javaModel){
        JavaControler javaControler = new JavaControler(); // Appel au JavaControler
        javaControler.setVue(new JavaVue()); //on met une vue au Controller
        javaControler.setModel(javaModel); //on met un model au Controller
        return javaControler;
    }

    //création de l'Item permettant de quitter
    public Item getItemQuitter() {return createItem("Quitter", null);}

    //méthode pour le menu principal
    public JavaModel getMenuPrincipal(){
        JavaModel javaModel = new JavaModel("Menu principal : ");
        javaModel.addJavaNode(createMenu(getMenuSecondaire()));
        javaModel.addJavaNode(getItemQuitter()); //dans le menu principal, option pour quitter
        return javaModel;
    }

    public JavaModel getMenuSecondaire(){
        JavaModel javaModel = new JavaModel("Gestion des stages"); //création d'un menu secondaire avec sous-options
        return javaModel;
    }

    public JavaControler getControllerPrincipal() {
        JavaModel menuPrincipal = getMenuPrincipal(); //appel à la méthode getMenuPrincipal
        JavaControler javaControler = createMenu(menuPrincipal); //appel à la méthode précédente pour créer un menu
        return javaControler;
    }

}
