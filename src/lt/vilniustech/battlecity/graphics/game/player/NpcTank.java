package lt.vilniustech.battlecity.graphics.game.player;

import java.awt.*;

public class NpcTank extends Tank {
    static {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        images = new Image[]{
                toolkit.getImage(Tank.class.getResource("sprites/tankD.gif")),
                toolkit.getImage(Tank.class.getResource("sprites/tankU.gif")),
                toolkit.getImage(Tank.class.getResource("sprites/tankL.gif")),
                toolkit.getImage(Tank.class.getResource("sprites/tankR.gif")),
        };
    }

    public NpcTank(int x, int y) {
        super(x, y);
    }
}
