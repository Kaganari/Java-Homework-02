package it.sevenbits.packages.lexer.betterLexer;

import it.sevenbits.packages.IState;

/**
 * Created by User on 04.12.2017.
 */
public interface IStateTransitions {
    public IState getNextState(IState currentState, char ch);
}
