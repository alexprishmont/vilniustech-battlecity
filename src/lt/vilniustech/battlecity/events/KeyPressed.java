package lt.vilniustech.battlecity.events;

import lt.vilniustech.battlecity.events.publisher.Event;

import java.util.ArrayList;
import java.util.List;

public class KeyPressed implements Event {
    private final String keyPressed;

    public KeyPressed(String keyPressed) {
        this.keyPressed = keyPressed;
    }

    public List<String> getData() {
        List<String> data = new ArrayList<String>();
        data.add(keyPressed);
        return data;
    }
}
