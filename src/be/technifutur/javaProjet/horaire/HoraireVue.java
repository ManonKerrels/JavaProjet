package be.technifutur.javaProjet.horaire;

import java.util.Scanner;

public class HoraireVue {
    private Scanner input = new Scanner(System.in);
    private String error = null;
    private String information = null;


    public void setError(String error) {this.error = error;}

    public String getError() {return error;}

    public void setInformation(String information) {this.information = information;}

    public String getInformation() {return information;}

    public String putHoraireType(){
        System.out.println("Veuillez encoder l'horaire choisi : ");
        return input.nextLine();
    }
}
