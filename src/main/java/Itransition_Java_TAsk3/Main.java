package Itransition_Java_TAsk3;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length < 3 || args.length % 2 == 0) {
            System.out.println(ValidationError.InvalidLength);
            return;
        }

        if (Arrays.stream(args).distinct().count() != args.length) {
            System.out.println(ValidationError.InvalidArguments);
            return;
        }

        List<String> moves = Arrays.asList(args);
        SecureRandom r = new SecureRandom();



        while (true) {
            //Generating new computer move with HMAC for each round
            int computerMoveIndex = r.nextInt(moves.size());
            String computerMove = moves.get(computerMoveIndex);

            String key = HMACUtil.generateKey();
            String hmac = HMACUtil.calculateHMAC(computerMove, key);

            System.out.println("Computer HMAC: " + hmac);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Available moves:");
            for (int i = 0; i < moves.size(); i++) {
                System.out.println((i + 1) + " - " + moves.get(i));
            }
            System.out.println("0 - exit");
            System.out.println("? - help");

            System.out.print("Enter your move: ");
            String input = scanner.nextLine();

            if (input.equals("0")) {
                System.out.println("Game terminated");
                break;
            }
            if (input.equals("?")) {
                System.out.println(HelpTable.generateHelpTable(moves));
                continue;
            }

            try {
                int userMoveIndex = Integer.parseInt(input) - 1;
                if (userMoveIndex < 0 || userMoveIndex >= moves.size()) {
                    throw new NumberFormatException();
                }

                String userMove = moves.get(userMoveIndex);
                System.out.println("Your move: " + userMove);
                System.out.println("Computer move: " + computerMove);

                String result = MoveLogic.determineWinner(moves, userMoveIndex, computerMoveIndex);
                System.out.println(result);
                System.out.println("Your key: " + key);

            } catch (NumberFormatException e) {
                System.out.println("Invalid move. Please try again.");
            }
            //scanner.close();
            System.out.println(" ");

        }
    }
}
