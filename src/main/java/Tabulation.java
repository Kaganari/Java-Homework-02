import java.util.List;

/**
 * Adding tabulation at the start of the line depending on it's level
 */
final class Tabulation {

    public static List<String> createTabulation(final List<String> lines) {
        int level = 0;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).indexOf("}") == lines.get(i).length() - 1) {
                level--;
            }
            lines.set(i, addSpaces(level, lines.get(i)));
            if (lines.get(i).indexOf("{") == lines.get(i).length() - 1) {
                level++;
            }

        }
        return lines;
    }

    private static String addSpaces(final int lvl, final String line) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lvl; i++) {
            result.append("    ");
        }
        return result.append(line).toString();
    }
}
