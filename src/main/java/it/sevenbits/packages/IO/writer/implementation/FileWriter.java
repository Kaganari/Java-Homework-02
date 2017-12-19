package it.sevenbits.packages.IO.writer.implementation;

import it.sevenbits.packages.IO.CloseException;
import it.sevenbits.packages.IO.IClosable;
import it.sevenbits.packages.IO.writer.IWriter;
import it.sevenbits.packages.IO.writer.WriterException;

import java.io.*;

/**
 * FileWriter class.
 */
public class FileWriter implements IWriter, IClosable {
    private BufferedWriter writer;

    /**
     * Constructor
     * @param fileName name of output file
     * @throws WriterException custom writer exception
     */
    public FileWriter(final String fileName) throws WriterException {
        try {
            //fileOutputStream = new FileOutputStream(fileName);
            writer = new BufferedWriter(new java.io.FileWriter(fileName));
        } catch (IOException e) {
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
            writer.write(str);
        } catch (IOException e) {
            throw new WriterException("Can't write.", e);
        }
    }

    @Override
    public void write(final char ch) throws WriterException {
        try {
            writer.write(ch);
        } catch (IOException e) {
            throw new WriterException("Can't write.", e);
        }
    }

    @Override
    public void close() throws CloseException {
        try {
            writer.close();
        } catch (IOException e) {
            throw new CloseException("Can't close the file", e);
        }
    }
}
