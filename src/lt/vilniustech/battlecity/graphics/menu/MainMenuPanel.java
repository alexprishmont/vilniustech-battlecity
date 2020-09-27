package lt.vilniustech.battlecity.graphics.menu;

import lt.vilniustech.battlecity.Launcher;
import lt.vilniustech.battlecity.graphics.client.Client;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        setMainMenuBackground(graphics2D);
    }


    private void setMainMenuBackground(Graphics2D graphics2D) {
        graphics2D.setColor(Color.GRAY);
        graphics2D.fillRect(0, 0, Launcher.WINDOW_WIDTH, Launcher.WINDOW_HEIGHT);
    }
}
