package lt.vilniustech.battlecity.eventmanager;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    private final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listeners = new HashMap<>();

    public EventManager(Class<? extends Event>... eventTypes) {
        for (Class<? extends Event> eventType : eventTypes) {
            this.listeners.put(eventType, new ArrayList<>());
        }
    }

    public void subscribe(Class<? extends Event> eventType, EventListener<? extends Event> listener) {
        getUsers(eventType).add(listener);
    }

    public void unsubscribe(Class<? extends Event> eventType, EventListener<? extends Event> listener) {
        getUsers(eventType).remove(listener);
    }

    public void notify(Event event) {
        List<EventListener<? extends Event>> users = listeners.get(event.getClass());
        for (EventListener listener : users) {
            listener.update(event);
        }
    }

    private List<EventListener<? extends Event>> getUsers(Class<? extends Event> eventType) {
        return listeners.get(eventType);
    }
}
