package lt.vilniustech.battlecity;

public class Game {
    private Thread gameThread;

    public void hello() {
        gameThread = new Thread(() -> {
            while (true) {

            }
        });

        gameThread.start();
    }
}
