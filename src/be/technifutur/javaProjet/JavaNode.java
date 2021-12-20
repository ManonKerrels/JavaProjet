package be.technifutur.javaProjet;

import java.util.concurrent.Callable;

public interface JavaNode {
    Callable getAction();
    String getName();
}
