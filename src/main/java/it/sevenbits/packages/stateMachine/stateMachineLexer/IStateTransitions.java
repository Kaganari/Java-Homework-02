package it.sevenbits.packages.stateMachine.stateMachineLexer;

import it.sevenbits.packages.stateMachine.IState;

/**
 * Created by User on 04.12.2017.
 */
public interface IStateTransitions {
    public IState getNextState(IState currentState, char ch);
}
