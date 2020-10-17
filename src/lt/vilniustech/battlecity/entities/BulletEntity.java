package lt.vilniustech.battlecity.entities;

import lt.vilniustech.battlecity.Game;
import lt.vilniustech.battlecity.entities.player.PlayerEntity;
import lt.vilniustech.battlecity.graphics.game.bullet.Bullet;
import lt.vilniustech.battlecity.utils.Direction;

public class BulletEntity extends Entity {
    public static final float BULLET_SPEED = 12f;
    private final Bullet bulletSprite;
    private float posX;
    private float posY;

    public BulletEntity(Game game, Bullet bulletSprite) {
        super(game, bulletSprite);
        this.bulletSprite = bulletSprite;
        posX = this.bulletSprite.getX();
        posY = this.bulletSprite.getY();
    }

    @Override
    public void update(float deltaTime) {
        switch (bulletSprite.getDirection()) {
            case Direction.UP -> move (0, -BULLET_SPEED * deltaTime);
            case Direction.DOWN -> move (0, BULLET_SPEED * deltaTime);
            case Direction.LEFT -> move (-BULLET_SPEED * deltaTime, 0);
            case Direction.RIGHT -> move (BULLET_SPEED * deltaTime, 0);
        }

        hit();
    }

    @Override
    public void start() {

    }

    private void move(float x, float y) {
        posX += x;
        posY += y;

        bulletSprite.setX(Math.round(posX));
        bulletSprite.setY(Math.round(posY));
    }

    private void hit() {
        for (Entity entity : game.getEntities().values()) {
            if (entity == this) {
                break;
            }

            if (sprite.getRectangle().intersects(entity.getSprite().getRectangle())) {
                if (entity instanceof Destroyable) {

                    if (entity instanceof Healable) {
                        if (entity instanceof PlayerEntity) {
                            break;
                        }

                        if (((Healable) entity).getHealth() <= 0) {
                            entity.destroy();
                            destroy();
                            break;
                        }

                        ((Healable) entity).setHealth(((Healable) entity).getHealth() - 25f);
                    }

                    entity.destroy();
                }

                destroy();
                break;
            }
        }
    }
}
