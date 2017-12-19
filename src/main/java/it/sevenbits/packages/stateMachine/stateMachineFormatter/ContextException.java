package it.sevenbits.packages.stateMachine.stateMachineFormatter;

/**
 * Wrapper for exception
 */
public class ContextException extends Exception {
    /**
     * Basic constructor
     * @param message exception text
     */
    public ContextException(final String message) {
        super(message);
    }

    /**
     * Constructor with cause
     * @param cause exception object
     */
    public ContextException(final Throwable cause) {
        super(cause);
    }

    /**
     * Constructor with message and cause
     * @param message exception text
     * @param cause exception object
     */
    public ContextException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
