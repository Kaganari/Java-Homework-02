package it.sevenbits.packages.IO.writer;

/**
 * Interface, which announcing methods for writing in some output stream
 */
public interface IWriter {
    /**
     * Writing chars into output stream
     * @param str String, which needs to write
     * @throws WriterException custom writer exception
     */
    void writeChars(String str) throws WriterException;
}
