{
a
}
import java.io.*;
import static java.nio.charset.StandardCharsets.*;

/**
 * Main method for Formatter. Reading file and writing in another.
 */
public class Formatter {
    public static void main(final String[] args) throws IOException {
        int ch, level = 0;
        char[] fixed;
        File input = new File("src/main/resources/Formatter.java");
        File output = new File("src/main/resources/codeOutput.java");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(input), UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), UTF_8));
        FReader fr = new FReader(reader);
        FWriter fw = new FWriter(writer);
        boolean codeStarted = false;
        boolean spacesPlaced = false;
        while ((ch = fr.readChar(input)) != -1) {
            if ((char) ch != ' ' && (char) ch != '\n') {
                codeStarted = true;
            }
            if ((char) ch == '\n') {
                codeStarted = false;
                spacesPlaced = false;
            }
            fixed = SymbolFixer.fixSymbol((char) ch, level, codeStarted);
            level = fixed[2];
            //System.out.print(fixed[0]);
            fw.writeChar(output, SymbolFixer.fixSymbol((char) ch, level, codeStarted)[0]);
            if (!codeStarted && !spacesPlaced) {
                for (int i = 0; i < level; i++) {
                    fw.writeChar(output, "    ");
                }
                spacesPlaced = true;
            }
            if ((char) ch == '}') {
                level++;
            }
        }
    }
}
