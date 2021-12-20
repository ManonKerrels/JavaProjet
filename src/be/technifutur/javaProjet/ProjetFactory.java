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
    // Appel au JavaControler
    public JavaControler createMenu(JavaModel javaModel){
        JavaControler javaControler = new JavaControler();
        javaControler.setVue(new JavaVue());
        javaControler.setModel(javaModel);
        return javaControler;
    }

    //méthode pour le menu principal
    public JavaModel getMenuPrincipal(){
        JavaModel javaModel = new JavaModel("Menu principal : ");
        //lien vers Item choix secondaire
        //lien vers Item quitter menu
        return javaModel;
    }



}
