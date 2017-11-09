package it.sevenbits.packages;

import it.sevenbits.packages.reader.implementation.FileReader;
import it.sevenbits.packages.reader.IReader;
import it.sevenbits.packages.writer.implementation.FileWriter;
import it.sevenbits.packages.writer.IWriter;

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
        String input = "src/main/resources/Formatter.java";
        String output = "src/main/resources/codeOutput.java";
        IReader reader = new FileReader(input);
        IWriter writer = new FileWriter(output);
        SymbolFixer.fixSymbol(reader, writer);
    }
}
