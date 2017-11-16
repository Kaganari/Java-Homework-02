package it.sevenbits.packages;

import it.sevenbits.packages.formatter.FormatterException;
import it.sevenbits.packages.formatter.implementation.Formatter;
import it.sevenbits.packages.IO.reader.implementation.FileReader;
import it.sevenbits.packages.IO.writer.implementation.FileWriter;

import java.io.IOException;

/**
 * Main method for App. Reading file and writing in another.
 */
public final class App {
    private App(){}
    /**
     * @param args from here will be taken input and output file paths
     * @throws Exception exception
     */
    public static void main(final String[] args) throws Exception {
        String input;
        String output;
        if (args.length == 2) {
            input = args[0];
            output = args[1];
        } else {
            input = "src/main/resources/Formatter.java";
            output = "src/main/resources/codeOutput.java";
        }
        Formatter formatter = new Formatter();
        try (
                FileReader reader = new FileReader(input);
                FileWriter writer = new FileWriter(output);
        ) {
            formatter.format(reader, writer);
        } catch (FormatterException e) {
            throw new FormatterException("Something's wrong", e);
        }
    }
}