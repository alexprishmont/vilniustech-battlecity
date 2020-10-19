package lt.vilniustech.battlecity.graphics.game.player;

import lt.vilniustech.battlecity.graphics.game.GameGraphics;

import java.awt.*;

public class Score extends GameGraphics {
    private static final String SCORE_TEXT = "Score ";
    private int score = 0;

    public Score(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setFont(new Font("Times New Roman", Font.BOLD, 20));
        graphics.drawString(SCORE_TEXT + score, getX(), getY());
    }

    @Override
    public Rectangle getRectangle() {
        return null;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
