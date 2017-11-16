package it.sevenbits.packages.formatter.implementation;

import it.sevenbits.packages.formatter.FormatterException;
import it.sevenbits.packages.formatter.IFormatter;
import it.sevenbits.packages.IO.reader.IReader;
import it.sevenbits.packages.IO.reader.ReaderException;
import it.sevenbits.packages.IO.writer.IWriter;
import it.sevenbits.packages.IO.writer.WriterException;

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
     * @param reader just reader
     * @param writer just writer
     * @throws  FormatterException when can't format code
     */
    public void format(final IReader reader, final IWriter writer) throws FormatterException {
        int level = 0;
        boolean codeStarted = false, spacesPlaced = false;
        char previousChar = '\00';
        try {
            while (reader.readChar()) {
                char inputChar = reader.getChar();
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
                            writer.writeChars(" ");
                        }
                        writer.writeChars("{\n");
                        level++;
                        break;
                    case '}':
                        level--;
                        writer.writeChars("}\n");
                        break;
                    case ';':
                        writer.writeChars(";\n");
                        break;
                    case ' ':
                        if (codeStarted) {
                            writer.writeChars(" ");
                        }
                        break;
                    case '\n':
                        writer.writeChars("");
                        break;
                    case '\r':
                        writer.writeChars("");
                        break;
                    default:
                        writer.writeChars(String.valueOf(inputChar));
                        break;
                }
                if (codeStarted) {
                    previousChar = inputChar;
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
