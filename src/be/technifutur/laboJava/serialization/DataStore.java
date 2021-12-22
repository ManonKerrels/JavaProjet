package be.technifutur.laboJava.serialization;

import java.io.*;
import java.util.ServiceLoader;
import java.util.function.Supplier;

public class DataStore<D extends Serializable> { //classe qui va permettre d'enregistrer ce qu'on fait

    //3 attributs privés
    private final Supplier<D> supplier;
    private String file;
    private D data;

    //méthode publique pour fournir un résultat
    public DataStore(String fileName, Supplier<D> supplier) {
        file = fileName;
        this.supplier = supplier;
    }

    //méthode publique pour intégrer des données
    public D getData() {
        if (data == null) {
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
                data = (D) input.readObject();
            } catch (FileNotFoundException e) {
                data = supplier.get();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    //méthode qui retourne la sauvegarde
    public void save() {
        if (data != null) {
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))) {
                output.writeObject(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}