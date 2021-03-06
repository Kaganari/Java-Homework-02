package it.sevenbits.packages.stateMachine.stateMachineFormatter;

import it.sevenbits.packages.stateMachine.Pair;
import it.sevenbits.packages.stateMachine.State;
import it.sevenbits.packages.token.IToken;

import java.util.HashMap;
import java.util.Map;

/**
 * Class, that implements IStateTransitions and determines transition between states
 */
public class StateTransitions implements IStateTransitions {
    private final Map<Pair<State, String>, State> transitions = new HashMap<>();

    /**
     * The basic constructor that initializes the states map
     */
    public StateTransitions() {

        transitions.put(new Pair<>(new State("start"), "space"), new State("start"));
        transitions.put(new Pair<>(new State("start"), "spaces"), new State("start"));
        transitions.put(new Pair<>(new State("start"), "newline"), new State("start"));
        transitions.put(new Pair<>(new State("start"), "openmultilinecomment"), new State("writemulticomment"));
        transitions.put(new Pair<>(new State("start"), "onelinecomment"), new State("writeonelinecomment"));
        transitions.put(new Pair<>(new State("writeonelinecomment"), null), new State("writeonelinecomment"));
        transitions.put(new Pair<>(new State("writeonelinecomment"), "newline"), new State("start")); ////////
        transitions.put(new Pair<>(new State("start"), "closemultilinecomment"), new State("start"));
        transitions.put(new Pair<>(new State("start"), "char"), new State("default"));
        transitions.put(new Pair<>(new State("start"), "openbracket"), new State("start"));
        transitions.put(new Pair<>(new State("start"), "closebracket"), new State("start"));
        transitions.put(new Pair<>(new State("default"), "char"), new State("default"));
        transitions.put(new Pair<>(new State("default"), "newline"), new State("default"));
        transitions.put(new Pair<>(new State("default"), "semicolon"), new State("start"));
        transitions.put(new Pair<>(new State("default"), "openmultilinecomment"), new State("writemulticomment"));
        transitions.put(new Pair<>(new State("default"), "space"), new State("default"));
        transitions.put(new Pair<>(new State("default"), "openbracket"), new State("start"));
        transitions.put(new Pair<>(new State("default"), "closebracket"), new State("start"));
        transitions.put(new Pair<>(new State("writemulticomment"), "closemultilinecomment"), new State("start"));
        transitions.put(new Pair<>(new State("writemulticomment"), null), new State("writemulticomment"));

        transitions.put(new Pair<>(new State("start"), "slash"), new State("start"));
        transitions.put(new Pair<>(new State("default"), "slash"), new State("default"));

        transitions.put(new Pair<>(new State("start"), "stringliteral"), new State("start"));
        transitions.put(new Pair<>(new State("default"), "stringliteral"), new State("default"));

        transitions.put(new Pair<>(new State("start"), "uncompletedfor"), new State("default"));
        transitions.put(new Pair<>(new State("default"), "uncompletedfor"), new State("default"));
        transitions.put(new Pair<>(new State("start"), "for"), new State("start"));
        transitions.put(new Pair<>(new State("default"), "for"), new State("default"));
    }

    @Override
    public State getNextState(final State state, final IToken token) {
        State nextState = transitions.get(new Pair<>(state, token.getName()));
        if (nextState == null) {
            nextState = transitions.get(new Pair<>(state, (String) null));
        }
        return nextState;
    }
}
