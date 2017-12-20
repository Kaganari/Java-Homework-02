package it.sevenbits.packages.token;

/**
 * Class, that creates tokens from name and lexeme
 */
public class TokenBuilder {

    /**
     * @param name name of token
     * @param lexeme lexeme, that token contains
     * @return token
     */
    public IToken buildToken(final String name, final String lexeme) {
        return new Token(name, lexeme);
    }



}
