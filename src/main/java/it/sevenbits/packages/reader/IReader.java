package it.sevenbits.packages.reader;

/**
 * Interface with announcing of methods for reading from stream
 */
public interface IReader {
    /**
     * @return single char
     * @throws ReaderException custom reader exception
     */
    char readChar() throws ReaderException;

    /**
     * @return true, if it's not the end of file
     * @throws ReaderException custom reader exception
     */
    boolean hasMoreChars() throws ReaderException;
}
