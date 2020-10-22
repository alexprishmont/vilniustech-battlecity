package lt.vilniustech.battlecity.game.states;

public class StateManager {
    private static final StateManager instance = new StateManager();
    private State currentState;

    private StateManager() {
    }

    public static StateManager getInstance() {
        return instance;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
        this.currentState.update();
    }

    public State getCurrentState() {
        return currentState;
    }
}
