package be.technifutur.javaProjet;

import java.util.concurrent.Callable;

public class ProjetFactory {

    //Appel au JavaControler

    //Choix principal (1. Gestion d'activité, 2. Quitter)
    //Gérer les activités (1. créer une activité, 2. supprimer une activité)
    //Gérer créer une activité (1. Encoder nom d'activité, 2. Demande O-N pour s'inscrire)

    private Item createItem(String name, Callable action){
        Item item = new Item();

        return item;
    }

    private JavaModel getModelPrincipal(){

        return null;
    }



}
