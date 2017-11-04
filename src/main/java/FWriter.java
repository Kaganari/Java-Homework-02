import java.io.*;

/**
 * Created by User on 02.11.2017.
 */
public class FWriter implements IWriter {

    private BufferedWriter bw;
    FWriter(final BufferedWriter bw) {
        this.bw = bw;
    }
    public void writeChar(final File file, final char ch) throws IOException {
        bw.write(ch);
        bw.flush();
    }
    public void writeChar(final File file, final String ch) throws IOException {
        bw.write(ch);
        bw.flush();
    }
}
