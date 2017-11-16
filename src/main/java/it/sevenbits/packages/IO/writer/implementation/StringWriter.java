package it.sevenbits.packages.IO.writer.implementation;

import it.sevenbits.packages.IO.writer.IWriter;
import it.sevenbits.packages.IO.writer.WriterException;

/**
 * Implementation of interface IWriter for writing to string
 */
public class StringWriter implements IWriter {
    private StringBuilder outputString;

    /**
     * Constructor
     */
    public StringWriter() {
        outputString = new StringBuilder();
    }

    /**
     * Writing chars to output string
     * @param str String, which needs to write
     * @throws WriterException custom writer exception
     */
    public void writeChars(final String str) throws WriterException {
        outputString.append(str);
    }

    /**
     * @return string
     */
    public String getString() {
        return outputString.toString();
    }
}
