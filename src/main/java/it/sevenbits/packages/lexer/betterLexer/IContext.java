package it.sevenbits.packages.lexer.betterLexer;

/**
 * The interface that determines what to do with the symbol read,
 * if necessary, you can assign the name of the token
 *
 * @author Minyukhin Ilya
 */
public interface IContext {
    /**
     * Method adds a character to the lexeme
     *
     * @param c the character that was read
     */
    void appendLexeme(char c);

    /**
     * The method assigns the name of the token
     *
     * @param name the name of the token
     */
    void setTokenName(String name);

    /**
     * Method adds a character to the buffer
     *
     * @param c the character that was read
     */
    void appendPostpone(char c);

    String getPostponeBuffer();

    void resetPostponeBuffer();

    void resetLexeme();
}