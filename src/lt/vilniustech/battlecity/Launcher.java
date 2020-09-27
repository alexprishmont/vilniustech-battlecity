package lt.vilniustech.battlecity;

import lt.vilniustech.battlecity.graphics.client.Client;
import lt.vilniustech.battlecity.graphics.menu.MainMenuForm;

public class Launcher {

    public static final int WINDOW_WIDTH = 1286;
    public static final int WINDOW_HEIGHT = 730;

    private static Client currentClient = null;

    public static void main(String[] args) {
        currentClient = new Client(new MainMenuForm(), "Battlecity");
    }

    public static Client getCurrentClient() {
        return currentClient;
    }
}
