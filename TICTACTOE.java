import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] panel = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                panel[i][j] = ' ';
            }
        }
        char player = 'X';
        boolean hasWon = false;
        int moves = 0;
        while (!hasWon && moves < 9) {
            printBoard(panel);
            System.out.println("Player " + player + ", enter your move (row and column):");
            int row = sc.nextInt()-1;
            int col = sc.nextInt()-1;
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && panel[row][col] == ' ') {
                panel[row][col] = player;
                moves++;
                hasWon = checkWin(panel, player);
                if (hasWon) {
                    System.out.println("Player " + player + " has won!");
                } else if (moves == 9) {
                    System.out.println("It's a tie!");
                }
                player = (player == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move, please try again.");
            }
        }
        printBoard(panel);
        sc.close();
    }
    static void printBoard(char[][] panel) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + panel[i][j] + " |");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    static boolean checkWin(char[][] panel, char player) {
        for (int i = 0; i < 3; i++) {
            if (panel[i][0] == player && panel[i][1] == player && panel[i][2] == player) {
                return true;
            }
            if (panel[0][i] == player && panel[1][i] == player && panel[2][i] == player) {
                return true;
            }
        }
        if (panel[0][0] == player && panel[1][1] == player && panel[2][2] == player) {
            return true;
        }
        if (panel[0][2] == player && panel[1][1] == player && panel[2][0] == player) {
            return true;
        }
        return false;
    }
}