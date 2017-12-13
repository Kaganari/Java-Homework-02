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
    public LexerException(final String message) {
        super(message);
    }
    public LexerException(final Throwable cause) {
        super(cause);
    }
}