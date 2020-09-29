package lt.vilniustech.battlecity.entity.player;

import lt.vilniustech.battlecity.entity.AbstractPlayer;
import lt.vilniustech.battlecity.events.listeners.EventListener;
import lt.vilniustech.battlecity.events.publisher.Event;
import lt.vilniustech.battlecity.graphics.client.Client;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends AbstractPlayer {

    public Player(int startX, int startY) {
        super(startX, startY);
        Client.getKeyListener().getEventManager().subscribe("keyPressed", (eventType, event) -> {
            String keyPressed = event.getData().get(0);

            switch (keyPressed) {
                case "MOVE_UP": {
                    move (1, 1);
                    break;
                }
                case "MOVE_DOWN": {
                    move(-1, -1);
                    break;
                }
                case "MOVE_LEFT": {

                    break;
                }
                case "MOVE_RIGHT": {

                    break;
                }
            }
        });
    }

}
