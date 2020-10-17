package lt.vilniustech.battlecity.utils;

import lt.vilniustech.battlecity.Game;
import lt.vilniustech.battlecity.entities.Entity;

public class Collision {
    private final Game game;

    public Collision(Game game) {
        this.game = game;
    }

    public boolean collides(Entity entity) {
        for (Entity collisionEntity : game.getEntities().values()) {
            if (collisionEntity == entity) {
                continue;
            }

            if (entity.getSprite().getRectangle().intersects(collisionEntity.getSprite().getRectangle())) {
                return true;
            }
        }

        return false;
    }
}
