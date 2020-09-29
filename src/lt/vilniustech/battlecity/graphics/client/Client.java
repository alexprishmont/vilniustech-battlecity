package lt.vilniustech.battlecity.graphics.client;

import lt.vilniustech.battlecity.Launcher;
import lt.vilniustech.battlecity.events.listeners.KeyListener;
import lt.vilniustech.battlecity.graphics.FormProvider;

import javax.swing.*;
import java.awt.*;

public class Client extends JFrame {

    private FormProvider currentForm = null;
    private static KeyListener keyListener = null;

    public Client(FormProvider formProvider, String windowTitle) {
        int windowHeight = Launcher.WINDOW_HEIGHT;
        int windowWidth = Launcher.WINDOW_WIDTH;

        setPreferredSize(new Dimension(windowWidth, windowHeight));
        setTitle(windowTitle);
        setContentPane(formProvider.getMainPanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);

        currentForm = formProvider;
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        keyListener = new KeyListener();
        addKeyListener(keyListener);
    }

    public void updateContentPane(FormProvider formProvider) {
        if (currentForm != null) {
            remove(currentForm.getMainPanel());
        }

        setContentPane(formProvider.getMainPanel());
        pack();
        setVisible(true);
        repaint();
    }

    public static KeyListener getKeyListener() {
        return keyListener;
    }
}
