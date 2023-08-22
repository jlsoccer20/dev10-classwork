package learn.gomoku.game;

import learn.gomoku.players.Player;

import java.util.ArrayList;
import java.util.List;

public class Gomoku {

    public static final int WIDTH = 15;

    private final Player playerOne;
    private final Player playerTwo;
    private final char[][] board = new char[WIDTH][WIDTH];

    private ArrayList<Stone> stones = new ArrayList<>();
    private boolean over;
    private Player current;
    private Player winner;
    private boolean blacksTurn = true;


    // Can use getStones() to access the "board" via rows and columns, don't need to access "board" directly
    public List<Stone> getStones() {
        return new ArrayList<>(stones);
    }

    public boolean isOver() {
        return over;
    }

    // Get current player
    public Player getCurrent() {
        return current;
    }

    public Player getWinner() {
        return winner;
    }

    public boolean isBlacksTurn() {
        return blacksTurn;
    }


    // Constructor called "Gomoku" (same as Class name) and has no return type or return value
    public Gomoku(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;

        // Select which player starts
        if (Math.random() < 0.5) {
            current = playerOne;
        } else {
            current = playerTwo;
        }
    }

    // Method with return type "Result" (Class)
    public Result place(Stone stone) {

        if (isOver()) {
            return new Result("Game is over.");
        }

        // Gomoku checks if stone is off the board. If it is, returns new result, success = false
        if (!isValid(stone)) {
            return new Result("Stone is off the board.");
        }

        if (blacksTurn != stone.isBlack()) {
            return new Result("Wrong player.");
        }

        // Duplicate move
        if (board[stone.getRow()][stone.getColumn()] != 0) {
            return new Result("Duplicate move.");
        }

        // B for black or W for white stone
        // Place the stone on the internal board
        board[stone.getRow()][stone.getColumn()] = blacksTurn ? 'B' : 'W';
        // Add valid stone to the stones arrayList that's externally facing
        stones.add(stone); // adding one entry into list array

        if (isWin(stone)) {
            over = true;
            winner = current;
            return new Result(current.getName() + " wins.", true);
        }

        // Runs out of spaces on board?
        if (stones.size() == WIDTH * WIDTH) {
            over = true;
            return new Result("Game ends in a draw.", true);
        }

        blacksTurn = !blacksTurn;
        swap();
        return new Result(null, true);
    }


    // Method with return type "void" (means does not return anything)
    // use "void" in Method to distinguish it from a Constructor
    public void swap() { // Don't worry about calling this, until want to do Bonus
        current = current == playerOne ? playerTwo : playerOne;
    }


    // Method with return type "boolean"
    // Checks that it is within the acceptable parameters
    private boolean isValid(Stone stone) {
        return stone != null
                && stone.getRow() >= 0 && stone.getRow() < WIDTH
                && stone.getColumn() >= 0 && stone.getColumn() < WIDTH;
    }

    // method with return type "boolean"
    private boolean isWin(Stone stone) {
        char symbol = board[stone.getRow()][stone.getColumn()];
        return isHorizontalWin(stone.getRow(), stone.getColumn(), symbol)
                || isVerticalWin(stone.getRow(), stone.getColumn(), symbol)
                || isDiagonalDownWin(stone.getRow(), stone.getColumn(), symbol)
                || isDiagonalUpWin(stone.getRow(), stone.getColumn(), symbol);
    }

    // method with return type "boolean"
    private boolean isHorizontalWin(int row, int column, char symbol) {
        return count(row, column, 1, 0, symbol)
                + count(row, column, -1, 0, symbol) == 4;
    }

    // method with return type "boolean"
    private boolean isVerticalWin(int row, int column, char symbol) {
        return count(row, column, 0, 1, symbol)
                + count(row, column, 0, -1, symbol) == 4;
    }

    // method with return type "boolean"
    private boolean isDiagonalDownWin(int row, int column, char symbol) {
        return count(row, column, 1, 1, symbol)
                + count(row, column, -1, -1, symbol) == 4;
    }

    // method with return type "boolean"
    private boolean isDiagonalUpWin(int row, int column, char symbol) {
        return count(row, column, -1, 1, symbol)
                + count(row, column, 1, -1, symbol) == 4;
    }

    // method with return type "int"
    private int count(int row, int col, int deltaRow, int deltaCol, char symbol) {

        int result = 0;
        int r = row + deltaRow;
        int c = col + deltaCol;

        while (r >= 0 && r < WIDTH && c >= 0 && c < WIDTH && board[r][c] == symbol) {
            result++;
            r += deltaRow;
            c += deltaCol;
        }

        return result;
    }

}
