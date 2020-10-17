package lt.vilniustech.battlecity.utils;

public class Direction {
    public static final char UP = 'U';
    public static final char DOWN = 'D';
    public static final char LEFT = 'L';
    public static final char RIGHT = 'R';

    private char currentDirection = UP;

    public Direction() {

    }

    public char getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(char currentDirection) {
        this.currentDirection = currentDirection;
    }
}
