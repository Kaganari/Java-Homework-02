package it.sevenbits.packages.IO.reader;

/**
 * Interface with announcing of methods for reading from stream
 */
public interface IReader {
    /**
     * Returning read char
     * @return single char
     * @throws ReaderException custom reader exception
     */
    boolean hasMoreChars() throws ReaderException;

    /**
     * Trying to read char from input
     * @return true, if it's not the end of file
     * @throws ReaderException custom reader exception
     */
    char readChar() throws ReaderException;
}
