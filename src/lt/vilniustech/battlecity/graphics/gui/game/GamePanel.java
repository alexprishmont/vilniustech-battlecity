package lt.vilniustech.battlecity.graphics.gui.game;

import lt.vilniustech.battlecity.graphics.game.Map;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel() {
        Map.getInstance().init();
    }

    @Override
    public void paint(Graphics graphics) {
        Map.getInstance().draw(graphics);
    }
}
