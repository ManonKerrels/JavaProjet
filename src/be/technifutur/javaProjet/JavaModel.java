//Endroit de stockage
//Vérification que les éléments de l'intérieur sont vrais ou faux (éléments ajoutés/modifiés par un autre programme)

package be.technifutur.javaProjet;

import java.io.Serializable;
import java.util.ArrayList;

public class JavaModel implements Serializable {
    //attributs privés
    private ArrayList<JavaNode> javaNodeArrayList = new ArrayList<>();
    private String name;

    public JavaModel(String name) {this.name = name;}

    public String getName() {return this.name;}

    //méthode publique pour vérifier que la position dans le tableau est correcte
    public JavaNode getJavaNode(int pos){
        if(pos > javaNodeArrayList.size() || pos < 0){
            return null;
        } else {
            return javaNodeArrayList.get(pos);
        }
    }

    //méthode pour avoir la taille du tableau
    public int getSize() {return javaNodeArrayList.size();}

    //méthode pour ajouter le JavaNode au tableau
    public void addJavaNode(JavaNode javaNode){javaNodeArrayList.add(javaNode);}
}