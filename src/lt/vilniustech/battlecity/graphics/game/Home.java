package lt.vilniustech.battlecity.graphics.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Home implements GameGraphics {
    public static final int WIDTH = 20;
    public static final int LENGTH = 20;

    private int x;
    private int y;

    private static Image[] images = null;

    static {
        try {
            images = new Image[]{
                    ImageIO.read(new File("sprites/home.jpg"))
            };
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public Home(int x, int y) {
        this.x = x;
        this.y = y;
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

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(images[0], x, y, WIDTH, LENGTH, null);
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(x, y, WIDTH, LENGTH);
    }
}
