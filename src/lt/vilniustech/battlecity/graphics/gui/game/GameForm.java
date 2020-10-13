package lt.vilniustech.battlecity.graphics.gui.game;

import lt.vilniustech.battlecity.Game;
import lt.vilniustech.battlecity.eventmanager.EventListener;
import lt.vilniustech.battlecity.eventmanager.events.KeyPressed;
import lt.vilniustech.battlecity.graphics.gui.FormProvider;
import lt.vilniustech.battlecity.graphics.gui.GUI;
import lt.vilniustech.battlecity.graphics.gui.pause.PauseForm;
import lt.vilniustech.battlecity.listeners.KeyListener;

import javax.swing.*;

public class GameForm implements FormProvider {
    private JPanel gamePanel;
    private JTextField textField1;
    private JButton button1;

    public GameForm() {
        KeyListener.getEventManager().subscribe(KeyPressed.class, (EventListener<KeyPressed>) (event) -> {
            if (event.getPressedKey().equals("PAUSE")) {
                GUI.getInstance().switchContentPane(new PauseForm(this));
            }
        });

        new Game().hello();
    }

    private void createUIComponents() {
        gamePanel = new GamePanel();
    }

    @Override
    public JPanel getPanel() {
        return gamePanel;
    }
}
