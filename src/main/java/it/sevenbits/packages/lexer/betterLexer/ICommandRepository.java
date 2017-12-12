package it.sevenbits.packages.lexer.betterLexer;


import it.sevenbits.packages.IState;

/**
 * Created by User on 06.12.2017.
 */
public interface ICommandRepository {

    ICommand getCommand(IState state, char c);
}
