package pe.arkidi.tdd;

import java.io.IOException;

public class TyrantCommandTemplate {
    public void process(TyrantMap map, Command command) throws IOException {
        map.open();
        command.doWork(map);
        map.close();
    }
}
