package it.sevenbits.packages;

/**
 * Created by User on 02.11.2017.
 */
public interface IClosable extends AutoCloseable {
    @Override
    void close() throws Exception;
}
