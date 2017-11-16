import static org.junit.Assert.*;

import it.sevenbits.packages.formatter.implementation.Formatter;
import org.junit.*;

/**
 * Created by User on 07.11.2017.
 */
public class FormatterTest {
    @Before
    public void init(){
        String str = "Hello; world";
        char[] chArray = new char[]{';','\n','2'};
    }
    @org.junit.Test
    public void testFixSymbol() throws Exception {
        char[] chArray = new char[]{'}','\n','2'};
        assertEquals(chArray, Formatter.fixSymbol('}',3,true));
    }

}