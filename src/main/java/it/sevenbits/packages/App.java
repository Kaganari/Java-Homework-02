package it.sevenbits.packages;

import it.sevenbits.packages.formatter.FormatterException;
import it.sevenbits.packages.formatter.IFormatter;
import it.sevenbits.packages.formatter.implementation.Formatter;
import it.sevenbits.packages.IO.reader.implementation.FileReader;
import it.sevenbits.packages.IO.writer.implementation.FileWriter;
import it.sevenbits.packages.formatter.implementation.betterFormatter.BetterFormatter;
import it.sevenbits.packages.lexer.betterLexer.BetterLexer;
import it.sevenbits.packages.lexer.betterLexer.ILexer;


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
            input = "src/test/resources/Formatter.java";
            output = "src/test/resources/codeOutput.java";
        }
        IFormatter formatter = new BetterFormatter();
        try (
                FileReader reader = new FileReader(input);
                FileWriter writer = new FileWriter(output)
        ) {
            ILexer lexer = new BetterLexer(reader);
            formatter.format(lexer, writer);
        } catch (FormatterException e) {
            throw new FormatterException("Something's wrong", e);
        }
    }
}
