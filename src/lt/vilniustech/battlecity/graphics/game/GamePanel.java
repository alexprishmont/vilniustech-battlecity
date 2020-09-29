package lt.vilniustech.battlecity.graphics.game;

import lt.vilniustech.battlecity.Launcher;
import lt.vilniustech.battlecity.entity.GameMap;
import lt.vilniustech.battlecity.entity.player.Player;
import lt.vilniustech.battlecity.entity.npc.NPC;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel {

    private final GameMap map;

    private final BufferedImage notDestroyableWallImage;
    private final BufferedImage destroyableWallImage;
    private final BufferedImage playerTankImage;
    private final BufferedImage npcTankImage;

    private final List<NPC> npcList = new ArrayList<NPC>();
    private Player player;

    public GamePanel() throws IOException {
        notDestroyableWallImage = ImageIO.read(new FileInputStream("sprites/metalWall.gif"));
        destroyableWallImage = ImageIO.read(new FileInputStream("sprites/commonWall.gif"));
        playerTankImage = ImageIO.read(new FileInputStream("sprites/HtankU.gif"));
        npcTankImage = ImageIO.read(new FileInputStream("sprites/tankU.gif"));

        map = new GameMap();

        initMap();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        setGameWindowBackground(graphics2D);
        renderMap(graphics);
    }

    private void initMap() {
        for (int y = 0; y < map.getWidth(); y++) {
            for (int x = 0; x < map.getHeight(); x++) {
                if (map.isPlayerSpot(y, x)) {
                    player = new Player(x, y);
                    player.getEventManager().subscribe("playerMoved", (eventType, event) -> {
                        repaint();
                    });
                }

                if (map.isNPCSpot(y, x)) {
                    npcList.add(new NPC(x, y));
                }
            }
        }
    }

    private void renderMap(Graphics graphics) {
        int spriteSize = 20;

        for (int y = 0; y < map.getWidth(); y++) {
            for (int x = 0; x < map.getHeight(); x++) {
                if (map.isMetalWall(y, x)) {
                    graphics.drawImage(notDestroyableWallImage, x * spriteSize, y * spriteSize, spriteSize, spriteSize, null);
                }

                if (map.isCommonWall(y, x)) {
                    graphics.drawImage(destroyableWallImage, x * spriteSize, y * spriteSize, spriteSize, spriteSize, null);
                }

                if (player.getPosition()[0] == x && player.getPosition()[1] == y) {
                    graphics.drawImage(playerTankImage, x * spriteSize, y * spriteSize, spriteSize, spriteSize, null);
                }

                for (NPC npc : npcList) {
                    if (npc.getPosition()[0] == x && npc.getPosition()[1] == y) {
                        graphics.drawImage(npcTankImage, x * spriteSize, y * spriteSize, spriteSize, spriteSize, null);
                    }
                }
            }
        }
    }

    private void setGameWindowBackground(Graphics2D graphics2D) {
        graphics2D.setColor(Color.GRAY);
        graphics2D.fillRect(0, 0, Launcher.WINDOW_WIDTH, Launcher.WINDOW_HEIGHT);
    }
}
