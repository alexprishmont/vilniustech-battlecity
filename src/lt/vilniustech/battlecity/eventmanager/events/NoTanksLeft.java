package lt.vilniustech.battlecity.eventmanager.events;

import lt.vilniustech.battlecity.eventmanager.Event;

public class NoTanksLeft extends Event {
    private int score;

    public NoTanksLeft(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
