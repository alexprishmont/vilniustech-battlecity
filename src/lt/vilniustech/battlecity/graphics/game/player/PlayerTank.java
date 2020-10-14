package lt.vilniustech.battlecity.graphics.game.player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PlayerTank extends Tank {
    static {
        try {
            images = new Image[]{
                    ImageIO.read(new File("sprites/HtankD.gif")),
                    ImageIO.read(new File("sprites/HtankU.gif")),
                    ImageIO.read(new File("sprites/HtankL.gif")),
                    ImageIO.read(new File("sprites/HtankR.gif"))
            };
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public PlayerTank(int x, int y) {
        super(x, y);
    }
}
