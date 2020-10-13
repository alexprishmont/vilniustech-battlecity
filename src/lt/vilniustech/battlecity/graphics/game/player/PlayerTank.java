package lt.vilniustech.battlecity.graphics.game.player;

import java.awt.*;

public class PlayerTank extends Tank {
    static {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        images = new Image[]{
                toolkit.getImage(Tank.class.getResource("sprites/HtankD.gif")),
                toolkit.getImage(Tank.class.getResource("sprites/HtankU.gif")),
                toolkit.getImage(Tank.class.getResource("sprites/HtankL.gif")),
                toolkit.getImage(Tank.class.getResource("sprites/HtankR.gif")),
        };
    }

    public PlayerTank(int x, int y) {
        super(x, y);
    }
}
