package be.technifutur.javaProjet.horaire;

public class HoraireAdd {

    private HoraireVue vue;
    private HoraireModele model;

    public void setVue(HoraireVue vue) {this.vue = vue;}
    public void setModel(HoraireModele model) {this.model = model;}

    public HoraireType call(){
        boolean enregistrement = false;
        vue.setError(null);
        String nameHoraire = vue.putHoraireType();
        model.get(nameHoraire);


        return null;
    }
}
