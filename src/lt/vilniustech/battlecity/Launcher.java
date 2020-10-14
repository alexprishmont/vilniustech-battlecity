package lt.vilniustech.battlecity;

import lt.vilniustech.battlecity.graphics.gui.GUI;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class Launcher {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        SwingUtilities.invokeAndWait(() -> {
            try {
                GUI.getInstance().initialize("Battlecity", 1485, 620);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
