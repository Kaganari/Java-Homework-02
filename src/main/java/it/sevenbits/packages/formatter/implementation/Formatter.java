package it.sevenbits.packages.formatter.implementation;

import it.sevenbits.packages.formatter.FormatterException;
import it.sevenbits.packages.formatter.IFormatter;
import it.sevenbits.packages.IO.reader.IReader;
import it.sevenbits.packages.IO.reader.ReaderException;
import it.sevenbits.packages.IO.writer.IWriter;
import it.sevenbits.packages.IO.writer.WriterException;
import it.sevenbits.packages.lexer.ILexer;
import it.sevenbits.packages.lexer.IToken;
import it.sevenbits.packages.lexer.LexerException;
import it.sevenbits.packages.lexer.Token;

/**
 * Class contains two static methods - changing symbol and making tabulations
 */
public final class Formatter implements IFormatter {
    /**
     * Empty constructor
     */
    public Formatter(){}
    /**
     * Changing symbol and writing it in file
     * @param lexer just lexer
     * @param writer just writer
     * @throws  FormatterException when can't format code
     */
    public void format(final ILexer lexer, final IWriter writer) throws FormatterException {
        int level = 0;
        boolean codeStarted = false, spacesPlaced = false;
        IToken previousToken = new Token(" ", " ");
        try {
            while (lexer.hasMoreTokens()) {
                IToken token = lexer.readToken();
                String name = token.getName();
                String lexeme = token.getLexeme();
                if (!name.equals("whiteSpace") && !name.equals("newLine")) {
                    codeStarted = true;
                    if (!spacesPlaced) {
                        if (!name.equals("bracketClose")) {
                            makeTabulations(level, writer);
                            spacesPlaced = true;
                        } else { // Because "}" must be on one level to the left, than line before it
                            makeTabulations(level - 1, writer);
                            spacesPlaced = true;
                        }
                    }
                }
                if (name.equals("bracketOpen") || name.equals("bracketClose") || name.equals("semicolon")) {
                    codeStarted = false;
                    spacesPlaced = false;
                }
                //Switch
                if (name.equals("bracketOpen")) {
                    if (previousToken.getLexeme().equals(")") || !previousToken.getName().equals("whiteSpace")) {
                        writer.writeChars(" ");
                    }
                    writer.writeChars("{\n");
                    level++;
                }
                if (name.equals("bracketClose")) {
                    level--;
                    writer.writeChars("}\n");
                }
                if (name.equals("semicolon")) {
                    writer.writeChars(";\n");
                }
                if (name.equals("whiteSpace")) {
                    if (codeStarted) {
                        writer.writeChars(" ");
                    }
                }
                if (name.equals("newLine")) {
                    writer.writeChars("");
                }
                if (name.equals("otherChar")) {
                    writer.writeChars(lexeme);
                }
                if (codeStarted) {
                    previousToken = token;
                }
            }

        } catch (ReaderException | WriterException e) {
            throw new FormatterException("Something's wrong", e);
        }
    }

    /**
     * @param level level, on which actual code in line should start
     * @param writer just writer
     */
    private static void makeTabulations(final int level, final IWriter writer) throws WriterException {
        for (int i = 0; i < level; i++) {
            try {
                writer.writeChars("    ");
            } catch (WriterException e) {
                throw new WriterException("Can't write to the file", e);
            }

        }
    }
}
