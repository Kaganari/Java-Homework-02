package it.sevenbits.packages.stateMachine.stateMachineLexer;

/**
 * Interface for commands
 */
public interface ICommand {
    /**
     * @param ch char
     * @param context context
     */
    void execute(char ch, IContext context);
}
