public class Treasure {

    private final int x;
    private final int y;

    private boolean isFound;

    public Treasure(int x, int y) {
        this.x = x;
        this.y = y;
        this.isFound = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setIsFound(Boolean status) {
        this.isFound = status;
    }

    public boolean getIsFound() {
        return isFound;
    }
}