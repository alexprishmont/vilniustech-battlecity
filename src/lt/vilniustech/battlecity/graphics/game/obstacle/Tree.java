package lt.vilniustech.battlecity.graphics.game.obstacle;

import java.awt.*;

public class Tree extends Obstacle {
    public static final int WIDTH = 30;
    public static final int LENGTH = 30;

    static {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        images = new Image[]{
                toolkit.getImage(CommonWall.class.getResource("sprites/tree.gif"))
        };
    }

    public Tree(int x, int y) {
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
