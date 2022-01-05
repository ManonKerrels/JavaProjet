//Normalement, il faut nettoyer son main et mettre quasi tout dans la Factory

package be.technifutur.javaProjet;

import be.technifutur.javaProjet.activités.*;
import be.technifutur.javaProjet.horaire.*;
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

        HoraireAdd horaireAdd = new HoraireAdd();
        horaireAdd.setModel(new Horaire());
        horaireAdd.setVue(new HoraireVue());
        horaireAdd.setListActivityType(listActivity);

        HoraireRemove horaireRemove = new HoraireRemove();
        horaireRemove.setModel(new Horaire());
        horaireRemove.setVue(new HoraireVue());
        horaireRemove.setListActivityType(listActivity);

        HoraireModified horaireModified = new HoraireModified();
        horaireModified.setModel(new Horaire());
        horaireModified.setVue(new HoraireVue());
        horaireModified.setListActivityType(listActivity);


        for(int i = 0; i < 2; i++){
            activityAdd.call();
            horaireAdd.call();
            //horaireRemove.call();
            horaireModified.call();
        }
        if (activityReplace.getVue().getError() != null){ //on affiche l'erreur s'il y en a une
            System.out.println(activityReplace.getVue().getError());
        }
        if (activityReplace.getVue().getInformation() != null){ //on affiche une information spécifique s'il y en a une
            System.out.println(activityReplace.getVue().getInformation());
        }



       /*for (int i = 0; i < 1; i++){
            activityReplace.call();
        }
        if (activityReplace.getVue().getError() != null){ //idem au-dessus
            System.out.println(activityReplace.getVue().getError());
        }
        if (activityReplace.getVue().getInformation() != null){
            System.out.println(activityReplace.getVue().getInformation());
        }*/

        myDataStore.save();
    }
}
