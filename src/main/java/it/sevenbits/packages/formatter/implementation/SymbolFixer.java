package it.sevenbits.packages.formatter.implementation;

import it.sevenbits.packages.formatter.IFormatter;
import it.sevenbits.packages.reader.IReader;
import it.sevenbits.packages.reader.ReaderException;
import it.sevenbits.packages.writer.IWriter;
import it.sevenbits.packages.writer.WriterException;

/**
 * Class contains two static methods - changing symbol and making tabulations
 */
public final class SymbolFixer implements IFormatter {
    private SymbolFixer(){}
    /**
     * Changing symbol and writing it in file
     * @param reader just reader
     * @param writer just writer
     * @throws  ReaderException custom reader exception
     * @throws  WriterException custom writer exception
     */
    public static void fixSymbol(final IReader reader, final IWriter writer) throws ReaderException, WriterException {
        int level = 0;
        boolean codeStarted = false, spacesPlaced = false;
        char previousChar = '\00';
        try {
            while (reader.hasMoreChars()) {
                char inputChar = reader.readChar();
                if (inputChar != ' ' && inputChar != '\n' && inputChar != '\r') {
                    codeStarted = true;

                    if (!spacesPlaced) {
                        if (inputChar != '}') {
                            makeTabulations(level, writer);
                            spacesPlaced = true;
                        } else { // Because "}" must be on one level to the left, than line before it
                            makeTabulations(level - 1, writer);
                            spacesPlaced = true;
                        }
                    }
                }
                if (inputChar == '{' || inputChar == '}' || inputChar == ';') {
                    codeStarted = false;
                    spacesPlaced = false;
                }
                switch (inputChar) {
                    case '{':
                        if (previousChar == ')' || previousChar != ' ') {
                            writer.writeChar(" ");
                        }
                        writer.writeChar("{\n");
                        level++;
                        break;
                    case '}':
                        level--;
                        writer.writeChar("}\n");
                        break;
                    case ';':
                        writer.writeChar(";\n");
                        break;
                    case ' ':
                        if (codeStarted) {
                            writer.writeChar(" ");
                        }
                        break;
                    case '\n':
                        writer.writeChar("");
                        break;
                    case '\r':
                        writer.writeChar("");
                        break;
                    default:
                        writer.writeChar(String.valueOf(inputChar));
                        break;
                }
                if (codeStarted) {
                    previousChar = inputChar;
                }
            }

        } catch (ReaderException e) {
            throw new ReaderException("Can't read from file", e);
        } catch (WriterException e) {
            throw new WriterException("Can't write to the file", e);
        }
    }

    /**
     * @param level level, on which actual code in line should start
     * @param writer just writer
     */
    private static void makeTabulations(final int level, final IWriter writer) throws WriterException {
        for (int i = 0; i < level; i++) {
            try {
                writer.writeChar("    ");
            } catch (WriterException e) {
                throw new WriterException("Can't write to the file", e);
            }

        }
    }
}
