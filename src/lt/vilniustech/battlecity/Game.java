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
    }

    public Map<Entity, Entity> getEntities() {
        return entities;
    }
}