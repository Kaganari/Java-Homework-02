package it.sevenbits.packages.lexer.betterLexer;

/**
 * Created by User on 29.11.2017.
 */
public interface ICommand {
    void execute(char ch, IContext context);
}