package lt.vilniustech.battlecity;

import lt.vilniustech.battlecity.graphics.gui.GUI;

public class Launcher {
    public static void main(String[] args) {
        GUI.getInstance().initialize("Battlecity", 1280, 720);
    }
}
