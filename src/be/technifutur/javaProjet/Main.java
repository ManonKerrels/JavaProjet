package be.technifutur.javaProjet;

import be.technifutur.javaProjet.activités.ActivityAdd;
import be.technifutur.javaProjet.activités.ActivityVue;
import be.technifutur.javaProjet.activités.ListActivity;

public class Main {
    public static void main(String[] args) {
        ActivityAdd activityControler = new ActivityAdd();
        activityControler.setModel(new ListActivity());
        activityControler.setVue(new ActivityVue());
        ProjetFactory projetFactory = new ProjetFactory();
        JavaControler javaControler = new JavaControler();

        for(int i = 0; i < 2; i++){
            activityControler.call();
        }


    }
}
