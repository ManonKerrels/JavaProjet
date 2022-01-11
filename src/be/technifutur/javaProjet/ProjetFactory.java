//Choix principal (1. Gestion d'activité, 2. Quitter)
//Gérer les activités (1. créer une activité, 2. supprimer une activité)
//Gérer créer une activité (1. Encoder nom d'activité, 2. Demande O-N pour s'inscrire)


package be.technifutur.javaProjet;

import be.technifutur.javaProjet.controlers.*;

import java.util.concurrent.Callable;

public class ProjetFactory{

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

    //Item Quitter
    public Item getItemQuitter() {return createItem("Quitter", null);}

    //Items liés aux activités
    public Item getItemActivityAdd(){return createItem("Ajouter une activité", new ActivityAdd());}
    private JavaNode getItemActivityRemove() {return createItem("Supprimer une activité", new ActivityRemove());}
    private JavaNode getItemActivityReplace() {return createItem("Modifier une activité", new ActivityReplace());}

    //Items liés aux horaires
    private JavaNode getItemHoraireAdd() {return createItem("Ajouter un horaire", (Callable) new HoraireAdd());}
    private JavaNode getItemHoraireRemove() {return createItem("Supprimer un horaire", (Callable) new HoraireRemove());}
    private JavaNode getItemHoraireModified() {return createItem("Modifier un horaire", (Callable) new HoraireModified());}


    //méthode pour le menu principal
    public JavaModel getMenuPrincipal(){
        JavaModel javaModel = new JavaModel("Menu principal : ");
        javaModel.addJavaNode(getControllerPrincipal());
        javaModel.addJavaNode(createMenu(getMenuSecondaire()));
        javaModel.addJavaNode(createMenu(getMenuTertiaire()));
        javaModel.addJavaNode(getItemQuitter()); //dans le menu principal, option pour quitter
        return javaModel;
    }

    public JavaModel getMenuSecondaire(){
        JavaModel javaModel = new JavaModel("Gestion des stages"); //création d'un menu secondaire avec sous-options
        javaModel.addJavaNode(getItemActivityAdd());
        javaModel.addJavaNode(getItemActivityRemove());
        javaModel.addJavaNode(getItemActivityReplace());
        javaModel.addJavaNode(getItemQuitter());
        return javaModel;
    }

    private JavaModel getMenuTertiaire() {
        JavaModel javaModel = new JavaModel("Gestion des horaires");
        javaModel.addJavaNode(getItemHoraireAdd());
        javaModel.addJavaNode(getItemHoraireRemove());
        javaModel.addJavaNode(getItemHoraireModified());
        javaModel.addJavaNode(getItemQuitter());
        return javaModel;
    }

    public JavaControler getControllerPrincipal() {
        JavaModel menuPrincipal = getMenuPrincipal(); //appel à la méthode getMenuPrincipal
        JavaControler javaControler = createMenu(menuPrincipal); //appel à la méthode précédente pour créer un menu
        return javaControler;
    }

}
