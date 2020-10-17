package lt.vilniustech.battlecity.entities.player;

import lt.vilniustech.battlecity.Game;
import lt.vilniustech.battlecity.entities.BulletEntity;
import lt.vilniustech.battlecity.entities.Destroyable;
import lt.vilniustech.battlecity.entities.Entity;
import lt.vilniustech.battlecity.entities.Healable;
import lt.vilniustech.battlecity.graphics.game.bullet.Bullet;
import lt.vilniustech.battlecity.graphics.game.player.Tank;
import lt.vilniustech.battlecity.utils.Collision;
import lt.vilniustech.battlecity.utils.Direction;


public abstract class AbstractPlayer extends Entity implements Destroyable, Healable {
    protected float posX;
    protected float posY;
    protected float timeBetweenShots = 2f;
    protected float currentTime = 0f;
    protected float health = 100f;
    protected Collision collision;

    public static final float PLAYER_SPEED = 8.5f;

    public AbstractPlayer(Game game, Tank tankSprite) {
        super(game, tankSprite);
        posX = this.sprite.getX();
        posY = this.sprite.getY();
        collision = new Collision(game);
    }

    @Override
    public void start() {
        currentTime = timeBetweenShots;
    }

    @Override
    public void update(float deltaTime) {
        currentTime += deltaTime;
    }

    public void move(float x, float y) {
        posX += x;
        posY += y;

        sprite.setX(Math.round(posX));
        sprite.setY(Math.round(posY));

        if (collision.collides(this)) {
            posX -= x;
            posY -= y;

            sprite.setX(Math.round(posX));
            sprite.setY(Math.round(posY));
        }
    }

    public void shoot() {
        if (currentTime < timeBetweenShots) {
            return;
        }

        Bullet bullet = new Bullet(new Direction(), Math.round(posX), Math.round(posY));
        bullet.setDirection(getTankSprite().getCurrentDirection());
        new BulletEntity(game, bullet);

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
