package lt.vilniustech.battlecity.graphics.game;

import java.awt.*;

public abstract class GameGraphics implements Drawable {
    private int x;
    private int y;

    public abstract Rectangle getRectangle();

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
