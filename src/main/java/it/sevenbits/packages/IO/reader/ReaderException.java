package it.sevenbits.packages.IO.reader;


/**
 * Custom ReaderException, occurs when can't read from source
 */

public class ReaderException extends Exception {

    /**
     * Empty constructor
     */
    public ReaderException() {
        super();
    }
    /**
     * Constructor for any exception
     * @param message error message
     * @param e exception
     */
    public ReaderException(final String message, final Exception e) {
        super(message, e);
    }
//    /**
//     * Constructor for IO exception
//     * @param message error message
//     * @param e exception
//     */
//    public ReaderException(final String message, final IOException e) {
//        super(message, e);
//    }
}

