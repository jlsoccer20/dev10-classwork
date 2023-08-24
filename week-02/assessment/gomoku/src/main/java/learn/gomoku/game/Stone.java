package learn.gomoku.game;

public class Stone {

    private final int row;
    private final int column;
    private final boolean black;

    // Constructor
    public Stone(int row, int column, boolean isBlack) {
        this.row = row;
        this.column = column;
        this.black = isBlack;
    }

    // Method with return type "int"
    public int getRow() {
        return row;
    }

    // Method with return type "int"
    public int getColumn() {
        return column;
    }

    // Method with return type "boolean"
    public boolean isBlack() {
        return black;
    }
}
