package lt.vilniustech.battlecity.graphics.game.obstacle;

import lt.vilniustech.battlecity.graphics.game.GameGraphics;

import java.awt.*;

public abstract class Obstacle implements GameGraphics {
    protected int x;
    protected int y;
    protected float health = 100f;

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

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }
}
