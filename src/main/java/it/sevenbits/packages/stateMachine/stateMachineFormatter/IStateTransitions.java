package it.sevenbits.packages.stateMachine.stateMachineFormatter;

import it.sevenbits.packages.stateMachine.State;
import it.sevenbits.packages.token.IToken;

/**
 * Interface for getting a state based on state and token
 */
public interface IStateTransitions {
    State getNextState(State state, IToken token);
}
