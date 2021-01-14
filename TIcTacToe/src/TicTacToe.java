import java.util.Scanner;

public class TicTacToe {

    private char[][] board;
    private char player;

    public TicTacToe() {
        board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        player = 'X';
    }

    public boolean play(String position) {

        int i = position.charAt(0) - 65;
        int j = Character.getNumericValue(position.charAt(1)) - 1;

        if (i < 0 || i >= 3) {
            return false;
        } else if (j < 0 || j >= 3) {
            return false;
        } else if (board[i][j] != ' ') {
            return false;
        } else {
            board[i][j] = player;
            return true;
        }
    }

    public void switchTurn() {
        if (player == 'X') {
            player = 'O';
        } else {
            player = 'X';
        }
    }

    public boolean won() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][2] != ' ') {
                return true;
            } else if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[2][i] != ' ') {
                return true;
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] != ' ') {
            return true;
        }
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[0][2] != ' ') {
            return true;
        }
        return false;
    }

    public boolean stalemate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    public char getPlayer() {
        return player;
    }

    public void print() {
        System.out.println();
        System.out.println("\t  1 2 3");
        System.out.println();
        System.out.println("\tA " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("\t  -----");
        System.out.println("\tB " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("\t  " + "-----");
        System.out.println("\tC " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        System.out.println("Welcome to Tic-tac-toe!");
        System.out.println("Enter the coordinates for your move following the X and O prompts.");

        while (!game.stalemate()) {
            game.print();
            System.out.print(game.getPlayer() + ":");

            //Loop while the method play does not return true when given their move.
            //Body of loop should ask for a different move
            while (!game.play(in.next())) {
                System.out.println("Illegal move. Enter your move again.");
                System.out.print(game.getPlayer() + ":");
            }
            //If the game is won, call break;
            if (game.won())
                break;

            //Switch the turn
            game.switchTurn();

        }
        game.print();
        if (game.won()) {
            System.out.println("Player " + game.getPlayer() + " Wins!");
        } else {
            System.out.println("Stalemate");
        }

    }
}

