import static org.junit.Assert.*;

import it.sevenbits.packages.SymbolFixer;
import org.junit.*;

/**
 * Created by User on 07.11.2017.
 */
public class SymbolFixerTest {
    @Before
    public void init(){
        String str = "Hello; world";
        char[] chArray = new char[]{';','\n','2'};
    }
    @org.junit.Test
    public void testFixSymbol() throws Exception {
        char[] chArray = new char[]{'}','\n','2'};
        assertEquals(chArray, SymbolFixer.fixSymbol('}',3,true));
    }

}