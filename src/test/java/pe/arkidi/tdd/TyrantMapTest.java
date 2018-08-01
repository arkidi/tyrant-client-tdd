package pe.arkidi.tdd;

import java.io.IOException;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TyrantMapTest {

    @Test
    public void nothing() {
    }

    @Test
    public void get_retrieves_what_was_put() throws IOException {
        TyrantMap map = new TyrantMap();
        byte[] key = "key".getBytes();
        byte[] value = "가나다라마바사".getBytes();

        map.open();
        map.put(key, value);
        assertThat(map.get(key), is(value));
        map.close();
    }

    @Test
    public void can_tyrant_command_template() throws IOException {
        TyrantMap map = new TyrantMap();
        TyrantCommandTemplate commandTemplate = new TyrantCommandTemplate();
        commandTemplate.process(map, new Command() {
            @Override
            public void doWork(TyrantMap map) throws IOException {
                byte[] key = "key".getBytes();
                byte[] value = "가나다라마바사".getBytes();
                map.put(key, value);
                assertThat(map.get(key), is(value));
            }
        });
    }

}
