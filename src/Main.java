import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameBoard g = new GameBoard();
        start();
    }

    static void start() {
        Scanner sc = new Scanner(System.in);
        GameBoard g = new GameBoard();
        g.displayBoard();
        System.out.println("Player X will make the first move. Good luck.\n");
        int counter = 0;
        while (g.gameActive()) {
            if (counter % 2 == 0) {
                g.askPlayer('X');
            } else {
                g.askPlayer('O');
            }
            g.displayBoard();
            g.checkForWinner();
            counter++;
            if (counter == 9) {
                if (g.gameActive()) {
                    System.out.println("\n\nThe match is a tie.");
                    g.setGameOnGoing(false);
                }
            }
        }
        while (!g.gameActive()) {
            System.out.println("\nPress C to restart the game or Q ut quit the game...");
            String input = sc.nextLine();
            if (input.equals("C") || input.equals("c")) {
                g.setGameOnGoing(true);
                start();
            } else {
                System.exit(0);
            }
        }
    }
}
