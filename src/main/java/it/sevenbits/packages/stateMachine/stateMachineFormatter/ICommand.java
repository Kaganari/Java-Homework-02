package it.sevenbits.packages.stateMachine.stateMachineFormatter;

import it.sevenbits.packages.token.IToken;

/**
 * Interface for commands
 */
public interface ICommand {
    void execute(IToken token, IContext context) throws ContextException;
}
