package it.sevenbits.packages.stateMachine.stateMachineFormatter;

import it.sevenbits.packages.stateMachine.State;
import it.sevenbits.packages.token.IToken;

/**
 * Interface for getting a state based on state and token
 */
public interface IStateTransitions {
    /**
     * @param state current state
     * @param token input token
     * @return next state
     */
    State getNextState(State state, IToken token);
}
