package it.sevenbits.packages.stateMachine.stateMachineFormatter;

import it.sevenbits.packages.token.IToken;

/**
 * Interface for commands
 */
interface ICommand {
    /**
     * @param token token
     * @param context context
     * @throws ContextException exception
     */
    void execute(IToken token, IContext context) throws ContextException;
}
