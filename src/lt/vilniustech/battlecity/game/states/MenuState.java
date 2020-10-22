package lt.vilniustech.battlecity.game.states;

import lt.vilniustech.battlecity.game.GameThread;
import lt.vilniustech.battlecity.graphics.gui.GUI;

public class MenuState implements State {

    @Override
    public void update() {
        GameThread gameThread = GUI.getInstance().getGameThread();

        if (gameThread == null) {
            return;
        }
        
        gameThread.stop();
        GUI.getInstance().setGameThread(null);
    }
}
