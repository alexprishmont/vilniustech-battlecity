package lt.vilniustech.battlecity.graphics.game.player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class NpcTank extends Tank {
    static {
        try {
            images = new Image[]{
                    ImageIO.read(new File("sprites/tankD.gif")),
                    ImageIO.read(new File("sprites/tankU.gif")),
                    ImageIO.read(new File("sprites/tankL.gif")),
                    ImageIO.read(new File("sprites/tankR.gif"))
            };
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public NpcTank(int x, int y) {
        super(x, y);
    }
}
