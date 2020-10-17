package lt.vilniustech.battlecity.entities.player;

import lt.vilniustech.battlecity.Game;
import lt.vilniustech.battlecity.entities.Healable;
import lt.vilniustech.battlecity.graphics.game.player.Tank;

public class BotEntity extends AbstractPlayer implements Healable {
    public BotEntity(Game game, Tank tankSprite) {
        super(game, tankSprite);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
    }
}
