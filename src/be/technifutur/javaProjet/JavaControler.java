package be.technifutur.javaProjet;

public class JavaControler {
    private JavaVue vue;
    private JavaModel model;

    //Vérifie que les informations entrées sont justes (choix lors du menu ou nom/type d'activité encodée)
    //Gestion de l'erreur

    //2 accesseurs publics pour JavaVue et JavaModel
    public void setVue(JavaVue javaVue) {this.vue = javaVue;}
    public void setModel(JavaModel javaModel) {this.model = javaModel;}

}
