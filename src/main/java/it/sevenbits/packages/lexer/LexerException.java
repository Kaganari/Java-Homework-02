package it.sevenbits.packages.lexer;

/**
 * Exception for Lexer
 */
public class LexerException extends Exception {

    /**
     * Empty constructor
     */
    public LexerException() {
        super();
    }
    /**
     * Constructor for lexer exception
     * @param message error message
     * @param e exception
     */
    public LexerException(final String message, final Exception e) {
        super(message, e);
    }

    /**
     * Constructor for lexer exception
     * @param message error message
     */
    public LexerException(final String message) {
        super(message);
    }

    /**
     * Constructor for lexer exception
     * @param cause cause
     */
    public LexerException(final Throwable cause) {
        super(cause);
    }
}
