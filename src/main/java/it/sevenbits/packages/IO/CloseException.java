package it.sevenbits.packages.IO;

/**
 * Close exception occurs when can't close file
 */
public class CloseException extends Exception {
    /**
     * Empty constructor
     */
    public CloseException() {
        super();
    }

    /**
     * Constructor with message
     * @param message error message
     */
    public CloseException(final String message) {
        super(message);
    }

    /**
     * Constructor with message and exception cause
     * @param message error message
     * @param cause cause of exception
     */
    public CloseException(final String message, final Throwable cause) {
        super(message, cause);
    }
}