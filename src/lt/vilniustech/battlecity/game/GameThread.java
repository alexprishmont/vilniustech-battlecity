package lt.vilniustech.battlecity.game;

import lt.vilniustech.battlecity.graphics.gui.GUI;

import javax.swing.*;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class GameThread {
    private final Game game;
    private volatile boolean started = false;
    private volatile boolean paused = false;
    private Instant previousTime;
    private Instant currentTime;

    public GameThread(Game game) {
        this.game = game;
    }

    public Runnable getRunnable() {
        return () -> {
            game.start();
            previousTime = Instant.now();
            while (started) {
                if (paused) {
                    continue;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                currentTime = Instant.now();
                game.update(1f / ChronoUnit.MILLIS.between(previousTime, currentTime));
                repaintOnEDT();
                previousTime = currentTime;
            }
        };
    }

    public void stop() {
        started = false;
    }

    public void pause() {
        paused = true;
    }

    public void unpause() {
        paused = false;
    }

    public void start() {
        if (!started) {
            started = true;
            new Thread(getRunnable()).start();
        }
    }

    public void repaintOnEDT() {
        new SwingWorker<>() {
            @Override
            protected Object doInBackground() {
                return null;
            }

            @Override
            protected void done() {
                GUI.getInstance().repaint();
            }
        }.run();
    }
}
