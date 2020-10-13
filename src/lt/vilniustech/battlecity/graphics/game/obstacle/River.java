package lt.vilniustech.battlecity.graphics.game.obstacle;

import java.awt.*;

public class River extends Obstacle {
    public static final int WIDTH = 55;
    private static final int LENGTH = 154;

    static {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        images = new Image[]{
                toolkit.getImage(CommonWall.class.getResource("sprites/river.jpg"))
        };
    }

    public River(int x, int y) {
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
