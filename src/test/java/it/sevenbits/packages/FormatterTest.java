package it.sevenbits.packages;

import it.sevenbits.packages.formatter.IFormatter;
import it.sevenbits.packages.stateMachine.stateMachineFormatter.StateMachineFormatter;
import it.sevenbits.packages.stateMachine.stateMachineLexer.ILexer;
import it.sevenbits.packages.stateMachine.stateMachineLexer.StateMachineLexer;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import it.sevenbits.packages.IO.reader.implementation.StringReader;
import it.sevenbits.packages.IO.writer.implementation.StringWriter;

import static org.junit.Assert.assertEquals;

public class FormatterTest {
    private StringReader reader;
    private StringWriter writer;

    private String inputString;
    private String expectedString;

    @Before
    public void setUp() throws Exception {
        writer = new StringWriter();
    }

    @Test
    public void testPartiallyFormattedText() throws Exception {
        inputString = "public void main(){               System.out.println(\"Hello World\");}";
        expectedString = "public void main(){\n    System.out.println(\"Hello World\");\n}\n";
        reader = new StringReader(inputString);
        IFormatter formatter = new StateMachineFormatter();
        ILexer lexer = new StateMachineLexer(reader);
        formatter.format(lexer, writer);
        assertEquals("Wrong text", expectedString, writer.getString());
    }

    @Test
    public void testTextInLine() throws Exception {
        inputString = "public class Formatter {public static void main(final String[] args) throws IOException {int ch, level = 0;char[] fixed;File input = new File(\"src/main/java/Formatter.java\");File output = new File(\"src/main/resources/codeOutput.java\");";
        expectedString = "public class Formatter {\n    public static void main(final String[] args) throws IOException {\n        int ch, level = 0;\n        char[] fixed;\n        File input = new File(\"src/main/java/Formatter.java\");\n        File output = new File(\"src/main/resources/codeOutput.java\");\n";
        reader = new StringReader(inputString);
        IFormatter formatter = new StateMachineFormatter();
        ILexer lexer = new StateMachineLexer(reader);
        formatter.format(lexer, writer);
        assertEquals("Wrong text", expectedString, writer.getString());
    }

    @Test @Ignore
    public void testPartiallyFormattedText2() throws Exception {
        inputString = "public void main() {\nSystem.out.println(\"Hello World\");\n}\n";
        expectedString = "public void main() {\n    System.out.println(\"Hello World\");\n}\n";
        reader = new StringReader(inputString);
        IFormatter formatter = new StateMachineFormatter();
        ILexer lexer = new StateMachineLexer(reader);
        formatter.format(lexer, writer);
        assertEquals("Wrong text", expectedString, writer.getString());
    }

    @Test @Ignore
    public void testFormattedText() throws Exception {
        inputString = "public void main() {\n    System.out.println(\"Hello World\");\n}\n";
        expectedString = "public void main() {\n    System.out.println(\"Hello World\");\n}\n";
        reader = new StringReader(inputString);
        IFormatter formatter = new StateMachineFormatter();
        ILexer lexer = new StateMachineLexer(reader);
        formatter.format(lexer, writer);
        assertEquals("Wrong text", expectedString, writer.getString());
    }
}