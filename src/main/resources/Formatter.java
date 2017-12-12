if{a;}


import static java.nio.charset.StandardCharsets.*;
public class Formatter {public static void main(final String[] args) throws IOException {int ch, level = 0;char[] fixed;File input = new File();File output = new File();BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(input), UTF_8));BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), UTF_8));FileReader fr = new FileReader(reader);FileWriter fw = new FileWriter(writer);boolean codeStarted = false;boolean spacesPlaced = false;while ((ch = fr.readChar()) != -1) {
            fixed = SymbolFixer.fixSymbol((char) ch, level, codeStarted);
            level = fixed[2];
            //System.out.print(fixed[0]);
            fw.writeChar(output, SymbolFixer.fixSymbol((char) ch, level, codeStarted)[0]);
            if (!spacesPlaced) {
                spacesPlaced = true;
            }
        }
    }
}
