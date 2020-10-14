package lt.vilniustech.battlecity;

import lt.vilniustech.battlecity.State.KeyState;
import lt.vilniustech.battlecity.State.State;
import lt.vilniustech.battlecity.entities.player.AbstractPlayer;
import lt.vilniustech.battlecity.entities.player.Player;
import lt.vilniustech.battlecity.graphics.game.player.Tank;

public class Game {
    private Player player;
    private KeyState keyState;

    public Game() {
        player = new Player();
        keyState = KeyState.getInstance();
    }

    public void start() {
        System.out.println("Started");
    }

    public void update(float deltaTime) {
        if (keyState.getState('W') == State.DOWN) {
            player.move(0, -AbstractPlayer.PLAYER_SPEED * deltaTime);
        }
        else if (keyState.getState('S') == State.DOWN) {
            player.move(0, AbstractPlayer.PLAYER_SPEED * deltaTime);
        }
        else if (keyState.getState('A') == State.DOWN) {
            player.move(-AbstractPlayer.PLAYER_SPEED * deltaTime, 0);
        }
        else if (keyState.getState('D') == State.DOWN) {
            player.move(AbstractPlayer.PLAYER_SPEED * deltaTime, 0);
        }
    }
}
