//Normalement, il faut nettoyer son main et mettre quasi tout dans la Factory

package be.technifutur.javaProjet;

import be.technifutur.javaProjet.activités.*;
import be.technifutur.javaProjet.horaire.*;
import be.technifutur.laboJava.serialization.DataStore;
import com.sun.jdi.AbsentInformationException;


public class Main{

    public static void main(String[] args) throws Exception{
        DataStore<ListActivityType> myDataStore = new DataStore<>("test.ser", ListActivityType::new); //création de l'objet DataStore qui va permettre d'enregistrer ce qu'on fait
        ListActivityType listActivity = myDataStore.getData();
        DataStore<Horaire> dataHoraire = new DataStore<>("horaire.ser", Horaire::new);
        Horaire horaire = dataHoraire.getData();
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
        horaireAdd.setModel(horaire);
        horaireAdd.setVue(new HoraireVue());
        horaireAdd.setListActivityType(listActivity);

        HoraireRemove horaireRemove = new HoraireRemove();
        horaireRemove.setModel(new Horaire());
        horaireRemove.setVue(new HoraireVue());
        horaireRemove.setListActivityType(listActivity);

        HoraireModified horaireModified = new HoraireModified();
        horaireModified.setModel(horaire);
        horaireModified.setVue(new HoraireVue());

        try{
            activityAdd.call();
            horaireAdd.call();
            //horaireRemove.call();
            horaireModified.call();
        }catch (Exception e ){
            System.out.println(activityReplace.getVue().getError()); //on affiche une erreur s'il y en a une
        }

        if (activityReplace.getVue().getInformation() != null){ //on affiche une information spécifique s'il y en a une
            throw new AbsentInformationException("Il y a un problème dans la Matrice...");
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
        dataHoraire.save();
    }
}
