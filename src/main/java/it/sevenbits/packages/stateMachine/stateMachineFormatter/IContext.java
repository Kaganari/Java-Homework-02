package it.sevenbits.packages.stateMachine.stateMachineFormatter;

/**
 * Interface for some methods, that has to be used on tokens
 */
public interface IContext {
    /**
     * Writes lexeme
     * @param lexeme is lexeme to write
     * @throws ContextException exception
     */

    void writeLexeme(String lexeme) throws ContextException;

    /**
     * Writes char
     * @param ch is char to write
     * @throws ContextException exception
     */
    void writeChar(char ch) throws ContextException;

    /**
     * Writes indent
     * @throws ContextException exception
     */
    void writeIndent() throws ContextException;

    /**
     * Increment indent
     */
    void increaseIndentCountLevel();

    /**
     * Decrement indent
     */
    void decreaseIndentCountLevel();

    /**
     * Writes new line
     * @throws ContextException exception
     */
    void writeNewLine() throws ContextException;
}
