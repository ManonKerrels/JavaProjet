//Normalement, il faut nettoyer son main et mettre quasi tout dans la Factory

package be.technifutur.javaProjet;

import be.technifutur.javaProjet.factory.*;
import be.technifutur.javaProjet.controlers.*;
import be.technifutur.javaProjet.modeles.*;
import be.technifutur.javaProjet.vues.ActivityVue;
import be.technifutur.javaProjet.vues.HoraireVue;
import be.technifutur.laboJava.serialization.DataStore;
import com.sun.jdi.AbsentInformationException;

import java.util.concurrent.Callable;


public class Main{

    public static void main(String[] args) throws Exception{

        //ListActivityType listActivity = myDataStore.getData();
        //Horaire horaire = dataHoraire.getData();
        //TODO faire passer les données dans la Factory


        ProjetFactory projetFactory = new ProjetFactory();
        try{
            JavaControler toto = projetFactory.getControllerPrincipal();
            Callable dede = toto.getAction();
            dede.call();
        }catch (Exception e){
            //System.out.println(activityReplace.getVue().getError()); //on affiche une erreur s'il y en a une
            e.printStackTrace();
        }

        /*if (projetFactory.getActivityReplace.getVue().getInformation() == null){ //on affiche une information spécifique s'il y en a une
            throw new AbsentInformationException("Il y a un problème dans la Matrice...");
        }*/

        projetFactory.activityDataStore.save();
        projetFactory.horaireDataStore.save();
    }
}
