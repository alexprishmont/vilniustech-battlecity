package lt.vilniustech.battlecity.factory;

import lt.vilniustech.battlecity.Game;
import lt.vilniustech.battlecity.graphics.game.map.Map;
import lt.vilniustech.battlecity.graphics.game.map.level.Level;

public class MapFactory implements Factory<Map> {
    private Level level;
    private Game game;

    public MapFactory setLevel(Level level) {
        this.level = level;
        return this;
    }

    public MapFactory setGame(Game game) {
        this.game = game;
        return this;
    }

    @Override
    public Map create() {
        return new Map(level, game);
    }
}
