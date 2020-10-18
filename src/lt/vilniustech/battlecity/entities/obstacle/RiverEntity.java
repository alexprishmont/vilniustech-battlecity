package lt.vilniustech.battlecity.entities.obstacle;

import lt.vilniustech.battlecity.Game;
import lt.vilniustech.battlecity.entities.Driveable;
import lt.vilniustech.battlecity.entities.Entity;
import lt.vilniustech.battlecity.graphics.game.GameGraphics;

public class RiverEntity extends Entity implements Driveable {
    public RiverEntity(Game game, GameGraphics sprite) {
        super(game, sprite);
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void start() {

    }
}
