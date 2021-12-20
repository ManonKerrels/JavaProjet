package be.technifutur.javaProjet;

import java.util.concurrent.Callable;

public interface JavaNode {

    void setAction(Callable action);

    Callable getAction();
    String getName();
}
