package lt.vilniustech.battlecity;

import lt.vilniustech.battlecity.entities.Entity;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Game {
    private final Map<Entity, Entity> entities = new ConcurrentHashMap<>();

    public Game() {
    }

    public void start() {
        for (Entity entity : entities.values()) {
            entity.start();
        }
    }

    public void update(float deltaTime) {
        for (Entity entity : entities.values()) {
            entity.update(deltaTime);
        }

        collide();
    }

    public void collide() {
        List<Entity> entityList = new ArrayList<>(entities.values());

        for (int i = 0; i < entityList.size(); i++) {
            for (int j = i + 1; j < entityList.size(); j++) {
                Entity leftEntity = entityList.get(i);
                Entity rightEntity = entityList.get(j);

                if (!leftEntity.intersects(rightEntity)) {
                    continue;
                }

                leftEntity.collides(rightEntity);
                rightEntity.collides(leftEntity);
                break;
            }
        }
    }

    public Map<Entity, Entity> getEntities() {
        return entities;
    }
}