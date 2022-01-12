//Choix principal (1. Gestion d'activité, 2. Quitter)
//Gérer les activités (1. créer une activité, 2. supprimer une activité)
//Gérer créer une activité (1. Encoder nom d'activité, 2. Demande O-N pour s'inscrire)


package be.technifutur.javaProjet;

import be.technifutur.javaProjet.controlers.*;
import be.technifutur.javaProjet.factory.ListActivityType;
import be.technifutur.javaProjet.modeles.Horaire;
import be.technifutur.javaProjet.vues.ActivityVue;
import be.technifutur.javaProjet.vues.HoraireVue;
import be.technifutur.laboJava.serialization.DataStore;
import be.technifutur.laboJava.serialization.DataType;

import java.util.concurrent.Callable;

public class ProjetFactory{
    //création de l'objet DataStore qui va permettre d'enregistrer ce qu'on fait
    DataStore<DataType> activityDataStore = new DataStore<DataType>("test.ser", DataType::new);
    private final ListActivityType listActivityType = activityDataStore.getData().getListActivityType();
    private final Horaire horaire = activityDataStore.getData().getHoraire();

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

    //ActivityAdd
    public Item getItemActivityAdd(){return createItem("Ajouter une activité", getActivityAdd());}
    private Callable getActivityAdd() {
        ActivityAdd activityAdd = new ActivityAdd();
        activityAdd.setModel(listActivityType);
        activityAdd.setVue(new ActivityVue());
        return activityAdd;
    }

    //ActivityRemove
    private JavaNode getItemActivityRemove() {return createItem("Supprimer une activité", getActivityRemove());}
    private Callable getActivityRemove() {
        ActivityRemove activityRemove = new ActivityRemove();
        activityRemove.setModel(listActivityType);
        activityRemove.setVue(new ActivityVue());
        return activityRemove;
    }

    //ActivityReplace
    private JavaNode getItemActivityReplace() {return createItem("Modifier une activité", getActivityReplace());}
    private Callable getActivityReplace() {
        ActivityReplace activityReplace = new ActivityReplace();
        activityReplace.setModel(listActivityType);
        activityReplace.setVue(new ActivityVue());
        return activityReplace;
    }

    //HoraireAdd
    private JavaNode getItemHoraireAdd() {return createItem("Ajouter un horaire", getHoraireAdd());}
    private Callable getHoraireAdd() {
        HoraireAdd horaireAdd = new HoraireAdd();
        horaireAdd.setModel(horaire);
        horaireAdd.setVue(new HoraireVue());
        horaireAdd.setListActivityType(listActivityType);
        return horaireAdd;
    }

    //HoraireRemove
    private JavaNode getItemHoraireRemove() {return createItem("Supprimer un horaire", getHoraireRemove());}
    private Callable getHoraireRemove() {
        HoraireRemove horaireRemove = new HoraireRemove();
        horaireRemove.setModel(horaire);
        horaireRemove.setVue(new HoraireVue());
        horaireRemove.setListActivityType(listActivityType);
        return horaireRemove;
    }

    private JavaNode getItemHoraireModified() {return createItem("Modifier un horaire", getHoraireModified());}
    private Callable getHoraireModified() {
        HoraireModified horaireModified = new HoraireModified();
        horaireModified.setModel(horaire);
        horaireModified.setListActivityType(listActivityType);
        horaireModified.setVue(new HoraireVue());
        return horaireModified;
    }


    //méthode pour le menu principal
    public JavaModel getMenuPrincipal(){
        JavaModel javaModel = new JavaModel("Menu principal : ");
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
        return createMenu(menuPrincipal);
    }

    public DataStore<DataType> getDataStore() {
        return activityDataStore;
    }
}
