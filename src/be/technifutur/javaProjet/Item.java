package be.technifutur.javaProjet;

import java.util.concurrent.Callable;

public class Item {

    private String name;
    private Callable action;

    public void setName(String name) { this.name = name;}
    public void setAction(Callable action) {this.action = action;}


    public Callable getAction() {return action;}
    public String getName() {return name;}

    //Attributs et méthodes
    //Get/set Name

}
