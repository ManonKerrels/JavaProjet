package be.technifutur.javaProjet.activités;

import java.util.concurrent.Callable;

public class ActivityReplace implements Callable {
    //attributs qui permettent de donner une vue et un modèle
    private ActivityVue vue;
    private ListActivityType model;

    public void setVue(ActivityVue vue) {
        this.vue = vue;
    }

    public ActivityVue getVue() {return vue;}

    public void setModel(ListActivityType model) {
        this.model = model;
    }

    public ListActivityType getModel() {return model;}


    @Override
    public Object call() throws Exception {
        boolean change = false;

        String oldValue = vue.oldActivityType(); //association de l'oldValue à la partie de la vue qui le concerne
        String confirmString = vue.confirmationActivityType(oldValue); //association de la confirmation à la partie de la vue qui le concerne
        String newValue = vue.replaceActivityType(); //association de la newValue à la partie de la vue qui le concerne
        boolean confirmation = (confirmString.equalsIgnoreCase("O")?true:false); //transformation d'un String en booléen
        ActivityType activityType; //déclaration d'une variable de type ActivityType
        boolean inscription = (vue.inscription().equalsIgnoreCase("O")?true:false); //idem
        vue.setError(null); //message d'erreur mis à la valeur null
        vue.setInformation(null); //idem message d'information


        //idem que la ligne du dessus
        /*if (confirmString.equalsIgnoreCase("O")){
            confirmation = true;
        } else {
            confirmation = false;
        }*/

        if (!oldValue.equalsIgnoreCase(newValue) && !oldValue.isBlank() && !newValue.isBlank() && confirmation){ //si les deux valeurs sont différentes, et aucune des deux ne sont nulles
            activityType = model.remove(oldValue); //on retire l'ancienne valeur de la map
            if (activityType != null){ //si la variable activité est bien présente
                activityType.setName(newValue); //on lui donne un nom
                activityType.setRegistration(inscription); //on lui passe le booléen
                model.addActivityType(activityType.getName(), activityType.isRegistrationRequired()); //on fait appel au model
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
