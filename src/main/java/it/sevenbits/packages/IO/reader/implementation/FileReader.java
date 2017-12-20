package it.sevenbits.packages.IO.reader.implementation;

import it.sevenbits.packages.IO.CloseException;
import it.sevenbits.packages.IO.IClosable;
import it.sevenbits.packages.IO.reader.IReader;
import it.sevenbits.packages.IO.reader.ReaderException;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * FileReader class. Reading chars and checking for more chars in file.
 */
public class FileReader implements IReader, IClosable {
    private BufferedReader reader;
    private int preReadChar = -1;

    /**
     * Class constructor
     * @param fileName name of input file
     * @throws ReaderException custom reader exception
     */
    public FileReader(final String fileName) throws ReaderException {
        try {
            //fileInputStream = new BufferedInputStream(new FileInputStream(fileName));
            reader = new BufferedReader(new java.io.FileReader(fileName));
            preReadChar = reader.read();
        } catch (IOException e) {
            throw new ReaderException("Cannot find a file with such name.", e);
        }
    }

    /**
     * Returning read char
     * @return one char
     * @throws ReaderException custom reader exception
     */
    public boolean hasMoreChars() throws ReaderException {
        return preReadChar >= 0;
    }

    /**
     * Checking, does the file has more chars and reading one
     * @return true, if there are more char(s)
     * @throws ReaderException custom reader exception
     */
    public char readChar() throws ReaderException {
        try {
            int prevChar = preReadChar;
            preReadChar = reader.read();
            return (char) prevChar;
        } catch (Exception e) {
            throw new ReaderException("Can't read file", e);
        }
    }
    @Override
    public void close() throws CloseException {
        try {
            reader.close();
        } catch (IOException e) {
            throw new CloseException("Can't close the file", e);
        }
    }
}
