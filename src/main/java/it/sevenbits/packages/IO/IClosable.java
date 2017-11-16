package it.sevenbits.packages.IO;

/**
 * Interface for closing streams
 */
public interface IClosable extends AutoCloseable {
    @Override
    void close() throws Exception;
}
