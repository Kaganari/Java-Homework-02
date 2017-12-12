package it.sevenbits.packages.formatter.implementation.betterFormatter;

import it.sevenbits.packages.State;
import it.sevenbits.packages.token.IToken;

/**
 * Interface for repository of commands
 */
public interface ICommandRepository {
    ICommand getCommand(State state, IToken token);
}
