package lt.vilniustech.battlecity.listeners;

import lt.vilniustech.battlecity.eventmanager.EventManager;
import lt.vilniustech.battlecity.eventmanager.events.KeyPressed;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeyListener implements java.awt.event.KeyListener {
    private static final char MOVE_UP = (char) KeyEvent.VK_W;
    private static final char MOVE_DOWN = (char) KeyEvent.VK_S;
    private static final char MOVE_LEFT = (char) KeyEvent.VK_A;
    private static final char MOVE_RIGHT = (char) KeyEvent.VK_D;
    private static final char SHOOT = (char) KeyEvent.VK_SPACE;
    private static final char PAUSE = (char) KeyEvent.VK_ESCAPE;

    private static final Map<Character, String> AVAILABLE_KEYS = new HashMap<Character, String>();

    private static final EventManager eventManager = new EventManager(KeyPressed.class);

    public KeyListener() {
        AVAILABLE_KEYS.put(MOVE_UP, "MOVE_UP");
        AVAILABLE_KEYS.put(MOVE_DOWN, "MOVE_DOWN");
        AVAILABLE_KEYS.put(MOVE_RIGHT, "MOVE_RIGHT");
        AVAILABLE_KEYS.put(MOVE_LEFT, "MOVE_LEFT");
        AVAILABLE_KEYS.put(SHOOT, "SHOOT");
        AVAILABLE_KEYS.put(PAUSE, "PAUSE");
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char key = Character.toUpperCase(e.getKeyChar());

        if (AVAILABLE_KEYS.containsKey(key)) {
            eventManager.notify(
                    new KeyPressed(AVAILABLE_KEYS.get(key))
            );
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static EventManager getEventManager() {
        return eventManager;
    }
}
