package it.sevenbits.packages.stateMachine.stateMachineLexer;
/**
 * A class that defines the necessary actions with a char
 */
class Context implements IContext {

    private String tokenName;
    private StringBuilder tokenLexeme;
    private StringBuilder postponeBuffer;

    /**
     * The basic constructor that initializes the instance of a class
     */
    Context() {
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

    /**
     * Resetting postpone buffer
     */
    void resetPostponeBuffer() {
        postponeBuffer = new StringBuilder();
    }

    /**
     * Resetting lexeme
     */
    void resetLexeme() {
        tokenLexeme = new StringBuilder();
    }
}