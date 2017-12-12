package it.sevenbits.packages.lexer.betterLexer;
/**
 * A class that defines the necessary actions with a char
 */
public class Context implements IContext {

    private String tokenName;
    private StringBuilder tokenLexeme;
    private StringBuilder postponeBuffer;

    /**
     * The basic constructor that initializes the instance of a class
     */
    public Context() {
        tokenLexeme = new StringBuilder();
        postponeBuffer = new StringBuilder();
    }

    @Override
    public void appendLexeme(final char c) {
        tokenLexeme.append(c);
    }

    @Override
    public void setTokenName(final String name) {
        tokenName = name;
    }

    @Override
    public void appendPostpone(final char c) {
        postponeBuffer.append(c);
    }

    @Override
    public String getPostponeBuffer() {
        return postponeBuffer.toString();
    }

    String getTokenName() {
        return tokenName;
    }

    String getTokenLexeme() {
        return tokenLexeme.toString();
    }
    @Override
    public void resetPostponeBuffer() {
        postponeBuffer = new StringBuilder();
    }

    @Override
    public void resetLexeme() {
        tokenLexeme = new StringBuilder();
    }
}