package lt.vilniustech.battlecity.utils;

import lt.vilniustech.battlecity.entities.Entity;

import java.util.List;

public class Distance {
    public static float getDistance (Entity entity1, Entity entity2) {
        float deltaX = getDeltaX(entity1, entity2);
        float deltaY = getDeltaY(entity1, entity2);
        return (float) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    public static Entity getClosestBetweenThreeEntities(Entity toEntity, Entity entity1, Entity entity2) {
        if (getDistance(toEntity, entity1) > getDistance(toEntity, entity2)) {
            return entity2;
        }

        return entity1;
    }

    public static float getDeltaX(Entity entity1, Entity entity2) {
        return entity2.getSprite().getX() - entity1.getSprite().getX();
    }

    public static float getDeltaY(Entity entity1, Entity entity2) {
        return entity2.getSprite().getY() - entity1.getSprite().getY();
    }
}
