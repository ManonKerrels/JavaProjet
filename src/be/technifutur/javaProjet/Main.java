package be.technifutur.javaProjet;

import be.technifutur.javaProjet.activités.ActivityControler;
import be.technifutur.javaProjet.activités.ActivityVue;
import be.technifutur.javaProjet.activités.ListActivity;

public class Main {
    public static void main(String[] args) {
        ActivityControler activityControler = new ActivityControler();
        activityControler.setModel(new ListActivity());
        activityControler.setVue(new ActivityVue());

        for(int i = 0; i < 2; i++){
            activityControler.call();
        }


    }
}
