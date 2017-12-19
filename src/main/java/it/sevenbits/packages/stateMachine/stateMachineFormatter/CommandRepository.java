package it.sevenbits.packages.stateMachine.stateMachineFormatter;

import it.sevenbits.packages.stateMachine.Pair;
import it.sevenbits.packages.stateMachine.State;
import it.sevenbits.packages.token.IToken;

import java.util.HashMap;
import java.util.Map;

/**
 * This class contains commands. It returns one based on state and token
 */
public class CommandRepository implements ICommandRepository {
    private final Map<Pair<State, String>, ICommand> commands = new HashMap<>();

    /**
     * The basic constructor that initializes the command map
     */
    CommandRepository() {
        commands.put(new Pair<>(new State("start"), "space"),
                (token, context) -> {  });

        commands.put(new Pair<>(new State("start"), "spaces"),
                (token, context) -> {  });

        commands.put(new Pair<>(new State("start"), "newline"),
                (token, context) -> {  });

        commands.put(new Pair<>(new State("start"), "onelinecomment"),
                (token, context) -> context.writeLexeme(token.getLexeme()));

        commands.put(new Pair<>(new State("writeonelinecomment"), null),
                (token, context) -> context.writeLexeme(token.getLexeme()));

        commands.put(new Pair<>(new State("writeonelinecomment"), "newline"),
                (token, context) -> {
                    context.writeNewLine(); context.writeIndent(); });

        commands.put(new Pair<>(new State("start"), "openmultilinecomment"),
                (token, context) ->  context.writeLexeme(token.getLexeme()));

        commands.put(new Pair<>(new State("start"), "closemultilinecomment"),
                (token, context) -> { });

        commands.put(new Pair<>(new State("start"), "char"),
                (token, context) -> {
                    context.writeIndent();
                    context.writeLexeme(token.getLexeme()); });

        commands.put(new Pair<>(new State("default"), "char"),
                (token, context) -> context.writeLexeme(token.getLexeme()));

        commands.put(new Pair<>(new State("default"), "space"),
                (token, context) -> context.writeChar(' '));

        commands.put(new Pair<>(new State("default"), "spaces"),
                (token, context) -> context.writeLexeme(token.getLexeme()));

        commands.put(new Pair<>(new State("default"), "semicolon"),
                (token, context) -> {
                    context.writeLexeme(token.getLexeme());
                    context.writeNewLine(); });

        commands.put(new Pair<>(new State("default"), "openmultilinecomment"),
                (token, context) -> context.writeLexeme(token.getLexeme()));

        commands.put(new Pair<>(new State("default"), "newline"), (token, context) -> { });

        commands.put(new Pair<>(new State("writemulticomment"), "closemultilinecomment"),
                (token, context) -> {
                    context.writeLexeme(token.getLexeme());
                    context.writeNewLine();
                    context.writeIndent(); });

        commands.put(new Pair<>(new State("writemulticomment"), null),
                (token, context) -> context.writeLexeme(token.getLexeme()));

        commands.put(new Pair<>(new State("default"), "openbracket"),
                (token, context) -> {
                    context.writeLexeme(token.getLexeme());
                    context.increaseIndentCountLevel();
                    context.writeNewLine(); });

        commands.put(new Pair<>(new State("default"), "closebracket"),
                (token, context) -> {
                    context.decreaseIndentCountLevel();
                    context.writeIndent();
                    context.writeLexeme(token.getLexeme());
                    context.writeNewLine(); });

        commands.put(new Pair<>(new State("start"), "openbracket"),
                (token, context) -> {
                    context.writeLexeme(token.getLexeme());
                    context.increaseIndentCountLevel();
                    context.writeNewLine(); });

        commands.put(new Pair<>(new State("start"), "closebracket"),
                (token, context) -> {
                    context.decreaseIndentCountLevel();
                    context.writeIndent();
                    context.writeLexeme(token.getLexeme());
                    context.writeNewLine(); });

        commands.put(new Pair<>(new State("start"), "slash"),
                (token, context) -> {
                    context.writeIndent();
                    context.writeLexeme(token.getLexeme()); });

        commands.put(new Pair<>(new State("default"), "slash"),
                (token, context) -> {
                    context.writeIndent();
                    context.writeLexeme(token.getLexeme()); });

        commands.put(new Pair<>(new State("default"), "stringliteral"),
                (token, context) -> {
                    context.writeLexeme(token.getLexeme()); });

        commands.put(new Pair<>(new State("start"), "stringliteral"),
                (token, context) -> {
                    context.writeLexeme(token.getLexeme()); });


        commands.put(new Pair<>(new State("start"), "uncompletedfor"),
                (token, context) -> {
                    context.writeIndent();
                    context.writeLexeme(token.getLexeme()); });

        commands.put(new Pair<>(new State("start"), "for"),
                (token, context) -> {
                    context.writeLexeme(token.getLexeme()); });

        commands.put(new Pair<>(new State("default"), "uncompletedfor"),
                (token, context) -> {
                    context.writeLexeme(token.getLexeme()); });

        commands.put(new Pair<>(new State("default"), "for"),
                (token, context) -> {
                    context.writeLexeme(token.getLexeme()); });
    }

    @Override
    public ICommand getCommand(final State state, final IToken token) {
        ICommand command = commands.get(new Pair<>(state, token.getName()));
        if (command == null) {
            command = commands.get(new Pair<>(state, (String) null));
        }
        return command;
    }
}
