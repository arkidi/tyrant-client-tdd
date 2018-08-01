package pe.arkidi.tdd;

import java.io.IOException;

public interface Command {
    void doWork(TyrantMap map) throws IOException;
}
