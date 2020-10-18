package lt.vilniustech.battlecity.entities.obstacle;

import lt.vilniustech.battlecity.Game;
import lt.vilniustech.battlecity.entities.Entity;
import lt.vilniustech.battlecity.entities.ScoreEntity;
import lt.vilniustech.battlecity.eventmanager.events.HomeDestroy;
import lt.vilniustech.battlecity.graphics.game.GameGraphics;

public class HomeEntity extends Entity {
    public HomeEntity(Game game, GameGraphics sprite) {
        super(game, sprite);
    }

    @Override
    public void destroy() {
        super.destroy();
        Game.getEventManager().notify(new HomeDestroy(ScoreEntity.getScore()));
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void start() {

    }
}
