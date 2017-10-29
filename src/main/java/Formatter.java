import java.io.File;
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
        //Path testFilePath = Paths.get("src"+ sprt+"main"+sprt+"resources"+sprt+"code.txt");
        Path codeFilePath = Paths.get("src/main/resources/code.txt");//Apparently, separator "/" is working for Windows as well. Strange..
        try{
            List<String> lines = Files.readAllLines(codeFilePath, Charset.defaultCharset());
            lines = LineBreaker.LineBreaker((lines));
            lines = Tabulation.Tabulation(lines);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
