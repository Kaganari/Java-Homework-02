package it.sevenbits.packages;

import it.sevenbits.packages.token.IToken;
import it.sevenbits.packages.token.Token;

/**
 * Created by User on 29.11.2017.
 */
public class TokenBuilder {
    private String name;
    private StringBuilder lexeme = new StringBuilder();

    public void appendLexeme(final char ch) {
        lexeme.append(ch);
    }
    public void setName(final String name) {
        this.name = name;
    }
    public IToken buildToken() {
        return new Token(name, lexeme.toString());
    }



}
