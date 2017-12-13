package it.sevenbits.packages.lexer.betterLexer;

import it.sevenbits.packages.IState;
import it.sevenbits.packages.Pair;
import it.sevenbits.packages.State;

import java.util.HashMap;
import java.util.Map;

/**
 * The class defining transitions between states
 */
public class LexerStateTransitions implements IStateTransitions {
    private final Map<Pair<State, Character>, State> states = new HashMap<>();

    /**
     * The basic constructor that initializes the states map
     */
    LexerStateTransitions() {
        states.put(new Pair<>(new State("default"), ' '), new State("spacing"));
        states.put(new Pair<>(new State("spacing"), ' '), new State("spacing"));

        states.put(new Pair<>(new State("default"), '/'), new State("slash"));
        states.put(new Pair<>(new State("slash"), '/'), new State("onelinecomment"));
        states.put(new Pair<>(new State("onelinecomment"), (Character) null), new State("onelinecomment"));
        states.put(new Pair<>(new State("onelinecomment"), '\r'), new State("default"));
        states.put(new Pair<>(new State("slash"), '*'), new State("openmultilinecomment"));

        states.put(new Pair<>(new State("default"), '\r'), new State("newline"));

        states.put(new Pair<>(new State("default"), '*'), new State("star"));
        states.put(new Pair<>(new State("star"), '/'), new State("closemultilinecomment"));
    }

    @Override
    public IState getNextState(final IState state, final char c) {
        IState nextState = states.get(new Pair<>(state, c));
        if (nextState == null) {
            nextState = states.get(new Pair<>(state, (Character) null));
        }
        return nextState;
    }
}
