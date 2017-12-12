package it.sevenbits.packages.formatter.implementation.betterFormatter;

import it.sevenbits.packages.IO.writer.IWriter;
import it.sevenbits.packages.IO.writer.WriterException;

/**
 * Class, that defines some methods, to apply to token
 */
public class Context implements IContext {
    private static final int INDENT = 4;
    private int indentCountLevel = 0;
    private final IWriter writer;

    /**
     * Basic constructor
     * @param writer is some class, that implements IWriter interface
     */
    Context(final IWriter writer) {
        this.writer = writer;
    }

    @Override
    public void writeLexeme(final String lexeme) throws ContextException {
        try {
            writer.write(lexeme);
        } catch (WriterException e) {
            throw new ContextException("error in Context.writeLexeme(final String lexeme)", e);
        }
    }

    @Override
    public void writeIndent() throws ContextException {
        try {
            for (int i = 0; i < indentCountLevel * INDENT; i++) {
                writer.write(' ');
            }
        } catch (WriterException e) {
            throw new ContextException("error in Context.writeIndent()", e);
        }
    }

    @Override
    public void increaseIndentCountLevel() {
        indentCountLevel++;
    }

    @Override
    public void decreaseIndentCountLevel() {
        indentCountLevel--;
    }

    @Override
    public void writeNewLine() throws ContextException {
        try {
            writer.write('\n');
        } catch (WriterException e) {
            throw new ContextException("error in Context.writeNewLine()", e);
        }
    }
}
