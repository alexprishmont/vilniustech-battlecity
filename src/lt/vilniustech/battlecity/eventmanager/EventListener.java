package lt.vilniustech.battlecity.eventmanager;

public interface EventListener<T extends Event> {
    void update(T event);
}
