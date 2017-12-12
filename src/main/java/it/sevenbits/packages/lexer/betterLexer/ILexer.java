package it.sevenbits.packages.lexer.betterLexer;


import it.sevenbits.packages.token.IToken;
import it.sevenbits.packages.lexer.LexerException;

/**
 * Interface for lexer
 */
public interface ILexer {
    /**
     * Checking if inpt has more tokens
     * @return true if has
     * @throws LexerException when can't read
     */
    boolean hasMoreTokens() throws LexerException;

    /**
     * Read token
     * @return token
     * @throws LexerException when can't read for some reason
     */
    IToken readToken() throws LexerException;
}
