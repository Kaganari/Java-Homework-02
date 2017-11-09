package it.sevenbits.packages.writer.implementation;

import it.sevenbits.packages.IClosable;
import it.sevenbits.packages.writer.IWriter;
import it.sevenbits.packages.writer.WriterException;

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
     * @param str string to write to file
     * @throws WriterException  custom writer exception
     */
    public void writeChar(final String str) throws WriterException {
        try {
            fileOutputStream.write(str.getBytes());
        } catch (IOException e) {
            throw new WriterException("Can't write.", e);
        }
    }
    @Override
    public void close() {
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
