package lt.vilniustech.battlecity.graphics.game.bullet;

import lt.vilniustech.battlecity.graphics.game.GameGraphics;
import lt.vilniustech.battlecity.utils.Direction;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Bullet extends GameGraphics {
    private static final int WIDTH = 12;
    private static final int LENGTH = 12;
    private static Image[] bulletImages = null;

    static {
        try {
            bulletImages = new Image[]{
                    ImageIO.read(new File("sprites/bulletU.gif")),
                    ImageIO.read(new File("sprites/bulletD.gif")),
                    ImageIO.read(new File("sprites/bulletL.gif")),
                    ImageIO.read(new File("sprites/bulletR.gif"))
            };

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private Map<Character, Image> bullets = new HashMap<>();
    private Direction direction;

    public Bullet(Direction direction, int x, int y) {
        setY(y);
        setX(x);
        this.direction = direction;

        bullets.put(Direction.UP, bulletImages[0]);
        bullets.put(Direction.DOWN, bulletImages[1]);
        bullets.put(Direction.LEFT, bulletImages[2]);
        bullets.put(Direction.RIGHT, bulletImages[3]);
    }

    public void setDirection(char dir) {
        direction.setCurrentDirection(dir);
    }

    public char getDirection() {
        return direction.getCurrentDirection();
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(bullets.get(direction.getCurrentDirection()), getX(), getY(), WIDTH, LENGTH, null);
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(), getY(), WIDTH, LENGTH);
    }
}
