package lt.vilniustech.battlecity.graphics.game.player;

import lt.vilniustech.battlecity.graphics.game.GameGraphics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Home extends GameGraphics {
    public static final int WIDTH = 20;
    public static final int LENGTH = 20;

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
        setX(x);
        setY(y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(images[0], getX(), getY(), WIDTH, LENGTH, null);
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(), getY(), WIDTH, LENGTH);
    }
}
