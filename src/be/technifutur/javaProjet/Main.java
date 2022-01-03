//Normalement, il faut nettoyer son main et mettre quasi tout dans la Factory

package be.technifutur.javaProjet;

import be.technifutur.javaProjet.activités.*;
import be.technifutur.laboJava.serialization.DataStore;

public class Main{

    public static void main(String[] args) throws Exception{
        DataStore<ListActivityType> myDataStore = new DataStore<>("test.ser", ListActivityType::new); //création de l'objet DataStore qui va permettre d'enregistrer ce qu'on fait
        ListActivityType listActivity = myDataStore.getData();
        System.out.println(listActivity.map);


        ActivityAdd activityAdd = new ActivityAdd();
        activityAdd.setModel(listActivity);
        activityAdd.setVue(new ActivityVue());

        ActivityRemove activityRemove = new ActivityRemove();
        activityRemove.setModel(listActivity);
        activityRemove.setVue(new ActivityVue());

        ActivityReplace activityReplace = new ActivityReplace();
        activityReplace.setModel(listActivity);
        activityReplace.setVue(new ActivityVue());


        for(int i = 0; i < 2; i++){
            activityAdd.call();
        }
        if (activityReplace.getVue().getError() != null){ //on affiche l'erreur s'il y en a une
            System.out.println(activityReplace.getVue().getError());
        }
        if (activityReplace.getVue().getInformation() != null){ //on affiche une information spécifique s'il y en a une
            System.out.println(activityReplace.getVue().getInformation());
        }




       for (int i = 0; i < 1; i++){
            activityReplace.call();
        }
        if (activityReplace.getVue().getError() != null){ //idem au-dessus
            System.out.println(activityReplace.getVue().getError());
        }
        if (activityReplace.getVue().getInformation() != null){
            System.out.println(activityReplace.getVue().getInformation());
        }

        myDataStore.save();
    }
}
