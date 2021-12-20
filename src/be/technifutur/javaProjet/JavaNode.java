package be.technifutur.javaProjet;

import java.util.concurrent.Callable;

public interface JavaNode {

    Callable setAction(Callable action);

    Callable getAction();
    String getName();
}
