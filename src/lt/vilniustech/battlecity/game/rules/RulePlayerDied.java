package lt.vilniustech.battlecity.game.rules;

import lt.vilniustech.battlecity.entities.Entity;
import lt.vilniustech.battlecity.entities.player.PlayerEntity;

import java.util.List;

public class RulePlayerDied implements Rule {

    @Override
    public boolean check(List<Entity> entities) {
        return entities.stream()
                .filter(entity -> entity instanceof PlayerEntity)
                .map(entity -> (PlayerEntity) entity).count() <= 0;
    }
}
