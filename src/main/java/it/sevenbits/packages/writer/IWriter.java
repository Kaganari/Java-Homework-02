package it.sevenbits.packages.writer;

/**
 * Interface, which announcing methods for writing in some stream
 */
public interface IWriter {
    /**
     * @param str String, which needs to write
     * @throws WriterException custom writer exception
     */
    void writeChar(String str) throws WriterException;
}
//перензвать