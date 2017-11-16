package it.sevenbits.packages.formatter;

/**
 * Custom exception for Formatter
 */
public class FormatterException extends Exception {
    /**
     * Empty constructor
     */
    public FormatterException() {
        super();
    }

    /**
     * Constructor with message
     * @param message error message
     */
    public FormatterException(final String message) {
        super(message);
    }

    /**
     * Constructor with message and exception cause
     * @param message error message
     * @param cause cause of exception
     */
    public FormatterException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
