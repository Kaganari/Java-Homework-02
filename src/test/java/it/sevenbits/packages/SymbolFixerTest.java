package it.sevenbits.packages;

import org.junit.Before;
import org.junit.Test;
import it.sevenbits.packages.reader.implementation.StringReader;
import it.sevenbits.packages.writer.implementation.StringWriter;

import static org.junit.Assert.assertEquals;

public class SymbolFixerTest {
    private StringReader reader;
    private StringWriter writer;

    private String inputString;
    private String expectedString;

    @Before
    public void setUp() throws Exception {
        writer = new StringWriter();
    }

    @Test
    public void PartiallyFormattedText() throws Exception {
        inputString = "public void main(){               System.out.println(\"Hello World\");\n}";
        expectedString = "public void main() {\n    System.out.println(\"Hello World\");\n}\n";
        reader = new StringReader(inputString);
        SymbolFixer.fixSymbol(reader, writer);
        assertEquals("Wrong text", expectedString, writer.getString());
    }

    @Test
    public void testTextInLine() throws Exception {
        inputString = "public class Formatter {public static void main(final String[] args) throws IOException {int ch, level = 0;char[] fixed;File input = new File(\"src/main/java/Formatter.java\");File output = new File(\"src/main/resources/codeOutput.java\");";
        expectedString = "public class Formatter {\n    public static void main(final String[] args) throws IOException {\n        int ch, level = 0;\n        char[] fixed;\n        File input = new File(\"src/main/java/Formatter.java\");\n        File output = new File(\"src/main/resources/codeOutput.java\");\n";
        reader = new StringReader(inputString);
        SymbolFixer.fixSymbol(reader, writer);
        assertEquals("Wrong text", expectedString, writer.getString());
    }

    @Test
    public void testFormattedText() throws Exception {
        inputString = "public void main() {\nSystem.out.println(\"Hello World\");\n}\n";
        expectedString = "public void main() {\n    System.out.println(\"Hello World\");\n}\n";
        reader = new StringReader(inputString);
        SymbolFixer.fixSymbol(reader, writer);
        assertEquals("Wrong text", expectedString, writer.getString());
    }
}