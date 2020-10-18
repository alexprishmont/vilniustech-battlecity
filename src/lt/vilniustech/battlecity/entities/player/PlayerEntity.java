package lt.vilniustech.battlecity.entities.player;

import lt.vilniustech.battlecity.Game;
import lt.vilniustech.battlecity.entities.ScoreEntity;
import lt.vilniustech.battlecity.graphics.game.Score;
import lt.vilniustech.battlecity.state.KeyState;
import lt.vilniustech.battlecity.state.State;
import lt.vilniustech.battlecity.graphics.game.player.Tank;
import lt.vilniustech.battlecity.utils.Direction;
import lt.vilniustech.battlecity.utils.Key;

public class PlayerEntity extends AbstractPlayerEntity {
    public PlayerEntity(Game game, Tank tankSprite) {
        super(game, tankSprite);
        new ScoreEntity(game, new Score(200, 70));
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        if (isKeyDown(Key.KEY_UP)) {
            move(0, -AbstractPlayerEntity.PLAYER_SPEED * deltaTime);
            getTankSprite().setCurrentDirection(Direction.UP);
        } else if (isKeyDown(Key.KEY_DOWN)) {
            move(0, AbstractPlayerEntity.PLAYER_SPEED * deltaTime);
            getTankSprite().setCurrentDirection(Direction.DOWN);
        } else if (isKeyDown(Key.KEY_LEFT)) {
            move(-AbstractPlayerEntity.PLAYER_SPEED * deltaTime, 0);
            getTankSprite().setCurrentDirection(Direction.LEFT);
        } else if (isKeyDown(Key.KEY_RIGHT)) {
            move(AbstractPlayerEntity.PLAYER_SPEED * deltaTime, 0);
            getTankSprite().setCurrentDirection(Direction.RIGHT);
        }

        if (isKeyDown(Key.KEY_SHOOT)) {
            shoot();
        }
    }

    private boolean isKeyDown(char key) {
        return KeyState.getInstance().getState(key) == State.DOWN;
    }
}