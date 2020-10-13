package lt.vilniustech.battlecity.graphics.game.player;

import lt.vilniustech.battlecity.graphics.game.GameGraphics;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public abstract class Tank implements GameGraphics {
    public static final int WIDTH = 35;
    public static final int LENGTH = 35;
    protected static Image[] images = null;

    protected Map<String, Image> tankDirections = new HashMap<String, Image>();
    protected String currentDirection = "U";
    protected int x;
    protected int y;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;

        this.tankDirections.put("D", images[0]);
        this.tankDirections.put("U", images[1]);
        this.tankDirections.put("L", images[2]);
        this.tankDirections.put("R", images[3]);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(tankDirections.get(currentDirection), x, y, null);
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(x, y, WIDTH, LENGTH);
    }

    public String getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(String currentDirection) {
        this.currentDirection = currentDirection;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
