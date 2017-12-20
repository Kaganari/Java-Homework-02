package it.sevenbits.packages.stateMachine.stateMachineLexer;


import it.sevenbits.packages.stateMachine.IState;

/**
 * Interface for repositories of commands
 */
public interface ICommandRepository {

    /**
     * @param state current state
     * @param c input char
     * @return command
     */
    ICommand getCommand(IState state, char c);
}
