import java.util.List;

/**
 * Adding line breaks if needed.
 */
final class LineBreaker {
    public static List<String> createLineBreaks(final List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            lines.set(i, lines.get(i).trim());
            if (lines.get(i).startsWith("for")) {
                continue;
            }
            if (lines.get(i).indexOf(";") != lines.get(i).length() - 1 && lines.get(i).contains(";")) {
                lines.add(i + 1, lines.get(i).substring(lines.get(i).indexOf(";") + 1));
                lines.set(i, lines.get(i).substring(0, lines.get(i).indexOf(";") + 1));
            }
            if (lines.get(i).indexOf("{") != lines.get(i).length() - 1 && lines.get(i).contains("{")) {
                lines.add(i + 1, lines.get(i).substring(lines.get(i).indexOf("{") + 1));
                lines.set(i, lines.get(i).substring(0, lines.get(i).indexOf("{") + 1));
            }
            if (lines.get(i).indexOf("}") != lines.get(i).length() - 1 && lines.get(i).contains("}")) {
                lines.add(i + 1, lines.get(i).substring(lines.get(i).indexOf("}") + 1));
                lines.set(i, lines.get(i).substring(0, lines.get(i).indexOf("}") + 1));
            }
        }
        return lines;
    }
}
