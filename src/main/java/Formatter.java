import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Main method for Formatter. Reading file and writing in another.
 */
public class Formatter {
    public static void main(final String[] args) {
        //String sprt = File.separator;
        //Path codeFilePath = Paths.get("src"+ sprt+"main"+sprt+"resources"+sprt+"code.txt");
        Path codeFilePath = Paths.get("src/main/resources/code.txt");
        //Apparently, separator "/" is working for Windows as well. Strange..
        //Path outputFilePath = Paths.get("src/main/resources/codeOutput.txt");
        List<String> lines;
        try {
            lines = Files.readAllLines(codeFilePath, Charset.defaultCharset());
            lines = LineBreaker.createLineBreaks((lines));
            lines = Tabulation.createTabulation(lines);
            for (String line : lines) {
                System.out.println(line);
            }
            FileWriter writer = new FileWriter("src/main/resources/codeOutput.txt", false);
            for (String line : lines) {
                writer.write(line + System.lineSeparator());
                writer.flush();
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
