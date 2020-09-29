package lt.vilniustech.battlecity.entity;

import lt.vilniustech.battlecity.events.publisher.Event;
import lt.vilniustech.battlecity.events.publisher.EventManager;

import java.util.ArrayList;
import java.util.List;

public class AbstractPlayer implements Player {
    private static final int PLAYER_TYPE_NPC = 4;
    private static final int PLAYER_TYPE_HUMAN = 3;

    private static final float acceleration = 3f;
    private int dX;
    private int dY;

    private final EventManager eventManager;

    public AbstractPlayer(int startX, int startY) {
        setStartPosition(startX, startY);
        eventManager = new EventManager("playerMoved");
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    @Override
    public void move(int x, int y) {
        dX += x * acceleration;
        dY += y * acceleration;
        eventManager.notify("playerMoved", ArrayList::new);
    }

    @Override
    public void setStartPosition(int x, int y) {
        dX = x;
        dY = y;
    }

    public Integer[] getPosition() {
        return new Integer[]{dX, dY};
    }

    public boolean isPlayerHuman(int playerType) {
        return playerType == PLAYER_TYPE_HUMAN;
    }

    public boolean isPlayerNPC(int playerType) {
        return playerType == PLAYER_TYPE_NPC;
    }
}
