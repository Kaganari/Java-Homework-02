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
    void write(String str) throws WriterException;
    /**
     * Writing char into output stream
     * @param ch char, which needs to write
     * @throws WriterException custom writer exception
     */
    void write(char ch) throws WriterException;
}
