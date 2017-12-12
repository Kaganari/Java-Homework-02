package it.sevenbits.packages.token;

import it.sevenbits.packages.token.IToken;
import it.sevenbits.packages.token.Token;

/**
 * Created by User on 29.11.2017.
 */
public class TokenBuilder {

    public IToken buildToken(final String name, final String lexeme) {
        return new Token(name, lexeme);
    }



}
