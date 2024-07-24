package Itransition_Java_TAsk3;

import java.util.List;

public class MoveLogic {
    public static String determineWinner(List<String> moves, int userMoveIndex, int computerMoveIndex) {
        int n = moves.size();
        if (userMoveIndex == computerMoveIndex) {
            return "It's a tie!";
        }

        int halfSize = n / 2;
        int winRangeStart = (userMoveIndex + 1) % n;
        int winRangeEnd = (userMoveIndex + halfSize) % n;

        if (winRangeStart < winRangeEnd) {
            if (computerMoveIndex > winRangeStart && computerMoveIndex <= winRangeEnd) {
                return "You win!";
            }
        } else {
            if (computerMoveIndex > winRangeStart || computerMoveIndex <= winRangeEnd) {
                return "You win!";
            }
        }
        return "You lose!";
    }
}
