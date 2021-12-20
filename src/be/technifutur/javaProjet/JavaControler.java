//Vérifie que les informations entrées sont justes (choix lors du menu ou nom/type d'activité encodée)
//Gestion de l'erreur


package be.technifutur.javaProjet;

import java.util.concurrent.Callable;

public class JavaControler implements JavaNode{
    private JavaVue vue;
    private JavaModel model;

    //2 accesseurs publics pour JavaVue et JavaModel
    public void setVue(JavaVue javaVue) {this.vue = javaVue;}
    public void setModel(JavaModel javaModel) {this.model = javaModel;}

    @Override
    public Callable getAction() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
