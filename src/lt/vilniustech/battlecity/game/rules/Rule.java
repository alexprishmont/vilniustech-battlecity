package lt.vilniustech.battlecity.game.rules;

import lt.vilniustech.battlecity.entities.Entity;

import java.util.List;

public interface Rule {
    boolean check(List<Entity> entities);
}
