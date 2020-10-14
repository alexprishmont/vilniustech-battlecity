package lt.vilniustech.battlecity.graphics.game.obstacle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class River extends Obstacle {
    public static final int WIDTH = 20;
    private static final int LENGTH = 20;

    private static Image[] images = null;
    static {
        try {
            images = new Image[]{
                    ImageIO.read(new File("sprites/river.jpg"))
            };
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public River(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(images[0], x, y, WIDTH, LENGTH, null);
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(x, y, WIDTH, LENGTH);
    }
}
