package it.sevenbits.packages;

import it.sevenbits.packages.formatter.implementation.SymbolFixer;
import it.sevenbits.packages.reader.implementation.FileReader;
import it.sevenbits.packages.writer.implementation.FileWriter;

import java.io.IOException;

/**
 * Main method for Formatter. Reading file and writing in another.
 */
public final class Formatter {
    private Formatter(){}
    /**
     * @param args from here will be taken input and output file paths
     * @throws IOException exception
     */
    public static void main(final String[] args) throws IOException {
        String input;
        String output;
        if (args.length == 2) {
            input = args[0];
            output = args[1];
        } else {
            input = "src/main/resources/Formatter.java";
            output = "src/main/resources/codeOutput.java";
        }
        FileReader reader = new FileReader(input);
        FileWriter writer = new FileWriter(output);
        SymbolFixer.fixSymbol(reader, writer);
        reader.close();
        writer.close();
    }
}
