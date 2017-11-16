package it.sevenbits.packages.IO.reader.implementation;

import it.sevenbits.packages.IO.IClosable;
import it.sevenbits.packages.IO.reader.IReader;
import it.sevenbits.packages.IO.reader.ReaderException;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * FileReader class. Reading chars and checking for more chars in file.
 */
public class FileReader implements IReader, IClosable {
    private int ch;
    private BufferedInputStream fileInputStream;

    /**
     * Class constructor
     * @param fileName name of input file
     * @throws ReaderException custom reader exception
     */
    public FileReader(final String fileName) throws ReaderException {
        try {
            fileInputStream = new BufferedInputStream(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            throw new ReaderException("Cannot find a file with such name.", e);
        }
    }

    /**
     * Returning read char
     * @return one char
     * @throws ReaderException custom reader exception
     */
    public char getChar() throws ReaderException {
        return (char) ch;
    }

    /**
     * Checking, does the file has more chars and reading one
     * @return true, if there are more char(s)
     * @throws ReaderException custom reader exception
     */
    public boolean readChar() throws ReaderException {
        try {
            ch = fileInputStream.read();
            return ch != -1;
        } catch (Exception e) {
            throw new ReaderException("Can't read file", e);
        }
    }
    @Override
    public void close() throws IOException {
        fileInputStream.close();
    }
}
