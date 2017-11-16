package it.sevenbits.packages.IO.writer;

import java.io.IOException;

/**
 * Custom FileWriterException
 */
public class WriterException extends IOException {
    /**
     * Empty constructor
     */
    public WriterException() {
        super();
    }

    /**
     * WriterException
     * @param message error message
     * @param e exception
     */
    public WriterException(final String message, final IOException e) {
        super(message, e);
    }
}
