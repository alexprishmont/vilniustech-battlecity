package lt.vilniustech.battlecity.graphics.game.player;

import lt.vilniustech.battlecity.graphics.game.GameGraphics;
import lt.vilniustech.battlecity.utils.Direction;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public abstract class Tank extends GameGraphics {
    public static final int WIDTH = 20;
    public static final int LENGTH = 20;

    protected static Image[] images = null;

    protected Map<Character, Image> tankDirections = new HashMap<>();
    protected Direction direction;

    public Tank(int x, int y) {
        setX(x);
        setY(y);
        direction = new Direction();
        direction.setCurrentDirection(Direction.UP);

        this.tankDirections.put(Direction.DOWN, images[0]);
        this.tankDirections.put(Direction.UP, images[1]);
        this.tankDirections.put(Direction.LEFT, images[2]);
        this.tankDirections.put(Direction.RIGHT, images[3]);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(tankDirections.get(direction.getCurrentDirection()), getX(), getY(), WIDTH, LENGTH, null);
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(), getY(), WIDTH, LENGTH);
    }

    public char getCurrentDirection() {
        return direction.getCurrentDirection();
    }

    public void setCurrentDirection(char currentDirection) {
        this.direction.setCurrentDirection(currentDirection);
    }
}
