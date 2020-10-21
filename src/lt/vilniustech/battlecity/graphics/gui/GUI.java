package lt.vilniustech.battlecity.graphics.gui;

import lt.vilniustech.battlecity.game.Game;
import lt.vilniustech.battlecity.game.GameThread;
import lt.vilniustech.battlecity.eventmanager.EventListener;
import lt.vilniustech.battlecity.eventmanager.EventManager;
import lt.vilniustech.battlecity.eventmanager.events.PaneChanged;
import lt.vilniustech.battlecity.graphics.gui.game.GameForm;
import lt.vilniustech.battlecity.graphics.gui.menu.MenuForm;
import lt.vilniustech.battlecity.listeners.KeyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GUI extends JFrame {
    private static final EventManager eventManager = new EventManager(PaneChanged.class);
    private static GUI instance = null;
    private FormProvider currentForm;
    private GameThread gameThread;


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
                    if (e.getID() == KeyEvent.KEY_RELEASED) {
                        keyListener.keyReleased(e);
                    } else if (e.getID() == KeyEvent.KEY_PRESSED) {
                        keyListener.keyPressed(e);
                    }
                    return false;
                });


        eventManager.subscribe(PaneChanged.class, (EventListener<PaneChanged>) (event) -> {
            if (event.getForm() instanceof GameForm) {
                if (gameThread == null) {
                    gameThread = new GameThread(new Game());
                    gameThread.start();
                    return;
                }
                gameThread.unpause();
                return;
            }

            if (event.getForm() instanceof MenuForm) {
                if (gameThread != null) {
                    gameThread.stop();
                    gameThread = null;
                    return;
                }
            }

            assert gameThread != null;
            gameThread.pause();
        });
    }

    public void switchContentPane(FormProvider form) {
        if (currentForm != null) {
            remove(currentForm.getPanel());
        }
        setContentPane(form.getPanel());
        repaint();
        pack();
        currentForm = form;
        eventManager.notify(new PaneChanged(form));
    }
}
