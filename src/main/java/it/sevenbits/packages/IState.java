package it.sevenbits.packages;

/**
 * Created by User on 24.11.2017.
 */
public interface IState {
    /**
     * Checks if state equals with object
     * @param o object to compare
     * @return true is objects are equal
     */
    boolean equals(Object o);

    /**
     * Return state's hash code
     * @return hash code
     */
    int hashCode();

    /**
     * Return state's name
     * @return state name
     */
    String toString();
}
