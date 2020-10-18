package lt.vilniustech.battlecity.eventmanager.events;

import lt.vilniustech.battlecity.eventmanager.Event;

public class HomeDestroy extends Event {
    private int score;

    public HomeDestroy(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
