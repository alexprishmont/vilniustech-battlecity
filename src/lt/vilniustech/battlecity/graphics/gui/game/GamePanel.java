package lt.vilniustech.battlecity.graphics.gui.game;

import lt.vilniustech.battlecity.Game;
import lt.vilniustech.battlecity.graphics.game.map.Map;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    @Override
    public void paint(Graphics graphics) {
        Game.getMap().draw(graphics);
    }
}
