package lt.vilniustech.battlecity.entities.player;

import lt.vilniustech.battlecity.graphics.game.player.Tank;

public abstract class AbstractPlayer {
    protected float posX;
    protected float posY;
    protected Tank tankSprite;

    public static final float PLAYER_SPEED = 8.5f;
    private static final float BULLET_SPEED = 15f;
    private static final int BULLET_RANGE = 25;

    public AbstractPlayer(Tank tankSprite) {
        this.tankSprite = tankSprite;
        posX = this.tankSprite.getX();
        posY = this.tankSprite.getY();
    }

    public void move(float x, float y) {
        posX += x;
        posY += y;

        tankSprite.setX(Math.round(posX));
        tankSprite.setY(Math.round(posY));

        changeDirection(x, y);
    }

    public void shoot() {

    }

    public Tank getTankSprite() {
        return tankSprite;
    }

    private void changeDirection(float x, float y) {
        if (y < 0) {
            tankSprite.setCurrentDirection(Tank.DIRECTION_UP);
        } else if (y > 0) {
            tankSprite.setCurrentDirection(Tank.DIRECTION_DOWN);
        }

        if (x < 0) {
            tankSprite.setCurrentDirection(Tank.DIRECTION_LEFT);
        } else if (x > 0) {
            tankSprite.setCurrentDirection(Tank.DIRECTION_RIGHT);
        }
    }
}
