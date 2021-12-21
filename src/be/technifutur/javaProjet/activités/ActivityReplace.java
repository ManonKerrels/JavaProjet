package be.technifutur.javaProjet.activités;

import java.util.concurrent.Callable;

public class ActivityReplace implements Callable {
    private ActivityVue vue;
    private ListActivity model;

    public void setVue(ActivityVue vue) {
        this.vue = vue;
    }

    public void setModel(ListActivity model) {
        this.model = model;
    }

    @Override
    public Object call() throws Exception {
        String remplacement = vue.replaceActivityType();
        //faire remplacement
        return null;
    }
}
