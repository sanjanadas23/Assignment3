package TicTacToe.model;

import java.util.Scanner;

public class TicTacToe {
	private Board board;
    private MarkType currentPlayer;

    public TicTacToe() {
        board = new Board();
        currentPlayer = MarkType.X;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            boolean gameWon = false;
            board.resetBoard(); // Reset board before each new game
            currentPlayer = MarkType.X; // Reset first player to 'X'

            while (!gameWon && !board.isBoardFull()) {
                board.displayBoard();
                int move = getValidMove(scanner);

                try {
                    gameWon = board.makeMove(move, currentPlayer);

                    if (gameWon) {
                        board.displayBoard();
                        System.out.println("Player " + currentPlayer + " wins!");
                    } else {
                        if (currentPlayer == MarkType.X) {
                            currentPlayer = MarkType.O;
                        } else {
                            currentPlayer = MarkType.X;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            if (!gameWon) {
                board.displayBoard();
                System.out.println("It's a draw!");
            }

            playAgain = askToPlayAgain(scanner);
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private int getValidMove(Scanner scanner) {
        int move;
        while (true) {
            System.out.print("Player " + currentPlayer + ", enter your move (0-8): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number between 0-8.");
                scanner.next(); // Clear the invalid input
                continue;
            }
            move = scanner.nextInt();

            if (move < 0 || move > 8) {
                System.out.println("Invalid position! Please enter a number between 0-8.");
            } else {
                break;
            }
        }
        return move;
    }

    private boolean askToPlayAgain(Scanner scanner) {
        System.out.print("Do you want to play again? (yes/no): ");
        String response = scanner.next().toLowerCase();
        return response.equals("yes") || response.equals("y");
    }

}
