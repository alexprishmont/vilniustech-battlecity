package lt.vilniustech.battlecity;

import lt.vilniustech.battlecity.entities.Entity;
import lt.vilniustech.battlecity.entities.NonCollideable;
import lt.vilniustech.battlecity.entities.player.ScoreEntity;
import lt.vilniustech.battlecity.entities.player.BotEntity;
import lt.vilniustech.battlecity.eventmanager.EventManager;
import lt.vilniustech.battlecity.eventmanager.events.HomeDestroy;
import lt.vilniustech.battlecity.eventmanager.events.NoTanksLeft;
import lt.vilniustech.battlecity.eventmanager.events.TankKilled;
import lt.vilniustech.battlecity.utils.EntityType;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Game {
    private final static EventManager eventManager =
            new EventManager(TankKilled.class, HomeDestroy.class, NoTanksLeft.class);
    private final Map<Entity, Entity> entities = new ConcurrentHashMap<>();

    public Game() {
    }

    public static EventManager getEventManager() {
        return eventManager;
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
        checkIfPlayerWon();
    }

    public void collide() {
        List<Entity> entityList = new ArrayList<>(entities.values());

        entityList.removeIf(entity -> EntityType.isEntity(entity, NonCollideable.class) != null);

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

    private void checkIfPlayerWon() {
        List<Entity> entityList = new ArrayList<>(entities.values());
        entityList = entityList.stream()
                .filter(entity -> entity instanceof BotEntity)
                .map(entity -> (BotEntity) entity)
                .collect(Collectors.toList());

        if (entityList.size() <= 0) {
            eventManager.notify(new NoTanksLeft(ScoreEntity.getScore()));
        }
    }

    public Map<Entity, Entity> getEntities() {
        return entities;
    }
}