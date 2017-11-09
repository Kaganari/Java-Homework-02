package it.sevenbits.packages.writer.implementation;

import it.sevenbits.packages.writer.IWriter;
import it.sevenbits.packages.writer.WriterException;

/**
 * Implementation of interface IWriter for writing to string
 */
public class StringWriter implements IWriter {
    private StringBuilder outputString;

    public StringWriter() {
        outputString = new StringBuilder();
    }

    /**
     * @param str String, which needs to write
     * @throws WriterException custom writer exception
     */
    public void writeChar(final String str) throws WriterException {
        outputString.append(str);
    }

    /**
     * @return string
     */
    public String getString() {
        return outputString.toString();
    }
}
