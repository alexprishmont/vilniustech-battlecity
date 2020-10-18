package lt.vilniustech.battlecity.entities.obstacle;

import lt.vilniustech.battlecity.Game;
import lt.vilniustech.battlecity.entities.Driveable;
import lt.vilniustech.battlecity.entities.Entity;
import lt.vilniustech.battlecity.graphics.game.GameGraphics;

public class TreeEntity extends Entity implements Driveable {

    public TreeEntity(Game game, GameGraphics sprite) {
        super(game, sprite);
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void start() {

    }
}
