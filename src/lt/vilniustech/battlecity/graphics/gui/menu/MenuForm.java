package lt.vilniustech.battlecity.graphics.gui.menu;

import lt.vilniustech.battlecity.game.states.MenuState;
import lt.vilniustech.battlecity.game.StateManager;
import lt.vilniustech.battlecity.graphics.gui.FormProvider;
import lt.vilniustech.battlecity.graphics.gui.GUI;
import lt.vilniustech.battlecity.graphics.gui.game.GameForm;

import javax.swing.*;

public class MenuForm implements FormProvider {
    private JPanel menuPanel;
    private JButton playGameBtn;
    private JButton exitBtn;

    public MenuForm() {
        playGameBtn.addActionListener(event -> GUI.getInstance().switchContentPane(new GameForm()));
        exitBtn.addActionListener(event -> System.exit(0));
        StateManager.getInstance().setCurrentState(new MenuState());
    }

    @Override
    public JPanel getPanel() {
        return menuPanel;
    }

    private void createUIComponents() {
        menuPanel = new MenuPanel();
    }
}
