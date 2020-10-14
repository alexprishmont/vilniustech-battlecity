package lt.vilniustech.battlecity.graphics.gui.pause;

import lt.vilniustech.battlecity.graphics.gui.FormProvider;
import lt.vilniustech.battlecity.graphics.gui.GUI;
import lt.vilniustech.battlecity.graphics.gui.menu.MenuForm;

import javax.swing.*;

public class PauseForm implements FormProvider {
    private final FormProvider previousForm;
    private JButton resumeGame;
    private JButton mainMenu;
    private JPanel pausePanel;

    public PauseForm(FormProvider formProvider) {
        this.previousForm = formProvider;

        resumeGame.addActionListener(event -> GUI.getInstance().switchContentPane(previousForm));
        mainMenu.addActionListener(event -> GUI.getInstance().switchContentPane(new MenuForm()));
    }

    @Override
    public JPanel getPanel() {
        return pausePanel;
    }
}
