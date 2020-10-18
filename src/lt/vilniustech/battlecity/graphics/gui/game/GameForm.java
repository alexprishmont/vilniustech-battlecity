package lt.vilniustech.battlecity.graphics.gui.game;

import lt.vilniustech.battlecity.Game;
import lt.vilniustech.battlecity.entities.obstacle.HomeEntity;
import lt.vilniustech.battlecity.eventmanager.events.HomeDestroy;
import lt.vilniustech.battlecity.eventmanager.events.NoTanksLeft;
import lt.vilniustech.battlecity.graphics.gui.finished.FinishedForm;
import lt.vilniustech.battlecity.state.KeyState;
import lt.vilniustech.battlecity.eventmanager.EventListener;
import lt.vilniustech.battlecity.eventmanager.events.KeyPressed;
import lt.vilniustech.battlecity.graphics.gui.FormProvider;
import lt.vilniustech.battlecity.graphics.gui.GUI;
import lt.vilniustech.battlecity.graphics.gui.pause.PauseForm;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class GameForm implements FormProvider {
    private JPanel gamePanel;

    public GameForm() {
        KeyState.getEventManager().subscribe(KeyPressed.class, (EventListener<KeyPressed>) (event) -> {
            if (event.getPressedKey() == KeyEvent.VK_ESCAPE) {
                GUI.getInstance().switchContentPane(new PauseForm(this));
            }
        });

        Game.getEventManager().subscribe(HomeDestroy.class,
                (EventListener<HomeDestroy>) event ->
                        GUI.getInstance().switchContentPane(new FinishedForm(event.getScore())));
        Game.getEventManager().subscribe(NoTanksLeft.class,
                (EventListener<NoTanksLeft>) event ->
                        GUI.getInstance().switchContentPane(new FinishedForm(event.getScore())));
    }

    private void createUIComponents() {
        gamePanel = new GamePanel();
    }

    @Override
    public JPanel getPanel() {
        return gamePanel;
    }
}
