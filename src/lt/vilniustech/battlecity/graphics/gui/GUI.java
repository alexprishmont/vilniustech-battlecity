package lt.vilniustech.battlecity.graphics.gui;

import lt.vilniustech.battlecity.eventmanager.EventManager;
import lt.vilniustech.battlecity.graphics.gui.menu.MenuForm;
import lt.vilniustech.battlecity.listeners.KeyListener;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private static GUI instance = null;
    private FormProvider currentForm;

    private GUI() {
    }

    public static GUI getInstance() {
        if (instance == null) {
            instance = new GUI();
        }

        return instance;
    }

    public void initialize(String windowTitle, int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setTitle(windowTitle);
        switchContentPane(new MenuForm());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        KeyListener keyListener = new KeyListener();
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher(e -> {
                    keyListener.keyPressed(e);
                    return false;
                });
    }

    public void switchContentPane(FormProvider form) {
        if (currentForm != null) {
            remove(currentForm.getPanel());
        }
        setContentPane(form.getPanel());
        pack();
        currentForm = form;
    }
}
