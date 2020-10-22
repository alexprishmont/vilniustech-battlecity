package lt.vilniustech.battlecity.graphics.gui.game;

import lt.vilniustech.battlecity.game.Game;
import lt.vilniustech.battlecity.eventmanager.events.HomeDestroy;
import lt.vilniustech.battlecity.eventmanager.events.NoTanksLeft;
import lt.vilniustech.battlecity.game.states.PauseState;
import lt.vilniustech.battlecity.game.states.PlayState;
import lt.vilniustech.battlecity.game.states.StateManager;
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
    private Game game;

    public GameForm() {
        KeyState.subscribeEvent(KeyPressed.class, (EventListener<KeyPressed>) (event) -> {
            if (event.getPressedKey() == KeyEvent.VK_ESCAPE) {
                GUI.getInstance().switchContentPane(new PauseForm(this));
                StateManager.getInstance().setCurrentState(new PauseState());
            }
        });

        StateManager.getInstance().setCurrentState(new PlayState(this));
    }

    public void setGame(Game game) {
        this.game = game;
        init();
    }

    private void init() {
        game.subscribeGameEvent(HomeDestroy.class,
                (EventListener<HomeDestroy>) event ->
                        GUI.getInstance().switchContentPane(new FinishedForm(event.getScore())));
        game.subscribeGameEvent(NoTanksLeft.class,
                (EventListener<NoTanksLeft>) event ->
                        GUI.getInstance().switchContentPane(new FinishedForm(event.getScore())));

        ((GamePanel) gamePanel).setGame(game);
    }

    private void createUIComponents() {
        gamePanel = new GamePanel();
    }

    @Override
    public JPanel getPanel() {
        return gamePanel;
    }
}
