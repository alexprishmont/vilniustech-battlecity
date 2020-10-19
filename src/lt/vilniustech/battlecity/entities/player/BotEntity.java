package lt.vilniustech.battlecity.entities.player;

import lt.vilniustech.battlecity.Game;
import lt.vilniustech.battlecity.entities.Entity;
import lt.vilniustech.battlecity.entities.obstacle.CommonWallEntity;
import lt.vilniustech.battlecity.entities.obstacle.HomeEntity;
import lt.vilniustech.battlecity.graphics.game.player.Home;
import lt.vilniustech.battlecity.graphics.game.player.Tank;
import lt.vilniustech.battlecity.utils.Direction;
import lt.vilniustech.battlecity.utils.Distance;
import lt.vilniustech.battlecity.utils.EntityType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BotEntity extends AbstractPlayerEntity {
    private PlayerEntity playerEntity;
    private HomeEntity homeEntity;
    private static final float PLAYER_SPEED = 12f;

    public BotEntity(Game game, Tank tankSprite) {
        super(game, tankSprite);
    }

    @Override
    public void start() {
        super.start();

        List<Entity> entityList = new ArrayList<>(game.getEntities().values());

        playerEntity = entityList.stream()
                .filter(entity -> entity instanceof PlayerEntity)
                .map(entity -> (PlayerEntity) entity)
                .collect(Collectors.toList())
                .get(0);

        homeEntity = entityList.stream()
                .filter(entity -> entity instanceof HomeEntity)
                .map(entity -> (HomeEntity) entity)
                .collect(Collectors.toList())
                .get(0);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        float playerDistance = Distance.getDistance(this, playerEntity);
        float homeDistance = Distance.getDistance(this, homeEntity);

        if (playerDistance < homeDistance) {
            shootOrDriveAt(playerEntity, Tank.WIDTH * 6f, deltaTime);
        } else {
            shootOrDriveAt(homeEntity, Home.WIDTH * 1.5f, deltaTime);
        }
    }

    @Override
    public void collides(Entity withEntity) {
        CommonWallEntity commonWallEntity = EntityType.isEntity(withEntity, CommonWallEntity.class);
        HomeEntity homeEntity = EntityType.isEntity(withEntity, HomeEntity.class);

        if (homeEntity == null) {
            super.collides(withEntity);
        }

        if (commonWallEntity != null) {
            shoot();
        }
    }

    private void shootOrDriveAt(Entity entity, float shootingDistance, float deltaTime) {
        float distance = Distance.getDistance(this, entity);

        if (botShoot(distance, shootingDistance)) {
            return;
        }

        if (moveY(entity, deltaTime)) {
            return;
        }

        moveX(entity, deltaTime);
    }

    private boolean moveX(Entity entity, float deltaTime) {
        float signum = Math.signum(deltaX);
        float deltaX = Distance.getDeltaX(this, entity);

        if (Math.abs(deltaX) < 1) {
            return false;
        }

        move(signum * PLAYER_SPEED * deltaTime, 0);

        if (signum > 0) {
            getTankSprite().setCurrentDirection(Direction.RIGHT);
        } else {
            getTankSprite().setCurrentDirection(Direction.LEFT);
        }

        return true;
    }

    private boolean moveY(Entity entity, float deltaTime) {
        float deltaY = Distance.getDeltaY(this, entity);
        float signum = Math.signum(deltaY);

        if (Math.abs(deltaY) < 1) {
            return false;
        }

        move(0, signum * PLAYER_SPEED * deltaTime);

        if (signum > 0) {
            getTankSprite().setCurrentDirection(Direction.DOWN);
        } else {
            getTankSprite().setCurrentDirection(Direction.UP);
        }

        return true;
    }

    private boolean botShoot(float distance, float shootingDistance) {
        if (distance < shootingDistance) {
            shoot();
            return true;
        }

        return false;
    }
}