package it.sevenbits.packages.reader.implementation;

import it.sevenbits.packages.IClosable;
import it.sevenbits.packages.reader.IReader;
import it.sevenbits.packages.reader.ReaderException;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * FileReader class. Reading chars and checking for more chars in file.
 */
public class FileReader implements IReader, IClosable{
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
     * Reading file char by char
     * @return one char
     * @throws ReaderException custom reader exception
     */
    public char readChar() throws ReaderException {
        return (char) ch;
    }

    /**
     * Checking, does the file has more chars or not
     * @return true, if there are more char(s)
     * @throws ReaderException custom reader exception
     */
    public boolean hasMoreChars() throws ReaderException {
        try {
            ch = fileInputStream.read();
        } catch (IOException e) {
            throw new ReaderException("Can't read file", e);
        }
        return ch != -1;
    }
    @Override
    public void close() throws IOException {
        fileInputStream.close();
    }
}
