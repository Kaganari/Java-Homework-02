package it.sevenbits.packages.stateMachine.stateMachineLexer;

import it.sevenbits.packages.stateMachine.IState;

/**
 * Interface for transitions between states in lexer
 */
public interface IStateTransitions {
    /**
     * @param currentState current state
     * @param ch input char
     * @return next state
     */
    IState getNextState(IState currentState, char ch);
}
