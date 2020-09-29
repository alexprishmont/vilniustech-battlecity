package lt.vilniustech.battlecity.graphics.game;

import lt.vilniustech.battlecity.graphics.FormProvider;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class GameForm implements FormProvider {
    private JPanel mainPanel;
    private JPanel gamePanel;

    public GameForm() {

    }

    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void createUIComponents() throws IOException {
        gamePanel = new GamePanel();
    }
}
