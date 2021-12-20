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
    public Callable setAction(Callable action) {
        return action;
    }

    @Override
    public Callable getAction() {
        Callable result = null; //result pour le getAction de JavaNode
        boolean saisie = false; //booléen qui est d'office en false (on part du principe qu'il faut vérifier si l'action sera vraie ou pas)
        vue.setError(null); //en cas d'erreur, on fait appel au message dans JavaVue
        int choix = 0;

        do {
            String input = vue.saisirMenu(model);
            try {
                choix = Integer.parseInt(input) - 1; //transformation du choix en position
                JavaNode nodeChoisi = model.getJavaNode(choix); //on va dans JavaModel pour obtenir la méthode getJavaNode afin de vérifier que la position est possible

                if(choix >= 0 && choix < model.getSize()){
                    saisie = true;
                    JavaNode javaNode = model.getJavaNode(choix); //si choix correct, on va dans JavaModel pour récupérer la méthode JavaNode
                    result = javaNode.getAction(); //notre bon résultat nous permet de lancer l'action
                } else {
                    vue.setError("L'option "+(choix+1)+" n'est pas disponible."); //message d'erreur si l'option n'est pas possible
                }
            } catch (NumberFormatException e){
                vue.setError((choix+1)+" n'est pas un nombre vous permettant d'accéder à une option.");
            }
        } while(saisie == false);
        vue.setError(null);
        return result;
    }

    @Override
    public String getName() {return model.getName();} //récupérer le nom du getName venant du JavaModel

}
