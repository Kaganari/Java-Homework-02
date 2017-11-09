package it.sevenbits.packages.reader.implementation;

import it.sevenbits.packages.reader.IReader;
import it.sevenbits.packages.reader.ReaderException;

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
     * Reading file char by char
     * @return one char
     * @throws ReaderException custom reader exception
     */
    public char readChar() throws ReaderException {
        i++;
        return string.charAt(i);
    }

    /**
     * Checking, does the file has more chars or not
     * @return true, if there are more char(s)
     * @throws ReaderException custom reader exception
     */
    public boolean hasMoreChars() throws ReaderException {
        return (i < string.length()-1);
    }
}
