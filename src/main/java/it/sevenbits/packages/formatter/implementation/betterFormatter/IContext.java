package it.sevenbits.packages.formatter.implementation.betterFormatter;

/**
 * Interface for some methods, that has to be used on tokens
 */
public interface IContext {
    void writeLexeme(String lexeme) throws ContextException;

    void writeIndent() throws ContextException;

    void increaseIndentCountLevel();

    void decreaseIndentCountLevel();

    void writeNewLine() throws ContextException;
}
