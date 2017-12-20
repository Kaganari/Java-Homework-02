package it.sevenbits.packages.IO.reader.implementation;

import it.sevenbits.packages.IO.reader.IReader;
import it.sevenbits.packages.IO.reader.ReaderException;

/**
 * Implementation of IReader for reading from strings
 */
public class StringReader implements IReader {
    private int position = -1;
    private String inputString;
    /**
     * Class constructor
     * @param inputString input string for reading
     */
    public StringReader(final String inputString) {
        this.inputString = inputString;
    }

    /**
     * Returning read char
     * @return one char
     */
    public boolean hasMoreChars() {
        return (position < inputString.length() - 1);
    }

    /**
     * Checking, does the string has more chars and reading one
     * @return true, if there are more char(s)
     * @throws ReaderException custom reader exception
     */
    public char readChar() throws ReaderException {
        position++;
        return inputString.charAt(position);
    }
}
