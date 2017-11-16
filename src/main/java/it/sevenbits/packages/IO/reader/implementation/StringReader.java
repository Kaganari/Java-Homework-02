package it.sevenbits.packages.IO.reader.implementation;

import it.sevenbits.packages.IO.reader.IReader;
import it.sevenbits.packages.IO.reader.ReaderException;

/**
 * Implementation of IReader for reading from strings
 */
public class StringReader implements IReader {
    private int i = -1;
    private String string;
    /**
     * Class constructor
     * @param inputString input string for reading
     * @throws ReaderException custom reader exception
     */
    public StringReader(final String inputString) throws ReaderException {
        string = inputString;
    }

    /**
     * Returning read char
     * @return one char
     * @throws ReaderException custom reader exception
     */
    public char getChar() throws ReaderException {
        i++;
        return string.charAt(i);
    }

    /**
     * Checking, does the string has more chars and reading one
     * @return true, if there are more char(s)
     * @throws ReaderException custom reader exception
     */
    public boolean readChar() throws ReaderException {
        return (i < string.length() - 1);
    }
}
