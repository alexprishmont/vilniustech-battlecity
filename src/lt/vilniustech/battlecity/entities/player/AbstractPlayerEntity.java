package lt.vilniustech.battlecity.entities.player;

import lt.vilniustech.battlecity.Game;
import lt.vilniustech.battlecity.entities.*;
import lt.vilniustech.battlecity.graphics.game.bullet.Bullet;
import lt.vilniustech.battlecity.graphics.game.player.Tank;
import lt.vilniustech.battlecity.utils.Direction;
import lt.vilniustech.battlecity.utils.EntityType;


public abstract class AbstractPlayerEntity extends Entity implements Destroyable, Healable {
    protected float posX;
    protected float posY;
    protected float deltaX;
    protected float deltaY;
    protected float timeBetweenShots = 2f;
    protected float currentTime = 0f;
    protected float health = 100f;
    protected static final float PLAYER_SPEED = 8.5f;

    public AbstractPlayerEntity(Game game, Tank tankSprite) {
        super(game, tankSprite);
        posX = this.sprite.getX();
        posY = this.sprite.getY();
    }

    @Override
    public void start() {
        currentTime = timeBetweenShots;
    }

    @Override
    public void update(float deltaTime) {
        currentTime += deltaTime;
    }

    @Override
    public void collides(Entity withEntity) {
        BulletEntity bulletEntity = EntityType.isEntity(withEntity, BulletEntity.class);
        Driveable driveable = EntityType.isEntity(withEntity, Driveable.class);

        if (bulletEntity != null) {
            return;
        }

        if (driveable != null) {
            return;
        }

        posX -= deltaX;
        posY -= deltaY;

        sprite.setX(Math.round(posX));
        sprite.setY(Math.round(posY));
    }

    public void move(float x, float y) {
        posX += x;
        posY += y;

        deltaX = x;
        deltaY = y;

        sprite.setX(Math.round(posX));
        sprite.setY(Math.round(posY));
    }

    public void shoot() {
        if (currentTime < timeBetweenShots) {
            return;
        }

        Bullet bullet = new Bullet(new Direction(), Math.round(posX), Math.round(posY));
        bullet.setDirection(getTankSprite().getCurrentDirection());
        new BulletEntity(this, game, bullet);

        currentTime = 0;
    }

    public Tank getTankSprite() {
        return (Tank) sprite;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }
}
