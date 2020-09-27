package lt.vilniustech.battlecity.graphics.client;

import lt.vilniustech.battlecity.Launcher;
import lt.vilniustech.battlecity.graphics.FormProvider;
import javax.swing.JFrame;
import java.awt.*;

public class Client extends JFrame {

    private FormProvider currentForm = null;

    public Client(FormProvider formProvider, String windowTitle) {
        int windowHeight = Launcher.WINDOW_HEIGHT;
        int windowWidth = Launcher.WINDOW_WIDTH;

        setPreferredSize(new Dimension(windowWidth, windowHeight));
        setTitle(windowTitle);
        setContentPane(formProvider.getMainPanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);

        currentForm = formProvider;
    }

    public void updateContentPane(FormProvider formProvider) {
        if (currentForm != null) {
            remove(currentForm.getMainPanel());
        }

        setContentPane(formProvider.getMainPanel());
        pack();
        setVisible(true);
    }

}
