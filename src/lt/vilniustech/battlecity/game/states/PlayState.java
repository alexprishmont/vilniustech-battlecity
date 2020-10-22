package lt.vilniustech.battlecity.game.states;

import lt.vilniustech.battlecity.factory.GameThreadFactory;
import lt.vilniustech.battlecity.game.Game;
import lt.vilniustech.battlecity.game.GameThread;
import lt.vilniustech.battlecity.graphics.gui.FormProvider;
import lt.vilniustech.battlecity.graphics.gui.GUI;
import lt.vilniustech.battlecity.graphics.gui.game.GameForm;
import lt.vilniustech.battlecity.utils.FormType;

public class PlayState implements State {

    private FormProvider formProvider;

    public PlayState(FormProvider formProvider) {
        this.formProvider = formProvider;
    }

    @Override
    public void update() {
        GameThread gameThread = GUI.getInstance().getGameThread();

        if (gameThread != null) {
            gameThread.unpause();
            return;
        }

        GameThread newGameThread = new GameThreadFactory()
                .setGame(new Game())
                .create();

        GUI.getInstance().setGameThread(newGameThread);
        newGameThread.start();

        GameForm gameForm = FormType.isForm(this.formProvider, GameForm.class);

        assert gameForm != null;
        gameForm.setGame(newGameThread.getGame());
    }
}
