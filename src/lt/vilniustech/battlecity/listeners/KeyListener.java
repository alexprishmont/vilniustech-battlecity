package lt.vilniustech.battlecity.listeners;

import lt.vilniustech.battlecity.state.KeyState;
import lt.vilniustech.battlecity.state.State;

import java.awt.event.KeyEvent;


public class KeyListener implements java.awt.event.KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char key = Character.toUpperCase(e.getKeyChar());
        KeyState.getInstance().setState(key, State.DOWN);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        char key = Character.toUpperCase(e.getKeyChar());
        KeyState.getInstance().setState(key, State.UP);
    }
}
