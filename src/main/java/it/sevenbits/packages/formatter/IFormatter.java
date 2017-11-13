package it.sevenbits.packages.formatter;

import it.sevenbits.packages.reader.IReader;
import it.sevenbits.packages.reader.ReaderException;
import it.sevenbits.packages.writer.IWriter;
import it.sevenbits.packages.writer.WriterException;

/**
 * Interface for formatters.
 */
public interface IFormatter {
    /**
     * @param reader some reader
     * @param writer some writer
     * @throws ReaderException custom reader exception
     * @throws WriterException custom writer exception
     */
    static void fixSymbol(IReader reader, IWriter writer) throws ReaderException, WriterException {};
}
