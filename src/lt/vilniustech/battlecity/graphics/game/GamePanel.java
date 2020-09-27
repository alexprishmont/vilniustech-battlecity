package lt.vilniustech.battlecity.graphics.game;

import lt.vilniustech.battlecity.Launcher;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class GamePanel extends JPanel {

    private final GameMap map;

    private final BufferedImage notDestroyableWallImage;
    private BufferedImage destroyableWallImage;
    private BufferedImage playerTankImage;
    private BufferedImage npcTankImage;

    public GamePanel() throws IOException {
        notDestroyableWallImage = ImageIO.read(new FileInputStream("sprites/metalWall.gif"));
        destroyableWallImage = ImageIO.read(new FileInputStream("sprites/commonWall.gif"));
        playerTankImage = ImageIO.read(new FileInputStream("sprites/HtankU.gif"));
        npcTankImage = ImageIO.read(new FileInputStream("sprites/tankU.gif"));

        map = new GameMap();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        setGameWindowBackground(graphics2D);
        renderMap(graphics);
    }

    private void renderMap(Graphics graphics) {
        int spriteSize = 20;

        for (int y = 0; y < map.getWidth(); y++) {
            for (int x = 0; x < map.getHeight(); x++) {
                if (map.isMetalWall(y, x)) {
                    graphics.drawImage(notDestroyableWallImage, x * spriteSize, y * spriteSize, spriteSize, spriteSize, null);
                    continue;
                }
                if (map.isCommonWall(y, x)) {
                    graphics.drawImage(destroyableWallImage, x * spriteSize, y * spriteSize, spriteSize, spriteSize, null);
                    continue;
                }
            }
        }
    }

    private void setGameWindowBackground(Graphics2D graphics2D) {
        graphics2D.setColor(Color.GRAY);
        graphics2D.fillRect(0, 0, Launcher.WINDOW_WIDTH, Launcher.WINDOW_HEIGHT);
    }
}
