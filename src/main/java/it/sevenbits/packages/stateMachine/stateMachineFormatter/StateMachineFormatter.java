package it.sevenbits.packages.stateMachine.stateMachineFormatter;

import it.sevenbits.packages.IO.writer.IWriter;
import it.sevenbits.packages.stateMachine.State;
import it.sevenbits.packages.formatter.FormatterException;
import it.sevenbits.packages.formatter.IFormatter;
import it.sevenbits.packages.lexer.LexerException;
import it.sevenbits.packages.stateMachine.stateMachineLexer.ILexer;
import it.sevenbits.packages.token.IToken;

/**
 * Implementation of IFormatter interface using State Machine
 */
public class StateMachineFormatter implements IFormatter {
    private ICommandRepository commands;
    private IStateTransitions transitions;

    /**
     * The basic constructor that initializes the instance of a class
     */
    public StateMachineFormatter() {
        commands = new CommandRepository();
        transitions = new StateTransitions();
    }

    @Override
    public void format(final ILexer lexer, final IWriter writer) throws FormatterException {
        IContext context = new Context(writer);
        State state = new State("start");
        try {
            while (lexer.hasMoreTokens() && state != null) {
                IToken token = lexer.readToken();
                ICommand command = commands.getCommand(state, token);
                command.execute(token, context);
                state = transitions.getNextState(state, token);
            }
        } catch (LexerException | ContextException e) {
            throw new FormatterException();
        }
    }
}
