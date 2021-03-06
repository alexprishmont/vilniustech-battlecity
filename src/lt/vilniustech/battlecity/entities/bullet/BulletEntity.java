package lt.vilniustech.battlecity.entities.bullet;

import lt.vilniustech.battlecity.game.Game;
import lt.vilniustech.battlecity.entities.Destroyable;
import lt.vilniustech.battlecity.entities.Driveable;
import lt.vilniustech.battlecity.entities.Entity;
import lt.vilniustech.battlecity.entities.Healable;
import lt.vilniustech.battlecity.entities.obstacle.HomeEntity;
import lt.vilniustech.battlecity.entities.player.AbstractPlayerEntity;
import lt.vilniustech.battlecity.entities.player.PlayerEntity;
import lt.vilniustech.battlecity.eventmanager.events.TankKilled;
import lt.vilniustech.battlecity.graphics.game.bullet.Bullet;
import lt.vilniustech.battlecity.utils.Direction;
import lt.vilniustech.battlecity.utils.EntityType;

public class BulletEntity extends Entity {
    public static final float BULLET_SPEED = 30f;
    public static final float BULLET_DAMAGE = 30f;
    private final Bullet bulletSprite;
    private final AbstractPlayerEntity shotOwner;
    private float posX;
    private float posY;

    public BulletEntity(AbstractPlayerEntity shotOwner, Game game, Bullet bulletSprite) {
        super(game, bulletSprite);
        this.bulletSprite = bulletSprite;
        this.shotOwner = shotOwner;
        posX = this.bulletSprite.getX();
        posY = this.bulletSprite.getY();
    }

    @Override
    public void update(float deltaTime) {
        switch (bulletSprite.getDirection()) {
            case Direction.UP -> move(0, -BULLET_SPEED * deltaTime);
            case Direction.DOWN -> move(0, BULLET_SPEED * deltaTime);
            case Direction.LEFT -> move(-BULLET_SPEED * deltaTime, 0);
            case Direction.RIGHT -> move(BULLET_SPEED * deltaTime, 0);
        }
    }

    @Override
    public void start() {
    }

    @Override
    public void collides(Entity withEntity) {
        Destroyable destroyable = EntityType.isEntity(withEntity, Destroyable.class);
        Healable healable = EntityType.isEntity(withEntity, Healable.class);
        AbstractPlayerEntity playerEntity = EntityType.isEntity(withEntity, AbstractPlayerEntity.class);
        HomeEntity homeEntity = EntityType.isEntity(withEntity, HomeEntity.class);
        Driveable driveable = EntityType.isEntity(withEntity, Driveable.class);

        if (playerEntity == shotOwner) {
            return;
        }

        if (driveable != null) {
            return;
        }

        if (homeEntity != null) {
            homeEntity.destroy();
        }

        if (healable != null) {
            healable.setHealth(healable.getHealth() - BULLET_DAMAGE);
        }

        if (destroyable != null) {
            if (healable != null) {
                if (healable.getHealth() <= 0) {
                    destroyable.destroy();
                    notifyIfNpcTankDestroyed(withEntity);
                }
            } else {
                destroyable.destroy();
            }
        }

        destroy();
    }

    private void move(float x, float y) {
        posX += x;
        posY += y;

        bulletSprite.setX(Math.round(posX));
        bulletSprite.setY(Math.round(posY));
    }

    private void notifyIfNpcTankDestroyed(Entity entity) {
        if (EntityType.isEntity(shotOwner, PlayerEntity.class) == null) {
            return;
        }
        
        if (EntityType.isEntity(entity, AbstractPlayerEntity.class) == null) {
            return;
        }

        game.notifyGameEvent(new TankKilled());
    }
}
