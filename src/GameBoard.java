import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {
    private char gameBoard[][];
    private boolean gameOnGoing = true;

    public GameBoard() {
        gameBoard = new char[3][3];
        for (int i = 0; i < gameBoard.length; i++) {
            Arrays.fill(gameBoard[i], ' ');
        }
    }

    public void setGameOnGoing(boolean input) {
        gameOnGoing = input;
    }

    public boolean gameActive() {
        return gameOnGoing;
    }

    public void displayBoard() {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[row].length; col++) {
                System.out.print(gameBoard[row][col]);
                if (col == 0 || col == 1) {
                    System.out.print("  | ");
                }
            }
            if (row == 1 || row == 0) {
                System.out.println("\n-------------");
            }
        }
        System.out.println("\n\n");
    }

    public boolean isEmpty(int row, int col) {
        if (gameBoard[row - 1][col - 1] == ' ') {
            return true;
        } else {
            System.out.println("This place is already taken.");
            return false;
        }
    }

    public boolean notValid(int row, int col) {
        if (row > 3 || row < 1 || col < 1 || col > 3 || !isEmpty(row, col)) {
            System.out.println("Invalid Move!   Please try again...");
            return true;
        } else {
            return false;
        }
    }

    public void makeMove(char player, int row, int col) {
        gameBoard[row - 1][col - 1] = player;
    }

    public void askPlayer(char player) {
        int row, col;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.printf("Player %c, enter a row (0-3): ", player);
            row = sc.nextInt();
            System.out.printf("\nPlayer %c, enter a col (0-3): ", player);
            col = sc.nextInt();
        } while (notValid(row, col));
        makeMove(player, row, col);
    }

    public void checkForWinner() {
        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[0][i] == gameBoard[1][i] && gameBoard[0][i] == gameBoard[2][i] && gameBoard[0][i] != ' ' && gameActive()) {
                System.out.printf("\n\nThe winner is player %c!\n", gameBoard[0][i]);
                setGameOnGoing(false);
            } else if (gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][0] == gameBoard[i][2] && gameBoard[i][0] != ' ' && gameActive()) {
                System.out.printf("\n\nThe winner is player %c!\n", gameBoard[i][0]);
                setGameOnGoing(false);
            }
        }
        if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2] && gameBoard[0][0] != ' ' && gameActive()) {
            System.out.printf("The winner is player %c!", gameBoard[0][0]);
            setGameOnGoing(false);
        } else if (gameBoard[0][2] == gameBoard[1][1] && gameBoard[0][2] == gameBoard[2][0] && gameBoard[0][2] != ' ' && gameActive()) {
            System.out.printf("The winner is player %c!", gameBoard[0][2]);
            setGameOnGoing(false);
        }
    }
}
