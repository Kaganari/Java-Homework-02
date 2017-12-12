package it.sevenbits.packages.formatter.implementation.betterFormatter;

import it.sevenbits.packages.State;
import it.sevenbits.packages.token.IToken;

/**
 * Interface for getting a state based on state and token
 */
public interface IStateTransitions {
    State getNextState(State state, IToken token);
}
