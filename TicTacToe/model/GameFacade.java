package TicTacToe.model;

import java.util.Scanner;

public class GameFacade {
	private Board board;
    private ResultAnalyzer resultAnalyzer;
    private MarkType currentPlayer;
    private Scanner scanner;

    public GameFacade() {
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        while (true) {
            playGame();
            System.out.println("Do you want to play again? (yes/no):");
            String response = scanner.next().trim().toLowerCase();
            if (!response.equals("yes")) {
                System.out.println("Thanks for playing! Goodbye.");
                break;
            }
            resetGame();
        }
        scanner.close();
    }

    private void playGame() {
        board = new Board();
        resultAnalyzer = new ResultAnalyzer(board);
        currentPlayer = MarkType.X;

        while (true) {
            board.displayBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (0-8):");
            int move = scanner.nextInt();

            try {
                board.setCellMark(move, currentPlayer);
                String result = resultAnalyzer.analyzeResult();
                if (!result.equals("Game in Progress...")) {
                    board.displayBoard();
                    System.out.println(result);
                    break;
                }
                currentPlayer = (currentPlayer == MarkType.X) ? MarkType.O : MarkType.X;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void resetGame() {
        board = new Board();
        resultAnalyzer = new ResultAnalyzer(board);
        currentPlayer = MarkType.X;
    }
}
