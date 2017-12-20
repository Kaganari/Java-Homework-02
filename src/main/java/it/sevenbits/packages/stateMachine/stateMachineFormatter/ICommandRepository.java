package it.sevenbits.packages.stateMachine.stateMachineFormatter;

import it.sevenbits.packages.stateMachine.State;
import it.sevenbits.packages.token.IToken;

/**
 * Interface for repository of commands
 */
public interface ICommandRepository {
    /**
     * @param state current state
     * @param token input token
     * @return command
     */
    ICommand getCommand(State state, IToken token);
}
