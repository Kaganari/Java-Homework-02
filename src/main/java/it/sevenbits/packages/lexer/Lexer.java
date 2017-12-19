package it.sevenbits.packages.lexer;

import it.sevenbits.packages.IO.reader.IReader;
import it.sevenbits.packages.IO.reader.ReaderException;
import it.sevenbits.packages.stateMachine.stateMachineLexer.ILexer;
import it.sevenbits.packages.token.IToken;
import it.sevenbits.packages.token.Token;

/**
 * Basic implementation of ILexer
 */
public class Lexer implements ILexer {
    private IReader reader;

    /**
     * Basic constructor
     * @param reader source file
     */
    public Lexer(final IReader reader) {
        this.reader = reader;
    }

    @Override
    public boolean hasMoreTokens() throws LexerException {
        try {
            return reader.hasMoreChars();
        } catch (ReaderException e) {
            throw new LexerException("Can't read", e);
        }
    }

    @Override
    public IToken readToken() throws LexerException{
        try {
            String name;
            String lexeme;
            char ch;
            ch = reader.readChar();
            switch (ch) {
                case '{':
                    name = "bracketOpen";
                    break;
                case '}':
                    name = "bracketClose";
                    break;
                case ';':
                    name = "semicolon";
                    break;
                case '\n':
                    name = "newLine";
                    break;
                case '\r':
                    name = "newLine";
                    break;
                case ' ':
                    name = "whiteSpace";
                    break;
                default:
                    name = "otherChar";
                    break;
            }
            lexeme = Character.toString(ch);
            return new Token(name, lexeme);
        } catch (ReaderException e) {
            throw new LexerException("Can't read for some reason", e);
        }
    }
}
