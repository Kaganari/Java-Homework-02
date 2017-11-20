package it.sevenbits.packages.lexer;

/**
 *
 */
public interface IToken {
    /**
     * Get token's name
     * @return token's name
     */
    String getName();

    /**
     * Get token's lexeme
     * @return token's lexeme
     */
    String getLexeme();
}
