
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by User on 02.11.2017.
 */
interface IReader {
    boolean hasChars(File file) throws IOException;
    int readChar(File file) throws IOException;
}
