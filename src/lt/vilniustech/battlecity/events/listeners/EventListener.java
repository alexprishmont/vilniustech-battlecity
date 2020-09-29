package lt.vilniustech.battlecity.events.listeners;

import lt.vilniustech.battlecity.events.publisher.Event;

public interface EventListener {
    void update(String eventType, Event event);
}
