package lt.vilniustech.battlecity.graphics.game.player;

import lt.vilniustech.battlecity.graphics.game.GameGraphics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Health extends GameGraphics {
    private static final String HEALTH_TEXT = "HP: ";
    private static final int WIDTH = 20;
    private static final int LENGTH = 20;

    private float health;

    private static Image[] images = null;

    static {
        try {
            images = new Image[]{
                    ImageIO.read(new File("sprites/hp.png"))
            };
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public Health(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(images[0], getX() - 25, getY() - 18, WIDTH, LENGTH, null);
        graphics.setFont(new Font("Times New Roman", Font.BOLD, 20));
        graphics.drawString(String.format("%s%02f", HEALTH_TEXT, health), getX(), getY());
    }

    @Override
    public Rectangle getRectangle() {
        return null;
    }

    public void setHealth(float health) {
        this.health = health;
    }
}
