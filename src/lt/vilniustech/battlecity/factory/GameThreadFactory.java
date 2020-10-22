package lt.vilniustech.battlecity.factory;

import lt.vilniustech.battlecity.game.Game;
import lt.vilniustech.battlecity.game.GameThread;

public class GameThreadFactory implements Factory<GameThread>{
    private Game game;

    public GameThreadFactory setGame(Game game) {
        this.game = game;
        return this;
    }

    @Override
    public GameThread create() {
        return new GameThread(game);
    }
}
