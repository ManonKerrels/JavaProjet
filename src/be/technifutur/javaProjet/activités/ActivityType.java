package be.technifutur.javaProjet.activités;

public class ActivityType {
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

    public void setName() {this.name = name;}

    public void setRegistration(boolean registration) {this.registration = registration;} //???


    @Override
    public String toString() {
        return "ActivityType{" +
                "name='" + name + '\'' +
                ", registration=" + registration +
                '}';
    }
}
