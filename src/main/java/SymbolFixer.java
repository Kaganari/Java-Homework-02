/**
 * Created by User on 03.11.2017.
 */
public class SymbolFixer {
    public static char[] fixSymbol(final char ch, final int level, final boolean codeStarted) {
        char[] result = new char[3];
        switch (ch) {
            case '{':
                result[0] = ch;
                result[1] = '\n';
                result[2] = (char) (level + 1);
                break;
            case '}':
                result[0] = ch;
                result[1] = '\n';
                result[2] = (char) (level - 1);
                break;
            case ';':
                result[0] = ch;
                result[1] = '\n';
                result[2] = (char) (level);
                break;
            case ' ':
                if (codeStarted) {
                    result[0] = ch;
                }
                result[2] = (char) (level);
                break;
            default:
                result[0] = ch;
                result[2] = (char) (level);
        }
        return result;
    }
    public static String makeTabulations(final int level) {
        return "    ";
    }
}
