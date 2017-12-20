package it.sevenbits.packages.stateMachine;

/**
 * Implementation os IState
 */
public class State implements IState {
    private final String name;

    /**
     * Basic constructor
     * @param name name of state
     */
    public State(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        State state = (State) obj;
        return name != null ? name.equals(state.name) : state.name == null;
    }

    @Override
    public int hashCode() {
        if (name != null) {
            return name.hashCode();
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
