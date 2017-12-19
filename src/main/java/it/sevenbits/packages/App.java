package it.sevenbits.packages;

import it.sevenbits.packages.formatter.FormatterException;
import it.sevenbits.packages.formatter.IFormatter;
import it.sevenbits.packages.IO.reader.implementation.FileReader;
import it.sevenbits.packages.IO.writer.implementation.FileWriter;
import it.sevenbits.packages.stateMachine.stateMachineFormatter.StateMachineFormatter;
import it.sevenbits.packages.stateMachine.stateMachineLexer.StateMachineLexer;
import it.sevenbits.packages.stateMachine.stateMachineLexer.ILexer;


/**
 * Main method for App. Reading file and writing in another.
 */
public final class App {
    private App(){}
    /**
     * @param args will be taken as input and output file paths respectively
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
            //input = "src/test/resources/CommandRepositoryTemp.java";
            output = "src/test/resources/codeOutput.java";
        }
        IFormatter formatter = new StateMachineFormatter();
        try (
                FileReader reader = new FileReader(input);
                FileWriter writer = new FileWriter(output)
        ) {
            ILexer lexer = new StateMachineLexer(reader);
            formatter.format(lexer, writer);
        } catch (FormatterException e) {
            throw new FormatterException("Something's wrong", e);
        }
    }
}
