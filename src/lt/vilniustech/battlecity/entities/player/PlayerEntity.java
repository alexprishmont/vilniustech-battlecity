package lt.vilniustech.battlecity.entities.player;

import lt.vilniustech.battlecity.game.Game;
import lt.vilniustech.battlecity.graphics.game.player.Health;
import lt.vilniustech.battlecity.graphics.game.player.Score;
import lt.vilniustech.battlecity.state.KeyState;
import lt.vilniustech.battlecity.state.State;
import lt.vilniustech.battlecity.graphics.game.player.Tank;
import lt.vilniustech.battlecity.utils.Direction;
import lt.vilniustech.battlecity.utils.Key;

public class PlayerEntity extends AbstractPlayerEntity {
    private HealthEntity healthEntity;
    private static final float PLAYER_SPEED = 14f;

    public PlayerEntity(Game game, Tank tankSprite) {
        super(game, tankSprite);
    }

    @Override
    public void start() {
        super.start();
        new ScoreEntity(game, new Score(200, 70));
        healthEntity = new HealthEntity(game, new Health(350, 70));
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        if (isKeyDown(Key.KEY_UP)) {
            move(0, -PLAYER_SPEED * deltaTime);
            getTankSprite().setCurrentDirection(Direction.UP);
        } else if (isKeyDown(Key.KEY_DOWN)) {
            move(0, PLAYER_SPEED * deltaTime);
            getTankSprite().setCurrentDirection(Direction.DOWN);
        } else if (isKeyDown(Key.KEY_LEFT)) {
            move(-PLAYER_SPEED * deltaTime, 0);
            getTankSprite().setCurrentDirection(Direction.LEFT);
        } else if (isKeyDown(Key.KEY_RIGHT)) {
            move(PLAYER_SPEED * deltaTime, 0);
            getTankSprite().setCurrentDirection(Direction.RIGHT);
        }

        if (isKeyDown(Key.KEY_SHOOT)) {
            shoot();
        }

        healthEntity.changeHealthOnUI(health);
    }

    private boolean isKeyDown(char key) {
        return KeyState.getInstance().getState(key) == State.DOWN;
    }
}