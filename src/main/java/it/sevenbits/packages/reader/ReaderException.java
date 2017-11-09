package it.sevenbits.packages.reader;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Custom ReaderException
 */

public class ReaderException extends IOException {

    /**
     * ReaderException
     * @param message error message
     * @param e exception
     */
    public ReaderException(final String message, final FileNotFoundException e) {
        super(message, e);
    }

    public ReaderException(final String message, final IOException e) {
        super(message, e);
    }
}
