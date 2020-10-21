package lt.vilniustech.battlecity.game.rules;

import lt.vilniustech.battlecity.entities.Entity;
import lt.vilniustech.battlecity.entities.player.BotEntity;

import java.util.List;

public class RuleNoTanks implements Rule {

    @Override
    public boolean check(List<Entity> entities) {
        return entities.stream()
                .filter(entity -> entity instanceof BotEntity)
                .map(entity -> (BotEntity) entity).count() <= 0;
    }
}
