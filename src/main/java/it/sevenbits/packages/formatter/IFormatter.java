package it.sevenbits.packages.formatter;

import it.sevenbits.packages.IO.reader.IReader;
import it.sevenbits.packages.IO.writer.IWriter;

/**
 * Interface for formatters.
 */
public interface IFormatter {
    /**
     * Changing symbols from input stream and writing it in output
     * @param reader some reader
     * @param writer some writer
     * @throws FormatterException custom reader exception
     */
    void format(IReader reader, IWriter writer) throws FormatterException;
}
