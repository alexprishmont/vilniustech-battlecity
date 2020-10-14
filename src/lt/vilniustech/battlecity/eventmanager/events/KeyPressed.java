package lt.vilniustech.battlecity.eventmanager.events;

import lt.vilniustech.battlecity.eventmanager.Event;

public class KeyPressed extends Event {
    private final char pressedKey;

    public KeyPressed(char pressedKeyCode) {
        pressedKey = pressedKeyCode;
    }

    public char getPressedKey() {
        return pressedKey;
    }
}
