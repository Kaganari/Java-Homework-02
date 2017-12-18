package it.sevenbits.packages.lexer.betterLexer;

import it.sevenbits.packages.IState;
import it.sevenbits.packages.Pair;
import it.sevenbits.packages.State;

import java.util.HashMap;
import java.util.Map;

/**
 * Repository of commands that are generated based on the current state and the character that was read
 */
public class CommandRepository implements ICommandRepository {
    private final Map<Pair<IState, Character>, ICommand> commands = new HashMap<>();

    /**
     * Basic constructor that initializes the command map
     */
    CommandRepository() {
        commands.put(new Pair<>(new State("default"), null),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("char"); });

        commands.put(new Pair<>(new State("default"), ';'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("semicolon"); });


        commands.put(new Pair<>(new State("default"), '\r'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("newline"); });

        commands.put(new Pair<>(new State("newline"), '\n'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("newline"); });

        commands.put(new Pair<>(new State("newline"), '\r'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("newline"); });


        commands.put(new Pair<>(new State("default"), '{'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("openbracket"); });

        commands.put(new Pair<>(new State("default"), '}'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("closebracket"); });


        commands.put(new Pair<>(new State("default"), ' '),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("space"); });

        commands.put(new Pair<>(new State("spacing"), ' '),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("space"); });

        commands.put(new Pair<>(new State("spacing"), null),
                (c, context) -> {
                    context.appendPostpone(c); });


        commands.put(new Pair<>(new State("default"), '/'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("slash"); });

        commands.put(new Pair<>(new State("slash"), '/'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("onelinecomment"); });

        commands.put(new Pair<>(new State("slash"), null),
                (c, context) -> {
                    context.appendPostpone(c); });


        commands.put(new Pair<>(new State("onelinecomment"), null),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("onelinecomment"); });


        commands.put(new Pair<>(new State("slash"), '*'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("openmultilinecomment"); });

        commands.put(new Pair<>(new State("openmultilinecomment"), null),
                (c, context) -> {
                    context.appendLexeme(c); });

        commands.put(new Pair<>(new State("openmultilinecomment"), '*'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("openmultilinecommentwithstar"); });

        commands.put(new Pair<>(new State("openmultilinecommentwithstar"), null),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("openmultilinecomment"); });

        commands.put(new Pair<>(new State("openmultilinecommentwithstar"), '/'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("openmultilinecomment"); });


        commands.put(new Pair<>(new State("default"), '*'),
                (c, context) -> {
                    context.appendLexeme(c); });

        commands.put(new Pair<>(new State("star"), '/'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("closemultilinecomment"); });

        commands.put(new Pair<>(new State("closemultilinecomment"), '\r'),
                (c, context) -> {
                    context.appendPostpone(c); });

        commands.put(new Pair<>(new State("star"), ';'),
                (c, context) -> {
                    context.appendPostpone(c); });

        commands.put(new Pair<>(new State("default"), '"'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("stringliteral"); });

        commands.put(new Pair<>(new State("spacing"), '"'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("stringliteral"); });

        commands.put(new Pair<>(new State("stringliteral"), null),
                (c, context) -> {
                    context.appendLexeme(c); });

        commands.put(new Pair<>(new State("stringliteralbackslash"), null),
                (c, context) -> {
                    context.appendLexeme(c); });

//
//        commands.put(new Pair<>(new State("default"), 'f'),
//                (c, context) -> {
//                    context.appendLexeme(c); context.setTokenName("uncompletedfor"); });
//
//        commands.put(new Pair<>(new State("f"), null),
//                (c, context) -> {
//                    context.appendPostpone(c); });
//
//        commands.put(new Pair<>(new State("f"), 'o'),
//                (c, context) -> {
//                    context.appendLexeme(c); context.setTokenName("uncompletedfor"); });
//
//        commands.put(new Pair<>(new State("fo"), 'r'),
//                (c, context) -> {
//                    context.appendLexeme(c); context.setTokenName("for"); });
//
//        commands.put(new Pair<>(new State("fo"), null),
//                (c, context) -> {
//                    context.appendPostpone(c); });
//
//        commands.put(new Pair<>(new State("for"), ';'),
//                (c, context) -> {
//                    context.appendLexeme(c); context.setTokenName("stringliteral"); });
    }

    @Override
    public ICommand getCommand(final IState state, final char c) {
        ICommand command = commands.get(new Pair<>(state, c));
        if (command == null) {
            command = commands.get(new Pair<>(state, (Character) null));
        }
        return command;
    }
}
