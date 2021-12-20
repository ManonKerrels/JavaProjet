package be.technifutur.javaProjet;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) throws Exception {
        ProjetFactory projetFactory = new ProjetFactory();
        JavaControler javaControler = new JavaControler();
        Callable action;
        action = javaControler.getAction();

        if(action != null){
            action.call();
        } else {
            System.out.println("Au revoir !");
        }

    }
}
