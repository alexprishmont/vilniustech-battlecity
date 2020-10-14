package lt.vilniustech.battlecity.entities.player;

import lt.vilniustech.battlecity.graphics.game.Map;

public class Player extends AbstractPlayer {
    public Player() {
        super(Map.getInstance().getPlayerTank());
    }
}