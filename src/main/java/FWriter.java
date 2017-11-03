import java.io.*;

/**
 * Created by User on 02.11.2017.
 */
public class FWriter implements IWriter {

    private BufferedWriter bw;
    FWriter(final BufferedWriter bw) {
        this.bw = bw;
    }
    public void writeChar(final File file, final int ch) throws IOException {
        bw.write(ch);
        bw.close();
    }
}
