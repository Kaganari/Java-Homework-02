package it.sevenbits.packages.stateMachine.stateMachineLexer;

import it.sevenbits.packages.stateMachine.IState;
import it.sevenbits.packages.stateMachine.Pair;
import it.sevenbits.packages.stateMachine.State;

import java.util.HashMap;
import java.util.Map;

/**
 * The class defining transitions between states
 */
public class LexerStateTransitions implements IStateTransitions {
    private final Map<Pair<IState, Character>, State> states = new HashMap<>();

    /**
     * The basic constructor that initializes the states map
     */
    LexerStateTransitions() {
        states.put(new Pair<>(new State("default"), ' '), new State("spacing"));
        states.put(new Pair<>(new State("spacing"), ' '), new State("spacing"));

        states.put(new Pair<>(new State("default"), '/'), new State("slash"));
        states.put(new Pair<>(new State("slash"), '/'), new State("onelinecomment"));
        states.put(new Pair<>(new State("onelinecomment"), null), new State("onelinecomment"));
        states.put(new Pair<>(new State("onelinecomment"), '\r'), new State("null"));
        states.put(new Pair<>(new State("onelinecomment"), '\n'), new State("null"));

        states.put(new Pair<>(new State("slash"), '*'), new State("openmultilinecomment"));
        states.put(new Pair<>(new State("openmultilinecomment"), '*'), new State("openmultilinecommentwithstar"));
        states.put(new Pair<>(new State("openmultilinecommentwithstar"), '/'), new State("default"));
        states.put(new Pair<>(new State("openmultilinecommentwithstar"), null), new State("openmultilinecomment"));

        states.put(new Pair<>(new State("default"), '\r'), new State("newline"));

        states.put(new Pair<>(new State("default"), '*'), new State("star"));
        states.put(new Pair<>(new State("star"), '/'), new State("closemultilinecomment"));

        states.put(new Pair<>(new State("default"), '"'), new State("stringliteral"));
        states.put(new Pair<>(new State("spacing"), '"'), new State("stringliteral"));
        states.put(new Pair<>(new State("stringliteral"), null), new State("stringliteral"));
        states.put(new Pair<>(new State("stringliteral"), '"'), new State("null"));

        states.put(new Pair<>(new State("stringliteral"), '\\'), new State("stringliteralbackslash"));
        states.put(new Pair<>(new State("stringliteralbackslash"), null), new State("stringliteral"));

        states.put(new Pair<>(new State("default"), 'f'), new State("f"));
        states.put(new Pair<>(new State("f"), 'o'), new State("fo"));
        states.put(new Pair<>(new State("fo"), 'r'), new State("for"));

        states.put(new Pair<>(new State("for"), '{'), new State("null"));
        states.put(new Pair<>(new State("for"), null), new State("for"));
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
