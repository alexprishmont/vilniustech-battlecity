package lt.vilniustech.battlecity.entities;

import lt.vilniustech.battlecity.Game;
import lt.vilniustech.battlecity.eventmanager.events.TankKilled;
import lt.vilniustech.battlecity.graphics.game.Score;

public class ScoreEntity extends Entity implements NonCollideable {
    private static int score = 0;

    public ScoreEntity(Game game, Score sprite) {
        super(game, sprite);
        BulletEntity.getEventManager().subscribe(TankKilled.class, event -> {
            score ++;
            sprite.setScore(score);
        });
    }

    public static int getScore() {
        return score;
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void start() {

    }
}
