package it.sevenbits.packages.stateMachine.stateMachineFormatter;

import it.sevenbits.packages.stateMachine.State;
import it.sevenbits.packages.token.IToken;

/**
 * Interface for repository of commands
 */
public interface ICommandRepository {
    ICommand getCommand(State state, IToken token);
}
