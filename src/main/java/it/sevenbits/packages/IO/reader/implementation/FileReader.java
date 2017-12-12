package it.sevenbits.packages.IO.reader.implementation;

import it.sevenbits.packages.IO.CloseException;
import it.sevenbits.packages.IO.IClosable;
import it.sevenbits.packages.IO.reader.IReader;
import it.sevenbits.packages.IO.reader.ReaderException;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * FileReader class. Reading chars and checking for more chars in file.
 */
public class FileReader implements IReader, IClosable {
    private int ch;
    private BufferedInputStream fileInputStream;
    private int preReadChar = -1;

    /**
     * Class constructor
     * @param fileName name of input file
     * @throws ReaderException custom reader exception
     */
    public FileReader(final String fileName) throws ReaderException {
        try {
            fileInputStream = new BufferedInputStream(new FileInputStream(fileName));
            preReadChar = fileInputStream.read();
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
            preReadChar = fileInputStream.read();
            return (char) prevChar;
        } catch (Exception e) {
            throw new ReaderException("Can't read file", e);
        }
    }
    @Override
    public void close() throws CloseException {
        try {
            fileInputStream.close();
        } catch (IOException e) {
            throw new CloseException("Can't close the file", e);
        }
    }
}
