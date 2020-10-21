package lt.vilniustech.battlecity.game;

import lt.vilniustech.battlecity.entities.Entity;
import lt.vilniustech.battlecity.entities.NonCollideable;
import lt.vilniustech.battlecity.entities.player.ScoreEntity;
import lt.vilniustech.battlecity.eventmanager.EventManager;
import lt.vilniustech.battlecity.eventmanager.events.HomeDestroy;
import lt.vilniustech.battlecity.eventmanager.events.NoTanksLeft;
import lt.vilniustech.battlecity.eventmanager.events.TankKilled;
import lt.vilniustech.battlecity.factory.MapFactory;
import lt.vilniustech.battlecity.game.rules.Rule;
import lt.vilniustech.battlecity.game.rules.RuleNoTanks;
import lt.vilniustech.battlecity.game.rules.RulePlayerDied;
import lt.vilniustech.battlecity.graphics.game.map.level.DefaultLevel;
import lt.vilniustech.battlecity.utils.EntityType;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Game {
    private final static EventManager eventManager =
            new EventManager(TankKilled.class, HomeDestroy.class, NoTanksLeft.class);
    private static lt.vilniustech.battlecity.graphics.game.map.Map map;
    private final Map<Entity, Entity> entities = new ConcurrentHashMap<>();
    private final Map<Rule, Rule> rules = new ConcurrentHashMap<>();

    public Game() {
        Game.map = new MapFactory()
                .setGame(this)
                .setLevel(new DefaultLevel())
                .create();

        rules.put(new RuleNoTanks(), new RuleNoTanks());
        rules.put(new RulePlayerDied(), new RulePlayerDied());
    }

    public static EventManager getEventManager() {
        return eventManager;
    }

    public static lt.vilniustech.battlecity.graphics.game.map.Map getMap() {
        return map;
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

        for (Rule rule : rules.values()) {
            if (!rule.check(new ArrayList<>(entities.values()))) {
                continue;
            }

            getEventManager().notify(new NoTanksLeft(ScoreEntity.getScore()));
            break;
        }
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

    public Map<Entity, Entity> getEntities() {
        return entities;
    }
}