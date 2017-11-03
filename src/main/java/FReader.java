import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 * Created by User on 02.11.2017.
 */
public class FReader implements IReader {

    private BufferedReader fr;

    FReader(final BufferedReader f_r) {
        fr = f_r;
    }
    public boolean hasChars(final File file) throws IOException {
        //FileReader fr = new FileReader(file);
        return fr.read() != -1;
    }
    public int readChar(final File file) throws IOException {
        //FileReader fr = new FileReader(file);
        return fr.read();
    }
}
