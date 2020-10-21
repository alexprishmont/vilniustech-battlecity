package lt.vilniustech.battlecity.entities;

import lt.vilniustech.battlecity.game.Game;
import lt.vilniustech.battlecity.graphics.game.Drawable;
import lt.vilniustech.battlecity.graphics.game.GameGraphics;

import java.awt.*;

public abstract class Entity implements Drawable, Collideable {
    protected final Game game;
    protected final GameGraphics sprite;

    public Entity(Game game, GameGraphics sprite) {
        this.game = game;
        this.sprite = sprite;
        this.game.getEntities().put(this, this);
    }

    public void destroy() {
        this.game.getEntities().remove(this);
    }

    @Override
    public void draw(Graphics graphics) {
        this.sprite.draw(graphics);
    }

    public boolean intersects(Entity entity) {
        return sprite.getRectangle().intersects(entity.getSprite().getRectangle());
    }

    public GameGraphics getSprite() {
        return sprite;
    }

    @Override
    public void collides(Entity withEntity) {
    }
    
    public abstract void update(float deltaTime);

    public abstract void start();
}
