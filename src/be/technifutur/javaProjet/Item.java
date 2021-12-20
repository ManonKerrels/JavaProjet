//Attributs et méthodes


package be.technifutur.javaProjet;

import java.util.concurrent.Callable;

public class Item implements JavaNode{

    //Création de 2 attributs
    private String name;
    private Callable action;


    //Création des méthodes setName/setAction
    public void setName(String name) { this.name = name;}

    @Override
    public Callable setAction(Callable action) {this.action = action;
        return action;
    }


    //Création des méthodes getName/getAction
    public Callable getAction() {return action;}

    @Override
    public String getName() {return name;}


}
