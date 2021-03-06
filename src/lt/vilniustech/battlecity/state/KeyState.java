package lt.vilniustech.battlecity.state;

import lt.vilniustech.battlecity.eventmanager.Event;
import lt.vilniustech.battlecity.eventmanager.EventListener;
import lt.vilniustech.battlecity.eventmanager.EventManager;
import lt.vilniustech.battlecity.eventmanager.events.KeyPressed;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class KeyState {
    private static KeyState instance;
    private final Map<Character, State> keyStates = new ConcurrentHashMap<>();
    private static final EventManager eventManager = new EventManager(KeyPressed.class);

    private KeyState() {
    }

    public static KeyState getInstance() {
        if (instance == null) {
            instance = new KeyState();
        }

        return instance;
    }

    public State getState(char keyChar) {
        return keyStates.get(keyChar);
    }

    public void setState(char keyChar, State state) {
        keyStates.put(keyChar, state);
        if (state == State.DOWN) {
            eventManager.notify(new KeyPressed(keyChar));
        }
    }

    public static void subscribeEvent(Class<? extends Event> eventType, EventListener<? extends Event> listener) {
        eventManager.subscribe(eventType, listener);
    }
}
