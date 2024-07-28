package leetcode.problems.string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification68 {

    public static void main(String[] args) {
        String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth = 20;

        System.out.println(new TextJustification68().fullJustify(words, maxWidth));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        final List<String> result = new ArrayList<>();
        int remainingWidth = maxWidth;
        //List<List<String>> lines = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int lineLength = 0;
        //int count = 0;
        for (String word : words) {
            if (lineLength + word.length() + line.size() > remainingWidth) {
                result.add(justifyLine(line, lineLength, maxWidth));
                lineLength = 0;
                line.clear();
            }
            line.add(word);
            lineLength += word.length();
        }
        if (!line.isEmpty()) {
            result.add(justifyLastLine(line, maxWidth));
        }

        return result;
    }

    public String justifyLine(List<String> line, int lineLength, int maxWidth) {
        if (line.size() == 1) {
            return justifyLastLine(line, maxWidth);
        }
        StringBuilder sb = new StringBuilder();
        int spaces = maxWidth - lineLength;
        int gaps = line.size() - 1;
        int space = spaces / gaps;
        int extraSpace = spaces % gaps;
        for (int i = 0; i < line.size(); i++) {
            if (i > 0) {
                sb.append(" ".repeat(space));
                if (extraSpace > 0) {
                    sb.append(" ");
                    extraSpace--;
                }
            }
            sb.append(line.get(i));
        }
        return sb.toString();
    }

    public String justifyLastLine(List<String> line, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.size(); i++) {
            sb.append(line.get(i));
            if (i < line.size() - 1) {
                sb.append(" ");
            }
        }
        sb.append(" ".repeat(maxWidth - sb.length()));
        return sb.toString();
    }
}
