package it.sevenbits.packages.stateMachine.stateMachineFormatter;

/**
 * Interface for some methods, that has to be used on tokens
 */
public interface IContext {
    void writeLexeme(String lexeme) throws ContextException;

    void writeChar(final char ch) throws ContextException;

    void writeIndent() throws ContextException;

    void increaseIndentCountLevel();

    void decreaseIndentCountLevel();

    void writeNewLine() throws ContextException;
}
