package it.sevenbits.packages;

import it.sevenbits.packages.reader.IReader;
import it.sevenbits.packages.reader.ReaderException;
import it.sevenbits.packages.writer.IWriter;
import it.sevenbits.packages.writer.WriterException;

/**
 * Class contains two static methods - changing symbol and making tabulations
 */
public final class SymbolFixer {
    private SymbolFixer(){}
    /**
     * Changing symbol and writing it in file
     * @param reader just reader
     * @param writer just writer
     */
    static void fixSymbol(final IReader reader, final IWriter writer) throws ReaderException, WriterException {
        int level = 0;
        boolean codeStarted = false, spacesPlaced = false;
        char previousChar = '\00';
        try {
            while (reader.hasMoreChars()) {
                char inputChar = reader.readChar();
                if (inputChar != ' ' && inputChar != '\n') {
                    codeStarted = true;
                }
                if (inputChar == '{' || inputChar == '}' || inputChar == ';') {
                    codeStarted = false;
                    spacesPlaced = false;
                }
                if (inputChar == '\n') {
                    continue;
                }
                switch (inputChar) {
                    case '{':
                        if (previousChar == ')' && inputChar != ';' && inputChar != ' ') {
                            writer.writeChar(" ");
                        }
                        writer.writeChar("{\n");
                        level++;
                        break;
                    case '}':
                        writer.writeChar("\n");
                        makeTabulations(level - 1, writer);
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
                        //writer.writeChar("");
                        break;
//                    case '\r':
//                        writer.writeChar("");
//                        break;
                    default:
                        writer.writeChar(String.valueOf(inputChar));
                        break;
                }
                previousChar = inputChar;
                if (!spacesPlaced) {
                    makeTabulations(level, writer);
                    spacesPlaced = true;
                }
            }
            //writer.close();
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
