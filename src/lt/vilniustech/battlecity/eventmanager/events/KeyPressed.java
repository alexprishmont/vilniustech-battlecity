package lt.vilniustech.battlecity.eventmanager.events;

import lt.vilniustech.battlecity.eventmanager.Event;

public class KeyPressed extends Event {
    private final String pressedKey;

    public KeyPressed(String pressedKeyCode) {
        pressedKey = pressedKeyCode;
    }

    public String getPressedKey() {
        return pressedKey;
    }
}
