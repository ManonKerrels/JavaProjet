//modèle

package be.technifutur.javaProjet.factory;

import java.io.Serializable;

public class ActivityType implements Serializable {
    //2 attributs (un public et un privé)
    public String name;
    private boolean registration;

    //constructeur qui instancient les 2 attributs
    public ActivityType(String name, boolean registration) {
        this.name = name;
        this.registration = registration;
    }

    public String getName() {return name;}

    public boolean isRegistrationRequired() {return registration;}

    public void setName(String name) {this.name = name;}

    public void setRegistration(boolean registration) {this.registration = registration;}


    @Override
    public String toString() {
        return "ActivityType{" +
                "name='" + name + '\'' +
                ", registration=" + registration +
                '}';
    }
}
