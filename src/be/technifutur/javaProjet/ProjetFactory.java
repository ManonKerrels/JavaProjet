package be.technifutur.javaProjet;

import java.util.concurrent.Callable;

public class ProjetFactory {

    //Appel au JavaControler

    //Choix principal (1. Gestion d'activité, 2. Quitter)
    //Gérer les activités (1. créer une activité, 2. supprimer une activité)
    //Gérer créer une activité (1. Encoder nom d'activité, 2. Demande O-N pour s'inscrire)

    //fonction utilitaire pour créer des Items
    private Item createItem(String name, Callable action){
        Item item = new Item();
        item.setName(name);
        item.setAction(action);
        return item;
    }


    //méthode pour créer le menu
    public JavaControler createMenu(JavaModel javaModel){
        JavaControler javaControler = new JavaControler();
        javaControler.setVue(new JavaVue());
        javaControler.setModel(javaModel);
        return javaControler;
    }

    private JavaModel getModelPrincipal(){

        return null;
    }



}
