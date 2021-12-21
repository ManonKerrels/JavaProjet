package be.technifutur.javaProjet;

import be.technifutur.javaProjet.activités.*;

public class Main {
    public static void main(String[] args) {
        ActivityAdd activityAdd = new ActivityAdd();
        activityAdd.setModel(new ListActivity());
        activityAdd.setVue(new ActivityVue());

        ActivityRemove activityRemove = new ActivityRemove();
        activityRemove.setModel(new ListActivity());
        activityRemove.setVue(new ActivityVue());

        ActivityReplace activityReplace = new ActivityReplace();
        activityReplace.setModel(new ListActivity());
        activityReplace.setVue(new ActivityVue());



        for(int i = 0; i < 2; i++){
            activityAdd.call();
        }

        for (int i = 0; i < 1; i++){
            activityRemove.call();
        }

    }
}
