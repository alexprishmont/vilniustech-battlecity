package lt.vilniustech.battlecity.entities.obstacle;

import lt.vilniustech.battlecity.Game;
import lt.vilniustech.battlecity.entities.Destroyable;
import lt.vilniustech.battlecity.entities.Entity;
import lt.vilniustech.battlecity.graphics.game.GameGraphics;

public class CommonWallEntity extends Entity implements Destroyable {
    public CommonWallEntity(Game game, GameGraphics sprite) {
        super(game, sprite);
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void start() {

    }
}
