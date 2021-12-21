package be.technifutur.javaProjet;

import be.technifutur.javaProjet.activités.ActivityAdd;
import be.technifutur.javaProjet.activités.ActivityRemove;
import be.technifutur.javaProjet.activités.ActivityVue;
import be.technifutur.javaProjet.activités.ListActivity;

public class Main {
    public static void main(String[] args) {
        ActivityAdd activityAdd = new ActivityAdd();
        ActivityRemove activityRemove = new ActivityRemove();
        activityAdd.setModel(new ListActivity());
        activityAdd.setVue(new ActivityVue());
        activityRemove.setModel(new ListActivity());
        activityRemove.setVue(new ActivityVue());

        for(int i = 0; i < 2; i++){
            activityAdd.call();
        }

        for (int i = 0; i < 1; i++){
            activityRemove.call();
        }

    }
}
