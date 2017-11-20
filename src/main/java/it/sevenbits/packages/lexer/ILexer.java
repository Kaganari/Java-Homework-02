package it.sevenbits.packages.lexer;

import it.sevenbits.packages.IO.reader.ReaderException;

/**
 * Interface for lexer
 */
public interface ILexer {
    /**
     * Checking if inpt has more tokens
     * @return true if has
     * @throws  ReaderException when can't read
     */
    boolean hasMoreTokens() throws ReaderException;

    /**
     * Read token
     * @return token
     * @throws ReaderException when can't read for some reason
     */
    IToken readToken() throws ReaderException;
}
