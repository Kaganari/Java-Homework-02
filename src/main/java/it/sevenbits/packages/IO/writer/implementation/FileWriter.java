package it.sevenbits.packages.IO.writer.implementation;

import it.sevenbits.packages.IO.CloseException;
import it.sevenbits.packages.IO.IClosable;
import it.sevenbits.packages.IO.writer.IWriter;
import it.sevenbits.packages.IO.writer.WriterException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileWriter class.
 */
public class FileWriter implements IWriter, IClosable {

    private FileOutputStream fileOutputStream ;

    /**
     * Constructor
     * @param fileName name of output file
     * @throws WriterException custom writer exception
     */
    public FileWriter(final String fileName) throws WriterException {
        try {
            fileOutputStream = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new WriterException("Something is wrong with file. Doesn't exist or cannot be opened.", e);
        }
    }

    /**
     * Writing chars to output file
     * @param str string to write to file
     * @throws WriterException  custom writer exception
     */
    public void write(final String str) throws WriterException {
        try {
            fileOutputStream.write(str.getBytes());
        } catch (IOException e) {
            throw new WriterException("Can't write.", e);
        }
    }

    @Override
    public void write(final char ch) throws WriterException {
        try {
            fileOutputStream.write(ch);
        } catch (IOException e) {
            throw new WriterException("Can't write.", e);
        }
    }

    @Override
    public void close() throws CloseException {
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            throw new CloseException("Can't close the file", e);
        }
    }
}
