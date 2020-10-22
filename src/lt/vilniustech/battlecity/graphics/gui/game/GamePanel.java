package lt.vilniustech.battlecity.graphics.gui.game;

import lt.vilniustech.battlecity.game.Game;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Game game;

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void paint(Graphics graphics) {
        assert game != null;
        game.getMap().draw(graphics);
    }
}
