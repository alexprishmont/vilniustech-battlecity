package lt.vilniustech.battlecity.states;

public class AbstractState {
    private static final int STATE_MENU = 0;
    private static final int STATE_PLAYING = 1;
    private static final int STATE_PAUSE = 2;
    private static final int STATE_GAME_OVER = 3;
    private static final int STATE_WIN = 4;

    private int currentState;

    public void setState(int state) {
        currentState = state;
    }

    public int getState() {
        return currentState;
    }

    public boolean isStateInMenu() {
        return currentState == STATE_MENU;
    }

    public boolean isStatePlaying() {
        return currentState == STATE_PLAYING;
    }

    public boolean isStatePause() {
        return currentState == STATE_PAUSE;
    }

    public boolean isStateGameOver() {
        return currentState == STATE_GAME_OVER;
    }

    public boolean isStateWin() {
        return currentState == STATE_WIN;
    }
}
