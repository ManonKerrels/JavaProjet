package be.technifutur.javaProjet;

import com.sun.jdi.AbsentInformationException;

import java.util.concurrent.Callable;


public class Main{

    public static void main(String[] args) throws Exception{
        ProjetFactory projetFactory = new ProjetFactory();
        JavaControler toto = projetFactory.getControllerPrincipal();
        Callable<Object> action= toto.getAction();

        while (action != null){
            try{
                action.call();
                action = toto.getAction();
            }catch (NumberFormatException e){
                throw new AbsentInformationException("Il y a un problème dans la Matrice..."); //on affiche une erreur s'il y en a une
            }
        }

        System.out.println("Vous êtes sorti(e) de la Matrice !");

        projetFactory.activityDataStore.save();
        projetFactory.horaireDataStore.save();
    }
}
