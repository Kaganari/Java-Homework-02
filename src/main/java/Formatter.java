import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by User on 26.10.2017.
 */
public class Formatter {
    public static void main(final String[] args) {
        //String sprt = File.separator;
        //Path codeFilePath = Paths.get("src"+ sprt+"main"+sprt+"resources"+sprt+"code.txt");
        Path codeFilePath = Paths.get("src/main/resources/code.txt");  //Apparently, separator "/" is working for Windows as well. Strange..
        //Path outputFilePath = Paths.get("src/main/resources/codeOutput.txt");
        List<String> lines;
        try{
            lines = Files.readAllLines(codeFilePath, Charset.defaultCharset());
            lines = LineBreaker.LineBreaker((lines));
            lines = Tabulation.Tabulation(lines);
            for (String line : lines) {
                System.out.println(line);
            }
            FileWriter writer = new FileWriter("src/main/resources/codeOutput.txt", false);
            for (int i=0;i<lines.size();i++) {
                writer.write(lines.get(i)+System.lineSeparator());
                writer.flush();
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
