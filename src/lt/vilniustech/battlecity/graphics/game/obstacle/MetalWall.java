package lt.vilniustech.battlecity.graphics.game.obstacle;

import lt.vilniustech.battlecity.graphics.game.GameGraphics;

import java.awt.*;


public class MetalWall extends Obstacle {
    public static final int WIDTH = 36;
    public static final int LENGTH = 37;

    static {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        images = new Image[]{
                toolkit.getImage(CommonWall.class.getResource("sprites/metalWall.gif"))
        };
    }

    public MetalWall(int x, int y) {
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
