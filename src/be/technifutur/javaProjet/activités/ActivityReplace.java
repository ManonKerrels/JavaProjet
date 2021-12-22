package be.technifutur.javaProjet.activités;

import java.util.concurrent.Callable;

public class ActivityReplace implements Callable {
    //attributs qui permettent de donner une vue et un modèle
    private ActivityVue vue;
    private ListActivity model;

    public void setVue(ActivityVue vue) {
        this.vue = vue;
    }
    public void setModel(ListActivity model) {
        this.model = model;
    }


    //méthode call qui permet d'appeler la fonction de remplacement
    @Override
    public Object call() throws Exception {
        String newValue = null;
        String oldValue = vue.replaceActivityType();
        boolean change = false;

        if (oldValue != newValue){
            change = true;
            newValue = oldValue;
        }
        if (oldValue.equals(newValue)){
            vue.setError("Idem");
        }
        return null;
    }
}
