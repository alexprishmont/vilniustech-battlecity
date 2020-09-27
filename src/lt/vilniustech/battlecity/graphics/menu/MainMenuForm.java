package lt.vilniustech.battlecity.graphics.menu;

import lt.vilniustech.battlecity.Launcher;
import lt.vilniustech.battlecity.graphics.FormProvider;
import lt.vilniustech.battlecity.graphics.client.Client;
import lt.vilniustech.battlecity.graphics.game.GameForm;

import javax.swing.*;
import java.awt.*;

public class MainMenuForm implements FormProvider {

    private JPanel mainPanel;
    private JButton playButton;
    private JButton exitButton;
    private JPanel mainMenuPanel;

    public MainMenuForm() {
        playButton.addActionListener(e -> {
            Client currentClient = Launcher.getCurrentClient();
            if (currentClient != null) {
                currentClient.updateContentPane(new GameForm());
            }
        });

        exitButton.addActionListener(e -> {
            System.exit(0);
        });
    }

    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void createUIComponents() {
        mainMenuPanel = new MainMenuPanel();
    }
}
