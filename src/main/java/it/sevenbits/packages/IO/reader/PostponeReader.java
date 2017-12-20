package it.sevenbits.packages.IO.reader;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of IReader interface for postponing some chars
 */
public class PostponeReader implements IReader {
    private List<Character> postponeList = Collections.synchronizedList(new LinkedList());

    @Override
    public boolean hasMoreChars() throws ReaderException {
        return postponeList.isEmpty();
    }

    @Override
    public char readChar() throws ReaderException {
        char tempChar = postponeList.get(0);
        postponeList.remove(0);
        return tempChar;
    }


    /**
     * @param ch char to list
     */
    public void addCharToList(final char ch) {
        postponeList.add(ch);
    }
}
