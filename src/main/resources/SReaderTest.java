import it.sevenbits.packages.SReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 07.11.2017.
 */
public class SReaderTest {
    @Before
    public void init(){
        SReader reader = new SReader("Hello, World!", 5);
    }
    @Test
    public void testReadChar() throws Exception {
        SReader reader = new SReader("Hello, World!", 5);
        assertEquals(',',(char)reader.readChar());
    }

}