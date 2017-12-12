package it.sevenbits.packages.lexer.betterLexer;

import it.sevenbits.packages.IO.reader.IReader;
import it.sevenbits.packages.IO.reader.ReaderException;
import it.sevenbits.packages.IO.reader.implementation.StringReader;
import it.sevenbits.packages.IState;
import it.sevenbits.packages.State;
import it.sevenbits.packages.token.IToken;
import it.sevenbits.packages.lexer.LexerException;
import it.sevenbits.packages.token.TokenBuilder;

/**
 * Implementation of ILexer interface using State Machine
 */
public class BetterLexer implements ILexer {
    private IReader reader;
    private IStateTransitions transitions = new LexerStateTransitions();
    private ICommandRepository commands = new CommandRepository();
    private Context context = new Context();

    /**
     * Basic constructor
     * @param reader source file
     */
    public BetterLexer(final IReader reader) {
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
    public IToken readToken() throws LexerException {
        context.resetLexeme();
        IReader postponeReader = new StringReader(context.getPostponeBuffer());
        IState currentState = new State("default");
        TokenBuilder tb = new TokenBuilder();
        try {
            while (postponeReader.hasMoreChars() && currentState != null) {
                char ch = postponeReader.readChar();
                ICommand command = commands.getCommand(currentState, ch);
                command.execute(ch, context);
                currentState = transitions.getNextState(currentState, ch);
            }
            context.resetPostponeBuffer();
            while (reader.hasMoreChars() && currentState != null) {
                char ch = reader.readChar();
                ICommand command = commands.getCommand(currentState, ch);
                command.execute(ch, context);
                currentState = transitions.getNextState(currentState, ch);
            }
        } catch (ReaderException e) {
            throw new LexerException("Something's wrong");
        }
        return tb.buildToken(context.getTokenName(), context.getTokenLexeme());
    }
}
