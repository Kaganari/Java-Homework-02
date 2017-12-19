package it.sevenbits.packages.stateMachine.stateMachineLexer;


import it.sevenbits.packages.stateMachine.IState;

/**
 * Created by User on 06.12.2017.
 */
public interface ICommandRepository {

    ICommand getCommand(IState state, char c);
}
