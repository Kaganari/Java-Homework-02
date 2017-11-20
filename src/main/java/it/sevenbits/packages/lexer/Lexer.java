package it.sevenbits.packages.lexer;

import it.sevenbits.packages.IO.reader.IReader;
import it.sevenbits.packages.IO.reader.ReaderException;

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
    public boolean hasMoreTokens() throws ReaderException {
        try {
            return reader.readChar();
        } catch (ReaderException e) {
            throw new ReaderException("Can't read", e);
        }
    }

    @Override
    public IToken readToken() throws ReaderException {
        try {
            String name;
            String lexeme;
                char ch = reader.getChar();
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
            throw new ReaderException("Can't read for some reason", e);
        }
    }
}
