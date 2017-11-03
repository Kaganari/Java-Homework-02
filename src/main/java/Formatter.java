import sun.nio.cs.UTF_32LE;

import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.charset.StandardCharsets.*;

/**
 * Main method for Formatter. Reading file and writing in another.
 */
public class Formatter {
    public static void main(final String[] args) throws IOException {

        /*//String sprt = File.separator;
        //Path codeFilePath = Paths.get("src"+ sprt+"main"+sprt+"resources"+sprt+"code.txt");
        Path codeFilePath = Paths.get("src/main/resources/code.txt");
        //Apparently, separator "/" is working for Windows as well. Strange..
        //Path outputFilePath = Paths.get("src/main/resources/codeOutput.txt");
        List<String> lines;
        try {
            lines = Files.readAllLines(codeFilePath, Charset.defaultCharset());
            lines = LineBreaker.createLineBreaks((lines));
            lines = Tabulation.createTabulation(lines);
            FileWriter writer = new FileWriter("src/main/resources/codeOutput.txt", false);
            for (String line : lines) {
                writer.write(line + System.lineSeparator());
                writer.flush();
            }
            //System.out.println(i);
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        File input = new File("src/main/resources/Formatter.java");
        File output = new File("src/main/resources/codeOutput.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(input), UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output),UTF_8));
        FileReader f_r = new FileReader(input);
        FReader fr = new FReader(reader);
        FWriter fw = new FWriter(writer);

        while (fr.readChar(input) != -1) {
            System.out.print( (char) fr.readChar(input));
            //fw.writeChar(output, (char) fr.readChar(input));
        }
    }
}
