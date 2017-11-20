package it.sevenbits.packages.formatter;

import it.sevenbits.packages.IO.reader.IReader;
import it.sevenbits.packages.IO.writer.IWriter;
import it.sevenbits.packages.lexer.ILexer;

/**
 * Interface for formatters.
 */
public interface IFormatter {
    /**
     * Changing symbols from input stream and writing it in output
     * @param lexer some lexer
     * @param writer some writer
     * @throws FormatterException custom reader exception
     */
    void format(ILexer lexer, IWriter writer) throws FormatterException;
}
