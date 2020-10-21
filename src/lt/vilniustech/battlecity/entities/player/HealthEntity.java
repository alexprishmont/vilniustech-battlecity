package lt.vilniustech.battlecity.entities.player;

import lt.vilniustech.battlecity.game.Game;
import lt.vilniustech.battlecity.entities.Entity;
import lt.vilniustech.battlecity.entities.NonCollideable;
import lt.vilniustech.battlecity.graphics.game.player.Health;

public class HealthEntity extends Entity implements NonCollideable {
    public HealthEntity(Game game, Health sprite) {
        super(game, sprite);
    }

    public void changeHealthOnUI(float hp) {
        ((Health) sprite).setHealth(hp);
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void start() {

    }
}
