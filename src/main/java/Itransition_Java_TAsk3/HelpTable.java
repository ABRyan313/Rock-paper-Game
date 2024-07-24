package Itransition_Java_TAsk3;

import java.util.List;

public class HelpTable {

    public static String generateHelpTable(List<String> moves) {
        StringBuilder table = new StringBuilder();

        // Header row
        /*table.append("+-------------+");
        for (String move : moves) {
            table.append(String.format(" %-6s+", move));
        }
        table.append("\n");*/

        // Sub-header row
        table.append("| v PC\\User > |");
        for (String move : moves) {
            table.append(String.format(" %-6s|", move));
        }
        table.append("\n");

        // Divider row
        table.append("+-------------+");
        for (int i = 0; i < moves.size(); i++) {
            table.append("------+");
        }
        table.append("\n");

        // Rows for each move
        int half = moves.size() / 2;
        for (int i = 0; i < moves.size(); i++) {
            table.append(String.format("| %-11s|", moves.get(i)));

            for (int j = 0; j < moves.size(); j++) {
                if (i == j) {
                    table.append(" Draw |");
                } else if ((j > i && j <= i + half) || (j < i && j + moves.size() <= i + half + moves.size())) {
                    table.append(" Win  |");
                } else {
                    table.append(" Lose |");
                }
            }
            table.append("\n");

            // Divider row after each move
            table.append("+-------------+");
            for (int k = 0; k < moves.size(); k++) {
                table.append("------+");
            }
            table.append("\n");
        }

        return table.toString();
    }
}
