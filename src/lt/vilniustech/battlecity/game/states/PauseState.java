package lt.vilniustech.battlecity.game.states;

import lt.vilniustech.battlecity.game.GameThread;
import lt.vilniustech.battlecity.graphics.gui.GUI;

public class PauseState implements State {
    @Override
    public void update() {
        GameThread gameThread = GUI.getInstance().getGameThread();

        assert gameThread != null;
        gameThread.pause();
    }
}
