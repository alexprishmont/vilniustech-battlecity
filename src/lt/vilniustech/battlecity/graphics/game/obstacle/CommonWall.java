package lt.vilniustech.battlecity.graphics.game.obstacle;

import lt.vilniustech.battlecity.graphics.game.GameGraphics;

import java.awt.*;

public class CommonWall extends Obstacle {
    public static final int WIDTH = 22;
    public static final int LENGTH = 21;

    static {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        images = new Image[]{
                toolkit.getImage(CommonWall.class.getResource("sprites/commonWall.gif"))
        };
    }

    public CommonWall(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(images[0], x, y, null);
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(x, y, WIDTH, LENGTH);
    }
}
