package it.sevenbits.packages.formatter.implementation;

import it.sevenbits.packages.formatter.FormatterException;
import it.sevenbits.packages.formatter.IFormatter;
import it.sevenbits.packages.IO.writer.IWriter;
import it.sevenbits.packages.IO.writer.WriterException;
import it.sevenbits.packages.lexer.betterLexer.ILexer;
import it.sevenbits.packages.token.IToken;
import it.sevenbits.packages.lexer.LexerException;
import it.sevenbits.packages.token.Token;

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
                if (!name.equals("space") && !name.equals("newline")) {
                    codeStarted = true;
                    if (!spacesPlaced) {
                        if (!name.equals("closebracket")) {
                            makeTabulations(level, writer);
                            spacesPlaced = true;
                        } else { // Because "}" must be on one level to the left, than line before it
                            makeTabulations(level - 1, writer);
                            spacesPlaced = true;
                        }
                    }
                }
                if (name.equals("openbracket") || name.equals("closebracket") || name.equals("semicolon")) {
                    codeStarted = false;
                    spacesPlaced = false;
                }
                //Switch
                if (name.equals("openbracket")) {
                    if (previousToken.getLexeme().equals(")") || !previousToken.getName().equals("space")) {
                        writer.write(" ");
                    }
                    writer.write("{\n");
                    level++;
                }
                if (name.equals("openbracket")) {
                    level--;
                    writer.write("}\n");
                }
                if (name.equals("semicolon")) {
                    writer.write(";\n");
                }
                if (name.equals("space")) {
                    if (codeStarted) {
                        writer.write(" ");
                    }
                }
                if (name.equals("newline")) {
                    writer.write("");
                }
                if (name.equals("char")) {
                    writer.write(lexeme);
                }
                if (codeStarted) {
                    previousToken = token;
                }
            }

        } catch (WriterException | LexerException e) {
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
                writer.write("    ");
            } catch (WriterException e) {
                throw new WriterException("Can't write to the file", e);
            }

        }
    }
}
