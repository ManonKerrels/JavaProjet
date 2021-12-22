package be.technifutur.javaProjet.activités;

import java.util.concurrent.Callable;

public class ActivityReplace implements Callable {
    //attributs qui permettent de donner une vue et un modèle
    private ActivityVue vue;
    private ListActivity model;

    public void setVue(ActivityVue vue) {
        this.vue = vue;
    }

    public ActivityVue getVue() {return vue;}

    public void setModel(ListActivity model) {
        this.model = model;
    }

    public ListActivity getModel() {return model;}


    @Override
    public Object call() throws Exception {
        boolean change = false;

        String oldValue = vue.oldActivityType();
        String confirmString = vue.confirmationActivityType(oldValue);
        String newValue = vue.replaceActivityType();
        boolean confirmation = (confirmString.equalsIgnoreCase("O")?true:false); //transformation d'un String en booléen
        ActivityType activityType;
        boolean inscription = (vue.inscription().equalsIgnoreCase("O")?true:false); //idem
        vue.setError(null);
        vue.setInformation(null);


        //idem que la ligne du dessus
        /*if (confirmString.equalsIgnoreCase("O")){
            confirmation = true;
        } else {
            confirmation = false;
        }*/

        if (!oldValue.equalsIgnoreCase(newValue) && !oldValue.isBlank() && !newValue.isBlank() && confirmation){
            activityType = model.remove(oldValue);
            if (activityType != null){
                activityType.setName(newValue);
                activityType.setRegistration(inscription);
                model.addActivityType(activityType.getName(), activityType.isRegistrationRequired());
                vue.setInformation("L'activité "+oldValue+" a bien été modifiée en "+newValue+" !"); //pas vraiment une erreur, mais pas de println
            } else{
                vue.setError("L'activité type encodée n'est pas présente dans ce fichier.");
            }
        } else{
            vue.setError("Les noms que vous avez encodés sont les mêmes !");
        }
        return null;
    }
}
