package it.sevenbits.packages.IO.reader;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by User on 04.12.2017.
 */
public class PostponeReader implements IReader {
    private List<Character> postponeList = Collections.synchronizedList(new LinkedList());
    char tempChar;

    @Override
    public boolean hasMoreChars() throws ReaderException {
        return postponeList.isEmpty();
    }

    @Override
    public char readChar() throws ReaderException {
        tempChar = postponeList.get(0);
        postponeList.remove(0);
        return tempChar;
    }
    public void addCharToList(final char ch) {
        postponeList.add(ch);
    }
}
